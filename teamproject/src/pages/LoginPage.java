package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final String URL = "https://www.deviantart.com/users/login";
    private WebDriver driver;
    private String username = "cen4072.2@gmail.com";
    private String password = "blackbox24";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public LoginPage defaultSignin(){return signin(username, password);}

    public LoginPage signin(String username, String password) {
        WebElement userNameTextField = driver.findElement(By.id("login_username"));
        WebElement passwordTextField = driver.findElement(By.id("login_password"));
        WebElement submitButton = driver.findElement
                (By.cssSelector("input.smbutton"));
        userNameTextField.clear();
        userNameTextField.sendKeys(username);
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
        submitButton.click();
        return this;
    }
}