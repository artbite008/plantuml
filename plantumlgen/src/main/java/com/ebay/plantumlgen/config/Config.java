package com.ebay.plantumlgen.config;

import com.ebay.plantumlgen.random.DefaultRandomNumberGenerator;
import com.ebay.plantumlgen.random.RandomGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author denOfProgramming
 *
 */
@Configuration
// Marks this class as configuration
// Specifies which package to scan
@ComponentScan("com.denofprogramming")
// Enables Spring's annotations
@EnableWebMvc
public class Config {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public RandomGenerator randomGenerator() {
		return new DefaultRandomNumberGenerator();
	}
	
		
}
