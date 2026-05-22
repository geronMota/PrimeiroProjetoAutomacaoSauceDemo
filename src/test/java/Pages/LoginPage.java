package Pages;

import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //public String url = "https://www.saucedemo.com/";
    public String url = ConfigReader.getAppUrl();


    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "title")
    public WebElement tituloProdutos;

    @FindBy(css = "[data-test='error']")
    public WebElement erroLogin;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartIcon;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "finish")
    public WebElement finishBtn;


    @FindBy(className = "complete-header")
    public WebElement mensagemSucesso;

    @FindBy(css = ".btn_inventory")
    public WebElement produtoBtn; // add/remove


}
