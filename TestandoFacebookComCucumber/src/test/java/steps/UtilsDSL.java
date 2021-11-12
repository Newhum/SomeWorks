package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UtilsDSL {
    private WebDriver driver;

    public UtilsDSL(WebDriver driver) {
        this.driver = driver;
    }

    public void preencheCampoPorId(String id_campo, String valor) {
        driver.findElement(By.id(id_campo)).sendKeys(valor);
    }
    public void pegaSite(String url) {
        driver.get(url);
    }
    public void clicaPorLink(String texto) {
        driver.findElement(By.linkText(texto)).click();
    }
    public void preencheCampoPorNome(String nome_campo, String valor) {
        driver.findElement(By.name(nome_campo)).sendKeys(valor);
    }
    public void selecionaPorId(String id_campo, String valor) {
        new Select(driver.findElement(By.id(id_campo))).selectByVisibleText(valor);
    }
    public void clicaPorXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    public void clicaPorNome(String nome_campo) {
        driver.findElement(By.name(nome_campo)).click();
    }

}
