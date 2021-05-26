package util;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TrabalhoFinal {

    private WebDriver driver;
    private Select combo;
    private WebElement botao;

    public void inicializa() {
        String chromeDriver = System.getProperty("user.dir") + "/drives/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");
    }

    public void navegadorChrome() {
        Assert.assertTrue(driver.toString().contains("Chrome"));
    }

    public void fecharNavegador() {
        driver.quit();
    }

    public void testeNomeObrigatorio() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void validaNomeObrigatorio() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());
    }

    public void testeSobrenomeObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcelo");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void validaSobrenomeObrigatorio() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
    }

    public void testeSexoObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcelo");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Nascimento");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void validaCampoSexoObrigatorio() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
    }

    public void testeNomeSobrenomeSexo() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcelo");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Nascimento");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
    }

    public void validaNomeSobrenomeSexo() {
        Assert.assertEquals("Marcelo", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        Assert.assertEquals("Nascimento", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    public void testeComidaFavorita() {
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
    }

    public void validaComidaFavorita() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
    }

    public void selecionarEscolaridade() {
        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
        combo = new Select(elemento);
        combo.selectByIndex(3);
    }

    public void validaEscolaridade() {
        Assert.assertEquals("O que eh esporte?", combo.getFirstSelectedOption().getText());
    }

    public void selecionarEsporte() {
        WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
        combo = new Select(elemento);
        combo.selectByVisibleText("O que eh esporte?");
    }

    public void validaEsporte() {
        List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(1, allSelectOptions.size());
    }

    public void testeSugestoes() {
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Nenhuma sugestão");
    }

    public void validaSugestao() {
        Assert.assertEquals("Nenhuma sugestão", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    public void clicarBotaoCadastrar() {
        botao = driver.findElement(By.id("elementosForm:cadastrar"));
        botao.click();
    }

    public void validarBotaoCadastrar() {
        Assert.assertEquals("Nome: Marcelo", driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Sobrenome: Nascimento", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: 2graucomp", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: O que eh esporte?", driver.findElement(By.id("descEsportes")).getText());
        Assert.assertEquals("Sugestoes: Nenhuma sugestão", driver.findElement(By.id("descSugestoes")).getText());
    }

    public void testePreencherTodosCampos() {
        testeNomeSobrenomeSexo();
        testeComidaFavorita();
        selecionarEscolaridade();
        selecionarEsporte();
        testeSugestoes();
        clicarBotaoCadastrar();
    }

    public void validaTodosCampos() {
        validaNomeSobrenomeSexo();
        validaComidaFavorita();
        validaEscolaridade();
        validaEsporte();
        validaSugestao();
        validarBotaoCadastrar();
    }

}
