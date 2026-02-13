package com.projeto.TabelaFipe.Principal;

import com.projeto.TabelaFipe.Serviços.FipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FipeService fipeService = new FipeService();
		fipeService.exibeMenu();
	}
}
