package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication extends WebMvcConfigurerAdapter {

  private static Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
  public LocaleChangeInterceptor localeInterceptor;

  @Bean
  public org.springframework.web.servlet.LocaleResolver localeResolver() {
    LOGGER.error("----------------- register new local resolver");
    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
    cookieLocaleResolver.setCookieName("lang");
    cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
    return cookieLocaleResolver;
  }



  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    localeInterceptor = new LocaleChangeInterceptor();
    localeInterceptor.setParamName("lang");
    registry.addInterceptor(localeInterceptor);

  }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
