package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HMCPage;
import utilities.ConfigurationReader;

public class HotelMyCampStepDefinations {
    HMCPage hmcPage = new HMCPage();

    public HotelMyCampStepDefinations() {
    }

    @Then("login linkine tiklar")
    public void login_linkine_tiklar() {
        this.hmcPage.mainPageLogin.click();
    }

    @Then("kullanici adi olarak {string} girer")
    public void kullanici_adi_olarak_girer(String user) {
        this.hmcPage.usernameTextBox.sendKeys(new CharSequence[]{ConfigurationReader.getProperty(user)});
    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String password) {
        this.hmcPage.passwordTextBox.sendKeys(new CharSequence[]{ConfigurationReader.getProperty(password)});
    }

    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        this.hmcPage.loginButonu.click();
    }

    @When("basarili olarak giris yaptigini test eder")
    public void basarili_olarak_giris_yaptigini_test_eder() {
        Assert.assertTrue(this.hmcPage.basariliGirisYaziElementi.isDisplayed());
    }

    @And("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {
        Assert.assertTrue(this.hmcPage.girisYapilamadiYaziElementi.isDisplayed());
    }
}
