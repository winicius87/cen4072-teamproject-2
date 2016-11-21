import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Michael on 11/6/2016.
 */
@RunWith(JUnit4.class)
public class test {

    private static WebDriver driver;
    private static LoginPage loginpage;

    @BeforeClass
    public static void oneTimeSetup(){
        //Set your path to the geckodriver application
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Michael\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Before
    public void setup(){
        loginpage = new LoginPage(driver);
        loginpage.open();
    }

    @Test
    public void emptyUsernameAndPassword_returnsIncorrectPasswordMessage(){
        loginpage = loginpage.signin("","");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement x = driver.findElement(By.className("field_error"));
        assertEquals("The password you entered was incorrect.",x.getText());
    }

    @Test
    public void userNameCorrectPasswordIncorrect_displaysUsernameOnLoginPage(){
        loginpage = loginpage.signin("cen4072-2","");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement x = driver.findElement(By.className("login-user-details"));
        assertEquals("cen4072-2",x.getText());
    }

    @Test
    public void UsernameAndPasswordExist_LogsUserIn(){
        loginpage = loginpage.defaultSignin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement x = driver.findElement(By.id("oh-menu-deviant"));
        assertEquals("cen4072-2",x.getText());
    }
}