package com.projeto.TabelaFipe.Services;

import com.projeto.TabelaFipe.Controller.fipeAPI;
import com.projeto.TabelaFipe.Dto.*;
import com.projeto.TabelaFipe.Exception.VeiculoNaoEncontrado;
import java.util.List;
import java.util.Scanner;

public class FipeService {

    private fipeAPI api = new fipeAPI();
    private ConverterDados conversor = new ConverterDados();
    private Scanner ler = new Scanner(System.in);
    private String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

  public void exibeMenu() {

      while(true){
          try{
              System.out.println("\n- Qual veículo deseja consultar? (carros, motos ou caminhoes)");
              System.out.println("- Sair");
              String tipoVeiculo = ler.nextLine().toLowerCase();

              if(tipoVeiculo.equalsIgnoreCase("sair")){break;}

              if(!tipoVeiculo.matches("carros|motos|caminhoes")){
                  System.out.println("Veículo não encontrado, tente novamente!");
                  continue;
              }
                  //buscar marcas
                  String veiculo = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas");
                  List<Veiculo> veiculoList = conversor.obterLista(veiculo, Veiculo.class);
                  veiculoList.forEach(System.out::println);

                  //buscar modelos
                  System.out.println("\nDigite o código da marca do veículo: ");
                  String codMarca = ler.nextLine();

                  String jsonModelos = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas/" + codMarca + "/modelos/");
                  ModelosWrapper modelosWrapper = conversor.ConverteDados(jsonModelos, ModelosWrapper.class);

                  List<Marca> marcaVeiculos = modelosWrapper.modelos();
                  marcaVeiculos.forEach(System.out::println);

                  //buscar o ano do modelo selecionado
                  System.out.println("\nDigite o código do modelo que deseja:");
                  String modeloVeiculo = ler.nextLine();

                  String codModelo = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas/" + codMarca + "/modelos/" + modeloVeiculo + "/anos/");
                  System.out.println(codModelo);

                  //buscar os anos do modelo e listar todas as informações do veículo
                  System.out.println("\nDigite o código do ano que deseja (ex: 2007-1)");
                  String anoVeiculo = ler.nextLine();

                  String codAno = api.buscarVeiculo(URL_BASE + tipoVeiculo + "/marcas/" + codMarca + "/modelos/" + modeloVeiculo + "/anos/" + anoVeiculo);
                  AnoVeiculo dadosVeiculo = conversor.ConverteDados(codAno, AnoVeiculo.class);
                  System.out.println(dadosVeiculo.toString());

              } catch (VeiculoNaoEncontrado e){
              System.out.println(e.getMessage());;

              } catch (Exception e){
              System.out.println("\n[ERRO INESPERADO] Verifique os dados e tente novamente.");
              }
          }
      }
  }



