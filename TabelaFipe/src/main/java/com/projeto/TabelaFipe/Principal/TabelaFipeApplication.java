package com.projeto.TabelaFipe.Serviços.Principal;

import com.projeto.TabelaFipe.Serviços.*;
import com.projeto.TabelaFipe.Serviços.Controller.BuscarVeiculo;
import com.projeto.TabelaFipe.Serviços.Dto.AnoVeiculo;
import com.projeto.TabelaFipe.Serviços.Dto.Marca;
import com.projeto.TabelaFipe.Serviços.Dto.ModelosWrapper;
import com.projeto.TabelaFipe.Serviços.Dto.Veiculo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

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

		System.out.println("Digite o código do modelo que deseja:");
		String modeloVeiculo = ler.nextLine();

		String ENDERECO3 = "https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo.toLowerCase() + "/marcas/" + cod + "/modelos/" + modeloVeiculo + "/anos";
		String jsonModelos = buscarVeiculo.buscarVeiculo(ENDERECO3);

		System.out.println(jsonModelos);

		System.out.println("Digite o código do ano que deseja");
		String anoVeiculo = ler.nextLine();

		String Endereco = "https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo.toLowerCase() + "/marcas/" + cod + "/modelos/" + modeloVeiculo + "/anos/" + anoVeiculo + "/";

		String jsonAnoVeiculo = buscarVeiculo.buscarVeiculo(Endereco);
		AnoVeiculo anoVeiculo1 = converterDados.ConverteDados(jsonAnoVeiculo, AnoVeiculo.class);
		System.out.println(anoVeiculo1.toString());

	}
}
