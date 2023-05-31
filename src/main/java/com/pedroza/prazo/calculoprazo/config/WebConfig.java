package com.pedroza.prazo.calculoprazo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pedroza.prazo.calculoprazo.resources.HomeResource;
import com.pedroza.prazo.calculoprazo.resources.PrazoResource;

@Configuration
@ComponentScan(basePackageClasses = { HomeResource.class, PrazoResource.class })
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

private ApplicationContext applicationContext;

@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
}

}