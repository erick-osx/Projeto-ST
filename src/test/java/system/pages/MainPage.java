package system.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import java.nio.channels.InterruptedByTimeoutException;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By aceitarTermos = By.cssSelector("#onetrust-accept-btn-handler");
    private By botaoCalculadoraLucro = By.cssSelector("#navMenu a[href='/tools/profit-calculator']");

    public MainPage() {
        driver = DriverManager.getDriver();
    }
    public void acessarPagina() {
        driver.get("https://br.investing.com");
        driver.manage().window().maximize();
    }

    public void aceitarTermos(){
        wait = DriverManager.getDriverWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".banner-actions-container")));
        WebElement termos = driver.findElement(aceitarTermos);
        termos.click();
    }

    public void acessarCalculadoraLucro(){
        Actions act = new Actions(driver);
        WebElement frr = driver.findElement(By.cssSelector("#navMenu a[href='//br.investing.com/tools/']"));
        act.moveToElement(frr).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navMenu a[href='/tools/profit-calculator']")));
        WebElement botaoCalculadora = driver.findElement(botaoCalculadoraLucro);
        botaoCalculadora.click();
    }

    public String fazerCalculoLucro(String parMoeda, String moedaConta, String tamNego, String abertura, String fechamento){
        driver.findElement(By.cssSelector("#forexSearchText")).sendKeys(parMoeda);
        driver.findElement(By.cssSelector("#forex_acc_curr")).sendKeys(moedaConta);
        driver.findElement(By.cssSelector("#forex_trade_size")).clear();
        driver.findElement(By.cssSelector("#forex_trade_size")).sendKeys(tamNego);
        driver.findElement(By.cssSelector("#forex_OTP")).sendKeys(abertura);
        driver.findElement(By.cssSelector("#CTP")).sendKeys(fechamento);
        driver.findElement(By.cssSelector("#forexCalculateButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#msgboxtotal")));
        return driver.findElement(By.cssSelector("#msgboxtotal")).getText();
    }

    public void acessarPrincipaisCriptomoedas() throws InterruptedException {
        //pc = Principais Criptomoedas
        Actions act = new Actions(driver);
        WebElement pc = driver.findElement(By.cssSelector("body"));
        pc.sendKeys(Keys.PAGE_DOWN);
        pc.sendKeys(Keys.PAGE_DOWN);
        WebElement criptoLink = driver.findElement(By.cssSelector("#leftColumn .cryptoHP h2 > a"));
        act.moveToElement(criptoLink).build().perform();
        driver.findElement(By.cssSelector("#leftColumn .cryptoHP h2 > a")).click();
    }

    public void realizarBuscaCripto(String cripto){
        driver.findElement(By.cssSelector("#crypto-table-search")).sendKeys(cripto);
    }

    public String pegarPrimeiroItemTabela(){
        return driver.findElement(By.cssSelector("#fullColumn > div tbody :first-child")).getText();
    }

    public void pesquisarAtivo(String ativo){
        driver.findElement(By.cssSelector(".topBarInnerWrapper .searchBoxContainer input")).sendKeys(ativo, Keys.ENTER);
    }

    public String validaResultadoPesquisa(){
        String msg = driver.findElement(By.cssSelector("#fullColumn >div >h1")).getText();
        return msg;
    }

    public void selecaoResultadoPesquisa(){
        driver.findElement(By.cssSelector(".searchSectionMain a[href='/equities/taesa-unt-n2']")).click();
    }

    public String pegaValorAcao(){
        return driver.findElement(By.cssSelector("span[data-test='instrument-price-last']")).getText();
    }

}
