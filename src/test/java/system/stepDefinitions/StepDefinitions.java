package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import system.pages.MainPage;

public class StepDefinitions {


    MainPage mainPage = new MainPage();
    String resultado;

    @Given("o usuario acessou a aplicacao")
    public void oUsuarioAcessouAAplicacao() {
        mainPage.acessarPagina();
    }
    @Given("aceitou os termos e politicas")
    public void aceitouOsTermosEPoliticas() {
        mainPage.aceitarTermos();
    }
    @Given("acessou a ferramenta de calculo de lucro")
    public void acessouAFerramentaDeCalculoDeLucro() {
        mainPage.acessarCalculadoraLucro();
    }

    @When("o usuario realiza o calculo informando o par de moeda {string}, moeda da conta {string},tamanho da negociacao {string},preco de abertura {string}, preco de fechamento {string}")
    public void oUsuarioRealizaOCalculo(String parMoeda, String moedaConta, String tamNego, String abertura, String fechamento) {
        this.resultado = mainPage.fazerCalculoLucro(
                parMoeda, moedaConta, tamNego, abertura, fechamento);
    }

    @Then("o resultado do calculo eh exibido")
    public void oResultadoDoCalculoEhExibido() {
        Assertions.assertNotNull(this.resultado,"Resultado atual de acordo com o cambio do momento");
    }
}
