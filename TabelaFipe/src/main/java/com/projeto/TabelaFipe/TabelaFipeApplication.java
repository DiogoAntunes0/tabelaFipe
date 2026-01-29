package com.projeto.TabelaFipe;

import com.projeto.TabelaFipe.Serviços.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.accept.ContentNegotiationManager;

import java.util.*;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

	private final ContentNegotiationManager contentNegotiationManager;

	public TabelaFipeApplication(ContentNegotiationManager contentNegotiationManager) {
		this.contentNegotiationManager = contentNegotiationManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner ler = new Scanner(System.in);
		BuscarVeiculo buscarVeiculo = new BuscarVeiculo();
		ConverterDados converterDados = new ConverterDados();


		System.out.println("Qual veículo deseja consultar? (Digite o veículo)");
		System.out.println("Carros.");
		System.out.println("Motos.");
		System.out.println("Caminhoes.");

			String nomeVeiculo = ler.nextLine();
			String ENDERECO = "https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo.toLowerCase() + "/marcas";

			String veiculo = buscarVeiculo.buscarVeiculo(ENDERECO);

			List<Veiculo> veiculoList = converterDados.obterLista(veiculo, Veiculo.class);
			veiculoList.forEach(System.out::println);

		System.out.println("Digite o código da marca do veículo: ");
		String cod = ler.nextLine();

		String ENDERECO2 = "https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo.toLowerCase() + "/marcas/" + cod + "/modelos";

		String marca = buscarVeiculo.buscarVeiculo(ENDERECO2);

		ModelosWrapper modelosWrapper = converterDados.ConverteDados(marca, ModelosWrapper.class);

		List<Marca> marcaVeiculos = modelosWrapper.modelos();
		marcaVeiculos.forEach(System.out::println);





		/*System.out.println("Digite o modelo: (CÓDIGO)");
		String marca = ler.nextLine();
		ENDERECO = "https://parallelum.com.br/fipe/api/v1/" + veiculo + "/marcas/" + marca + "/modelos";
		json = buscarVeiculo.buscarVeiculo(ENDERECO);
		System.out.println(json);

		System.out.println("Digite o ano do veículo: (CÓDIGO)");
		String modelo = ler.nextLine();
		ENDERECO = "https://parallelum.com.br/fipe/api/v1/" + veiculo + "/marcas/" + marca + "/modelos/" + modelo + "/anos";
		json = buscarVeiculo.buscarVeiculo(ENDERECO);
		System.out.println(json);

		System.out.println("Digite o ano do veículo: (CÓDIGO)");
		String anoVeiculo = ler.nextLine();
		ENDERECO = "https://parallelum.com.br/fipe/api/v1/" + veiculo + "/marcas/" + marca + "/modelos/" + modelo + "/anos/" + anoVeiculo;
		json = buscarVeiculo.buscarVeiculo(ENDERECO);
		System.out.println(json);
*/
	}
}
