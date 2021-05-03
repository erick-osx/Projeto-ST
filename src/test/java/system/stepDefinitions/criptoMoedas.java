package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import system.pages.MainPage;

public class criptoMoedas {

    MainPage mainPage = new MainPage();

    @Given("acessou a tela de principais criptomoedas")
    public void acessouATelaDePrincipaisCriptomoedas() throws InterruptedException {
        mainPage.acessarPrincipaisCriptomoedas();
    }
    @When("o usuario realiza a busca por {string}")
    public void oUsuarioRealizaABuscaPor(String moeda) {
        mainPage.realizarBuscaCripto(moeda);
    }
    @Then("o primeiro item da tabela deve exibir Bitcoin")
    public void oPrimeiroItemDaTabelaDeveConterBTC() {
        String resultado = mainPage.pegarPrimeiroItemTabela();
        Assertions.assertTrue(resultado.contains("BTC"));
        System.out.println(resultado);
    }

}
