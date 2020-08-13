package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@ComponentScan сообщает Spring где искать компоненты, которыми он должен управлять, т.е. классы,
//помеченные аннотацией @Component или ее производными, такими как @Controller, @Repository, @Service.
//Эти аннотации автоматически определяют бин класса.

//@Configuration сообщает Spring что данный класс является конфигурационным и содержит определения
//и зависимости bean-компонентов.

//@EnableWebMvc позволяет импортировать конфигурацию Spring MVC из класса WebMvcConfigurationSupport.
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web")
//метод возвращающий объект типа ViewResolver, это такой интерфейс,
//необходимый для нахождения представления по имени.
public class WebConfig {

    //В методе viewResolver() мы создаем его реализацию и определяем где именно искать представления в webapp
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
