package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestandoFacebookCadastro {
    private ChromeDriver driver;
    private UtilsDSL dsl;

    @Before
    public void inicializando() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        dsl = new UtilsDSL(driver);
    }
    @Dado("que o usuario está na tela inicial do facebook")
    public void que_o_usuario_está_na_tela_inicial_do_facebook() {
        dsl.pegaSite("https://pt-br.facebook.com/");
    }

    @Quando("clica em criar nova conta")
    public void clica_em_criar_nova_conta() {
        dsl.clicaPorLink("Criar nova conta");
    }

    @Quando("preenche os campos {string} {string} {string} {string}")
    public void preenche_os_campos(String nome, String sobrenome, String email, String senha) {
        dsl.preencheCampoPorNome("firstname", nome);
        dsl.preencheCampoPorNome("lastname", sobrenome);
        dsl.preencheCampoPorNome("reg_email__", email);
        dsl.preencheCampoPorNome("reg_email_confirmation__", email);
        dsl.preencheCampoPorId("password_step_input", senha);
    }

    @Quando("preenche os campos restantes {string} {string} {string} {string}")
    public void preenche_os_campos_restantes(String dia, String mes, String ano, String genero) {
        dsl.selecionaPorId("day", dia);
        dsl.selecionaPorId("month", mes);
        dsl.selecionaPorId("year", ano);
        if(genero.equals("masculino")) {
            dsl.clicaPorXpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span               /span[2]/input");
        }
        if(genero.equals("feminino")) {
            dsl.clicaPorXpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span               /span[1]/input");
        }
        dsl.clicaPorNome("websubmit");
    }

    @Então("o titulo obtido deve ter o titulo {string}")
    public void o_titulo_obtido_deve_ter_o_titulo(String esperado) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Baixar suas informações")));
        Assert.assertEquals(esperado, driver.getTitle());
    }

    @After
    public void finalizando(){
        driver.quit();
    }

}
