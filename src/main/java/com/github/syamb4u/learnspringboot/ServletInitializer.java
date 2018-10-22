package com.github.syamb4u.learnspringboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * @author Syam
 *
 * Date Oct 22, 2018
 *
 * learn-springboot
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LearnSpringbootApplication.class);
	}

}
