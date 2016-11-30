/**
 * @author semigo
 *
 */
package com.hnu.ethereum.common.config;
//import com.demo.blog.BlogController;
//import com.demo.common.model._MappingKit;
//import com.demo.index.IndexController;
import com.hnu.ethereum.job.SchedulerPlugin;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;

import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
public class EthConfig extends JFinalConfig{
	static Log log = Log.getLog(EthConfig.class);
	Routes routes;    
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		loadProp("config_pro.txt", "config_dev.txt");
		me.setViewType(ViewType.JSP);
		me.setDevMode(true);
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		this.routes = me;
		
	}
	
	
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		 C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		 me.add(c3p0Plugin);
		 
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		arp.setShowSql(true);
		me.add(arp);
		
		
		
		// ehcahce插件配置
//		me.add(new EhCachePlugin());
		
		
		
//		SchedulerPlugin sp = new SchedulerPlugin("job.properties");
//      me.add(sp);
        
        // 所有配置在 MappingKit 中搞定
//		_MappingKit.mapping(arp);
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
	
	
	
	/**
	 * 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
	 * @param pro 生产环境配置文件
	 * @param dev 开发环境配置文件
	 */
	public void loadProp(String pro, String dev) {
		try {
			PropKit.use(pro);
		}
		catch (Exception e) {
			PropKit.use(dev);
		}
	}
	
}
