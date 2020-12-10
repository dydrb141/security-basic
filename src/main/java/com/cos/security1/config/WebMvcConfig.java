package com.cos.security1.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author YongKyu.Han
 * @since 2020-12-09
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry resolverRegistry) {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset(StandardCharsets.UTF_8.name());
        resolver.setContentType(MediaType.TEXT_HTML.toString() + "; charset= " + StandardCharsets.UTF_8.name());
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");

        resolverRegistry.viewResolver(resolver);
    }
}
