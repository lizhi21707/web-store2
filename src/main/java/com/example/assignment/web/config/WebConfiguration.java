package com.example.assignment.web.config;

import com.example.assignment.web.filter.ChartFiler;
import com.example.assignment.web.interceptor.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: Tank.Li
 * @date: 2019/3/15 23:07 Friday
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        AccountInterceptor accountInterceptor = new AccountInterceptor();
        registry.addInterceptor(accountInterceptor);

        ChartInterceptor chartInterceptor = new ChartInterceptor();
        registry.addInterceptor(chartInterceptor);

        DetailInterceptoe detailInterceptoe = new DetailInterceptoe();
        registry.addInterceptor(detailInterceptoe);

        GlobalInterceptor globalInterceptor = new GlobalInterceptor();
        registry.addInterceptor(globalInterceptor);

        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor);

        PublishInterceptor publishInterceptor = new PublishInterceptor();
        registry.addInterceptor(publishInterceptor);
    }

    @Bean
    public ChartFiler chartFiler() {
        return new ChartFiler();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        List<String> pattens = new ArrayList<>(1);
        pattens.add("/*");
        registrationBean.setUrlPatterns(pattens);
        registrationBean.setFilter(chartFiler());
        registrationBean.setOrder(1);

        return registrationBean;
    }
}
