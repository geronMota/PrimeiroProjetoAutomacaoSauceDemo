package Actions;

import Pages.LoginPage;
import Utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPageAction {

    WebDriver driver;
    LoginPage loginPage;

    public LoginPageAction(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void login() {
        loginPage.username.sendKeys(ConfigReader.getUsername());
        loginPage.password.sendKeys(ConfigReader.getPassword());
        loginPage.loginButton.click();

    }

    public void validarPaginaProdutos() {
        String title = driver.getTitle();
        if (title.equals("Swag Labs")) {
            System.out.println("Página encontrada com sucesso");
        } else {
            System.out.println("Erro ao abrir página");
        }
    }


    public void realizarLoginValido() {
        loginPage.username.sendKeys("standard_user");
        loginPage.password.sendKeys("secret_sauce");
        loginPage.loginButton.click();
    }
    /*
    public void validarPaginaProdutos() {
        assertTrue(loginPage.tituloProdutos.isDisplayed());
    }
     */

    public void validarTitulo(String tituloEsperado) {
        assertTrue(loginPage.tituloProdutos.getText().contains(tituloEsperado));
    }

    public void realizarLoginInvalido() {
        loginPage.username.sendKeys("standard_user");
        loginPage.password.sendKeys("senha_errada");
        loginPage.loginButton.click();
    }

    public void validarErroLogin() {
        assertTrue(loginPage.erroLogin.isDisplayed());
    }

    public void adicionarProdutoCarrinho() {
        loginPage.produtoBtn.click();
    }

    public void validarCarrinho(String quantidade) {
        assertEquals(loginPage.cartBadge.getText(), quantidade);
    }

    public void removerProdutoCarrinho() {
        loginPage.produtoBtn.click();
    }

    public void validarCarrinhoVazio() {
        assertTrue(driver.findElements(org.openqa.selenium.By.className("shopping_cart_badge")).isEmpty());
    }

    public void realizarCheckout() {

        loginPage.cartIcon.click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Jefferson");
        driver.findElement(By.id("last-name")).sendKeys("Silva");
        driver.findElement(By.id("postal-code")).sendKeys("40000-000");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();
    }




    public void validarMensagemFinal(String mensagemEsperada) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By mensagem = By.className("complete-header");
        WebElement elemento = wait.until(
                ExpectedConditions.visibilityOfElementLocated(mensagem)
        );
        assertTrue(elemento.getText().contains(mensagemEsperada));
    }

    public void tirarScreenshot(String nomeBase) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nomeArquivo = nomeBase + "_" + timestamp + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File origem = ts.getScreenshotAs(OutputType.FILE);


        File destino = new File("screenshots/" + nomeArquivo);

        try {
            FileHandler.copy(origem, destino);
            System.out.println("Screenshot salvo em: " + destino.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar screenshot", e);
        }


    }

    public void fecharPopupChrome() {

        try {
            Robot robot = new Robot();


            Thread.sleep(1000);


            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


