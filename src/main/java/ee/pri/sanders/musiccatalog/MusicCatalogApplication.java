package ee.pri.sanders.musiccatalog;

import java.util.Arrays;
import java.util.List;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@SpringBootApplication
public class MusicCatalogApplication {
  
  @Bean(name = "thymeleafViewResolver")
  public ViewResolver getThymeleafViewResolver() {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(getThymeleafTemplateEngine());
    resolver.setCache(true);
    return resolver;
  }
  
  @Bean(name ="thymeleafTemplateEngine")
  public SpringTemplateEngine getThymeleafTemplateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(getThymeleafTemplateResolver());
    return templateEngine;
  }
  @Bean(name ="thymeleafTemplateResolver")
  public ServletContextTemplateResolver getThymeleafTemplateResolver() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setPrefix("/thymeleaf/");
    templateResolver.setSuffix(".htm");
    return templateResolver;
  }
  
  @Bean(name = "viewResolver")
  public ViewResolver contentNegotiatingViewResolver(
      ContentNegotiationManager manager) {
    List<ViewResolver> resolvers = Arrays.asList(getThymeleafViewResolver());
    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    resolver.setViewResolvers(resolvers);
    resolver.setContentNegotiationManager(manager);
    return resolver;
  }
  
  // TODO temporary - H2 console
  @Bean
  ServletRegistrationBean h2servletRegistration() {
      ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
      registrationBean.addUrlMappings("/console/*");
      return registrationBean;
  }

	public static void main(String[] args) {
		SpringApplication.run(MusicCatalogApplication.class, args);
	}
}
