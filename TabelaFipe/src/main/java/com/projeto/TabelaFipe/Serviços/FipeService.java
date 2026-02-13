package com.projeto.TabelaFipe.Serviços;

import com.projeto.TabelaFipe.Controller.fipeAPI;
import com.projeto.TabelaFipe.Dto.AnoVeiculo;
import com.projeto.TabelaFipe.Dto.Marca;
import com.projeto.TabelaFipe.Dto.ModelosWrapper;
import com.projeto.TabelaFipe.Dto.Veiculo;

import java.util.List;
import java.util.Scanner;

public class FipeService {

    private fipeAPI api = new fipeAPI();
    private ConverterDados conversor = new ConverterDados();
    private Scanner ler = new Scanner(System.in);
    private String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";


  public void exibeMenu(){

      System.out.println("Qual veículo deseja consultar? (carros, motos ou caminhoes)");
      String tipoVeiculo = ler.nextLine().toLowerCase();

      //buscar marcas
      String veiculo = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas");
      List<Veiculo> veiculoList = conversor.obterLista(veiculo, Veiculo.class);
      veiculoList.forEach(System.out::println);

      //buscar modelos
      System.out.println("Digite o código da marca do veículo: ");
      String codMarca = ler.nextLine();

      String jsonModelos = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas/" +  codMarca + "/modelos/");
      ModelosWrapper modelosWrapper = conversor.ConverteDados(jsonModelos, ModelosWrapper.class);

      List<Marca> marcaVeiculos = modelosWrapper.modelos();
      marcaVeiculos.forEach(System.out::println);

      //buscar o ano do modelo selecionado
      System.out.println("Digite o código do modelo que deseja:");
      String modeloVeiculo = ler.nextLine();

      String codModelo = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas/" +  codMarca + "/modelos/" + modeloVeiculo + "/anos/");
      System.out.println(codModelo);

      //buscar os anos do modelo e listar todas as informações do veículo
      System.out.println("Digite o código do ano que deseja");
      String anoVeiculo = ler.nextLine();

      String codAno = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas/" +  codMarca + "/modelos/" + modeloVeiculo + "/anos/" + anoVeiculo);
      AnoVeiculo dadosVeiculo = conversor.ConverteDados(codAno, AnoVeiculo.class);
      System.out.println(dadosVeiculo.toString());
  }
}

