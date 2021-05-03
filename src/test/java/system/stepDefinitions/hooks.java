package system.stepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import system.helpers.DriverManager;
import system.pages.MainPage;


public class hooks {

    @After
    public void finalizar() {
       DriverManager.endSession();
    }

    @Before
    public void iniciar(){
        DriverManager.getDriver();

    }
}
