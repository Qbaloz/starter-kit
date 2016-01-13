//package pl.spring.demo.config;
//
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//@ComponentScan(basePackages = { "pl.spring.demo.*" })
//@EnableAspectJAutoProxy
//public class AppConfig {
//	
//	@Bean
//	public EhCacheCacheManager getEhCacheManager(){
//	        return new EhCacheCacheManager(getEhCacheFactory().getObject());
//	}
//	
//	@Bean
//	public EhCacheManagerFactoryBean getEhCacheFactory(){
//		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//		factoryBean.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
//		factoryBean.setShared(true);
//		return factoryBean;
//	}
//	
//}
