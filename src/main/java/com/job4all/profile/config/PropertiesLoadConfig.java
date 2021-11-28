package com.job4all.profile.config;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.StandardServletEnvironment;

//@Configuration
public class PropertiesLoadConfig extends PropertySourcesPlaceholderConfigurer {

	private static final String ENVIRONMENT_PROPERTIES = "environmentProperties";
	private static final String ENV_PROPERTIES = "classpath*:#{systemEnvironment['ENV']?:'local'}/*.properties)";

//	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfig() {
	      PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	        propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource(ENV_PROPERTIES));
	        return propertySourcesPlaceholderConfigurer;
	}

	@Override
	public void postProcessBeanFactory(
	    final ConfigurableListableBeanFactory beanFactory)
	    throws BeansException {
	
	    super.postProcessBeanFactory(beanFactory);
	
	    final StandardServletEnvironment propertySources =
	        (StandardServletEnvironment) super.getAppliedPropertySources().get(ENVIRONMENT_PROPERTIES).getSource();
	
	    propertySources.getPropertySources().forEach(propertySource -> {
	        if (propertySource.getSource() instanceof Map) {
	            // it will print systemProperties, systemEnvironment, application.properties and other overrides of
	            // application.properties
	            System.out.println("#######" + propertySource.getName() + "#######");
	
	            final Map<String, String> properties = mapValueAsString((Map<String, Object>) propertySource.getSource());
	            System.out.println(properties);
	        }
	    });
	}
	
	private Map<String, String> mapValueAsString(
	    final Map<String, Object> map) {
	
	    return map.entrySet().stream()
	        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> toString(entry.getValue())));
	}
	
	private String toString(
	    final Object object) {
	
	    return Optional.ofNullable(object).map(value -> value.toString()).orElse(null);
	}
}