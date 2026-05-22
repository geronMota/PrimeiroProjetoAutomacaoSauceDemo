package stepdefinitions;

import Actions.LoginPageAction;
import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPageStep {

    private WebDriver driver;
    LoginPage loginPage;
    LoginPageAction loginPageAction;

    @Given("eu esteja no tela de login")
    public void eu_esteja_no_tela_de_login() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        driver.get(loginPage.url);
        loginPageAction = new LoginPageAction(driver);
    }

    @When("digitar login e senha")
    public void digitar_login_e_senha() {
        loginPageAction.login();
    }

    @Then("a tela sera exibida")
    public void a_tela_sera_exibida() {
        loginPageAction.validarPaginaProdutos();
    }


   // =========================
    // LOGIN
    // =========================

    @Given("que o usuario acessa a pagina de login do SauceDemo")
    public void que_o_usuario_acessa_a_pagina_de_login_do_saucedemo() {

        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPageAction = new LoginPageAction(driver);
        driver.get(loginPage.url);
        loginPageAction.tirarScreenshot("pagina_Login");
    }

    @When("o usuario realiza login com credenciais validas")
    public void loginValido() {
        loginPageAction.realizarLoginValido();
    }

    @Then("o sistema deve redirecionar para a pagina de produtos")
    public void validarRedirecionamento() {
        loginPageAction.validarPaginaProdutos();
    }

    @Then("o titulo da pagina deve conter {string}")
    public void validarTitulo(String titulo) {
        loginPageAction.validarTitulo(titulo);
    }

    @When("o usuario realiza login com credenciais invalidas")
    public void loginInvalido() {
        loginPageAction.realizarLoginInvalido();

    }

    @Then("o sistema deve exibir a mensagem de erro de login invalido")
    public void validarErro() {
        loginPageAction.validarErroLogin();
        loginPageAction.tirarScreenshot("login_invalido");
    }

    @Given("que o usuario esta logado no sistema")
    public void usuarioLogado() {
        loginPageAction.realizarLoginValido();
    }

    @When("o usuario adiciona um produto ao carrinho")
    public void adicionarProduto() {
        loginPageAction.adicionarProdutoCarrinho();
    }

    @Then("o contador do carrinho deve exibir {string}")
    public void validarCarrinho(String qtd) {
        loginPageAction.validarCarrinho(qtd);
        loginPageAction.tirarScreenshot("contador_carrinho");
    }


    @Given("possui um produto adicionado ao carrinho")
    public void produtoCarrinho() {
        loginPageAction.adicionarProdutoCarrinho();
    }

    @When("o usuario remove o produto do carrinho")
    public void removerProduto() {
        loginPageAction.removerProdutoCarrinho();
    }

    @Then("o carrinho deve ficar vazio")
    public void carrinhoVazio() {
        loginPageAction.validarCarrinhoVazio();
    }


    @When("o usuario realiza o checkout da compra")
    public void checkout() {
        loginPageAction.fecharPopupChrome();
        loginPageAction.realizarCheckout();
        loginPageAction.fecharPopupChrome();
    }

    @Then("o sistema deve exibir a mensagem {string}")
    public void validarMensagem(String msg) {

    }



}


