package com.ebay.plantumlgen.config;

//import com.ebay.plantumlgen.random.DefaultRandomNumberGenerator;
//import com.ebay.plantumlgen.random.RandomGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.ebay.plantumlgen")
@EnableWebMvc
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("/resources/image/");
        registry.addResourceHandler("/html/**").addResourceLocations("/resources/html/");
    }


//	@Bean
//	public RandomGenerator randomGenerator() {
//		return new DefaultRandomNumberGenerator();
//	}
	
		
}
