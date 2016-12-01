package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Winicius on 11/6/2016.
 */

public class Browse {
    private final String URL = "http://www.deviantart.com";
    private final String username = "cen4072-1";
    private final String password = "password";
    private WebDriver driver;
    public Browse(WebDriver driver) {
        this.driver = driver;
    }

    public Browse open() {
        driver.get(URL);
        return this;
    }

    public Browse browseFor(String search) {
        WebElement browseTextField = driver.findElement(By.name("q"));
        browseTextField.clear();
        browseTextField.sendKeys(search);
        WebElement form = driver.findElement(By.id("search7"));
        form.submit();

        return this;
    }

    public Browse clickLink(String stringlink) {
        WebElement link = driver.findElement(By.partialLinkText(stringlink));
        link.click();
        return this;
    }

}