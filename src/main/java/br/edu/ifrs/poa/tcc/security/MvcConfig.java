package br.edu.ifrs.poa.tcc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("welcome");
    registry.addViewController("/").setViewName("security/index");
    registry.addViewController("/logout").setViewName("security/logout");
    registry.addViewController("/login").setViewName("security/login");
    registry.addViewController("/signup").setViewName("security/signup");
  }

}