package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AmazonStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();

    public AmazonStepDefinitions() {
    }

    @Given("kullanici amazon sayfasına gider")
    public void kullanici_amazon_sayfasına_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonURL"));
    }

    @Then("sonuclarin iphone icerdiğini test eder")
    public void sonuclarin_iphone_icerdiğini_test_eder() {
        this.amazonPage.aramaKutusu.sendKeys(new CharSequence[]{"iphone" + Keys.ENTER});
    }

    @Given("teapot icin arama yapar")
    public void teapot_icin_arama_yapar() {
        this.amazonPage.aramaKutusu.sendKeys(new CharSequence[]{"teapot" + Keys.ENTER});
    }

    @Then("sonuclarin tea pot icerdiğini test eder")
    public void sonuclarin_tea_pot_icerdiğini_test_eder() {
        String sonuc = this.amazonPage.sonucIcerigi.getText();
        Assert.assertTrue(sonuc.contains("teapot"));
    }

    @Given("flower icin arama  yapar")
    public void flower_icin_arama_yapar() {
        this.amazonPage.aramaKutusu.sendKeys(new CharSequence[]{"flower", Keys.ENTER});
    }

    @Then("sonuclarin  flower icerdigini  test eder.")
    public void sonuclarin_flower_icerdigini_test_eder() {
        String sonuc = this.amazonPage.sonucIcerigi.getText();
        Assert.assertTrue(sonuc.contains("flower"));
    }

    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String istenenURL) {
        Driver.getDriver().get(ConfigurationReader.getProperty(istenenURL));
    }

    @Given("{string} icin arama yapar")
    public void icin_arama_yapar(String arananKelime) {
        this.amazonPage.aramaKutusu.sendKeys(new CharSequence[]{arananKelime + Keys.ENTER});
    }

    @Then("sonuclarin {string} icerdiğini test eder")
    public void sonuclarin_icerdiğini_test_eder(String arananKelime) {
        String sonucYazisiStr = this.amazonPage.sonucIcerigi.getText();
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @And("iphone icin arama yapar")
    public void iphoneIcinAramaYapar() {
        this.amazonPage.aramaKutusu.sendKeys(new CharSequence[]{"iphone", Keys.ENTER});
    }
}
