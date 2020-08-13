package web.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//зарегистрировать конфигурацию WebConfig в контексте Spring.
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //Конфигурация Hibernate
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //Веб-конфигурации, где определяются ViewResolver'ы
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //регистрируются адреса
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //добавим фильтр, который будет заниматься предварительной обработкой запросов
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}