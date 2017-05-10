package com.xcalculas.study;

import com.google.common.collect.Lists;
import com.xcalculas.study.filter.XssFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.xcalculas.study.mapper")
public class SecondKillApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondKillApplication.class, args);
	}



    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        XssFilter xssFilter = new XssFilter();
        registrationBean.setFilter(xssFilter);
        List<String> urlPatterns = Lists.newArrayList();
        urlPatterns.add("/xss/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
