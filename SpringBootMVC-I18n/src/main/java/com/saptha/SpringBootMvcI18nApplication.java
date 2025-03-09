package com.saptha;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootMvcI18nApplication {
	
	@Bean(name="localeResolver") //fix bean id
	public SessionLocaleResolver createSLResolver() {
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return  resolver;
	}
	
	@Bean(name="lci")
	public LocaleChangeInterceptor createLCI() {
		LocaleChangeInterceptor intercepter=new LocaleChangeInterceptor();
		intercepter.setParamName("lang");
		return intercepter;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcI18nApplication.class, args);
	}

}
