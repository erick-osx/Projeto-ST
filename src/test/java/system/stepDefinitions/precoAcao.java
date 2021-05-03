package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import system.pages.MainPage;

public class precoAcao {

    MainPage mainPage = new MainPage();

    @When("o usuario realiza a pesquisa por {string}")
    public void oUsuarioRealizaAPesquisaPor(String ativo) {
        mainPage.pesquisarAtivo(ativo);
    }
    @When("valida o resultado apresentado")
    public void validaOResultadoApresentado() {
        String msg = mainPage.validaResultadoPesquisa();
        Assertions.assertEquals("Resultados para a palavra \"TAEE11\":", msg);
    }
    @When("seleciona o ativo resultante")
    public void selecionaOAtivoResultante() {
        mainPage.selecaoResultadoPesquisa();
    }
    @Then("a tela  da acao eh carregada exibindo o preco do ativo")
    public void oResultadoDoPrecoDeveSerDiferenteDeNulo() {
        String valorAcao = mainPage.pegaValorAcao();
        Assertions.assertNotNull(valorAcao, "Valor da acao do dia");
        System.out.println(valorAcao);
    }
}
