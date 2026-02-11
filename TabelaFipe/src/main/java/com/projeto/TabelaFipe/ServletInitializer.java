package com.projeto.TabelaFipe;

import com.projeto.TabelaFipe.Principal.TabelaFipeApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TabelaFipeApplication.class);
	}
}
