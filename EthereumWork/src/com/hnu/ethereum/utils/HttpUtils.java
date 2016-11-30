package com.hnu.ethereum.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

import com.jfinal.kit.StrKit;




/**
 * JFinal-weixin Http请求工具类
 * @author L.cm
 */
public final class HttpUtils {

    private HttpUtils() {}

    

    
    public static String get(String url) {
        return delegate.get(url);
    }

    public static String get(String url, Map<String, String> queryParas) {
        return delegate.get(url, queryParas);
    }

    public static String post(String url, String data) {
        return delegate.post(url, data);
    }

    public static String postSSL(String url, String data, String certPath, String certPass) {
        return delegate.postSSL(url, data, certPath, certPass);
    }

    public static InputStream download(String url, String params){
        return delegate.download(url, params);
    }

    public static String upload(String url, File file, String params) {
        return delegate.upload(url, file, params);
    }

    /**
     * http请求工具 委托
     * 优先使用OkHttp
     * 最后使用JFinal HttpKit
     */
    private interface HttpDelegate {
        String get(String url);
        String get(String url, Map<String, String> queryParas);

        String post(String url, String data);
        String postSSL(String url, String data, String certPath, String certPass);

        InputStream download(String url, String params);

        String upload(String url, File file, String params);
    }

    // http请求工具代理对象
    private static final HttpDelegate delegate;

    static {
        HttpDelegate delegateToUse = null;
        // okhttp3.OkHttpClient?
        if (ClassUtils.isPresent("okhttp3.OkHttpClient", HttpUtils.class.getClassLoader())) {
            delegateToUse = new OkHttp3Delegate();
        }
       
        delegate = delegateToUse;
    }

    /**
     * OkHttp3代理
     */
    private static class OkHttp3Delegate implements HttpDelegate {
        private okhttp3.OkHttpClient httpClient;

        public OkHttp3Delegate() {
            // 分别设置Http的连接,写入,读取的超时时间
            httpClient = new okhttp3.OkHttpClient().newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }

        private static final okhttp3.MediaType CONTENT_TYPE_FORM =
                okhttp3.MediaType.parse("application/x-www-form-urlencoded");

        private String exec(okhttp3.Request request) {
            try {
                okhttp3.Response response = httpClient.newCall(request).execute();

                if (!response.isSuccessful()) throw new RuntimeException("Unexpected code " + response);

                return response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String get(String url) {
            okhttp3.Request request = new okhttp3.Request.Builder().url(url).get().build();
            return exec(request);
        }

        @Override
        public String get(String url, Map<String, String> queryParas) {
            okhttp3.HttpUrl.Builder urlBuilder = okhttp3.HttpUrl.parse(url).newBuilder();
            for (Entry<String, String> entry : queryParas.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
            okhttp3.HttpUrl httpUrl = urlBuilder.build();
            okhttp3.Request request = new okhttp3.Request.Builder().url(httpUrl).get().build();
            return exec(request);
        }

        @Override
        public String post(String url, String params) {
            okhttp3.RequestBody body = okhttp3.RequestBody.create(CONTENT_TYPE_FORM, params);
            okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .post(body)
                .build();
            return exec(request);
        }

        @Override
        public String postSSL(String url, String data, String certPath, String certPass) {
            okhttp3.RequestBody body = okhttp3.RequestBody.create(CONTENT_TYPE_FORM, data);
            okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .post(body)
                .build();

            InputStream inputStream = null;
            try {
                KeyStore clientStore = KeyStore.getInstance("PKCS12");
                inputStream = new FileInputStream(certPath);
                char[] passArray = certPass.toCharArray();
                clientStore.load(inputStream, passArray);

                KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                kmf.init(clientStore, passArray);
                KeyManager[] kms = kmf.getKeyManagers();
                SSLContext sslContext = SSLContext.getInstance("TLSv1");

                sslContext.init(kms, null, new SecureRandom());

                okhttp3.OkHttpClient httpsClient = new okhttp3.OkHttpClient()
                        .newBuilder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .sslSocketFactory(sslContext.getSocketFactory())
                        .build();

                okhttp3.Response response = httpsClient.newCall(request).execute();

                if (!response.isSuccessful()) throw new RuntimeException("Unexpected code " + response);

                return response.body().string();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }



        @Override
        public InputStream download(String url, String params) {
            okhttp3.Request request;
            if (StrKit.notBlank(params)) {
                okhttp3.RequestBody body = okhttp3.RequestBody.create(CONTENT_TYPE_FORM, params);
                request = new okhttp3.Request.Builder().url(url).post(body).build();
            } else {
                request = new okhttp3.Request.Builder().url(url).get().build();
            }
            try {
                okhttp3.Response response = httpClient.newCall(request).execute();

                if (!response.isSuccessful()) throw new RuntimeException("Unexpected code " + response);

                return response.body().byteStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String upload(String url, File file, String params) {
            okhttp3.RequestBody fileBody = okhttp3.RequestBody
                    .create(okhttp3.MediaType.parse("application/octet-stream"), file);

            okhttp3.MultipartBody.Builder builder = new okhttp3.MultipartBody.Builder()
                    .setType(okhttp3.MultipartBody.FORM)
                    .addFormDataPart("media", file.getName(), fileBody);

            if (StrKit.notBlank(params)) {
                builder.addFormDataPart("description", params);
            }

            okhttp3.RequestBody requestBody = builder.build();
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            return exec(request);
        }

    }


}
