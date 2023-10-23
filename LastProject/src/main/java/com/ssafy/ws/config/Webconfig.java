package com.ssafy.ws.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ssafy.ws.interceptor.LoginCheckInterceptor;

import io.swagger.models.HttpMethod;

@Configuration
@EnableWebMvc
public class Webconfig implements WebMvcConfigurer{
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
	}
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:9999/**")
	                .allowedMethods(
	                        HttpMethod.GET.name(),
	                        HttpMethod.HEAD.name(),
	                        HttpMethod.POST.name(),
	                        HttpMethod.PUT.name(),
	                        HttpMethod.DELETE.name());
	    }
	
	
//	@Autowired
//	LoginCheckInterceptor loginCheckInterceptor;
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginCheckInterceptor)
//				.addPathPatterns("/**")
//				.excludePathPatterns("/")
//				.excludePathPatterns("/user/login")
//				.excludePathPatterns("/user/signup");
//	}
	
	
	

}
