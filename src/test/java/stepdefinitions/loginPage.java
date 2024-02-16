package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class loginPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("I am on the Web page")
    public void iAmonWebPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bookswagon.com");
    }
    @When("I click Login in window")
    public void clickLogin(){
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/"));
        WebElement login = driver.findElement(By.id("ctl00_lblUser"));
        login.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/login"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/login");
    }
    @Then("I Register a Account")
    public void createAccount(){
        WebElement createAccount = driver.findElement(By.xpath("(//div[@class ='form-group col-sm-12']/a)[3]"));
        createAccount.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/login#"));
        WebElement username = driver.findElement(By.id("ctl00_phBody_SignUp_txtName"));
        username.sendKeys("Priya");
        WebElement number = driver.findElement(By.id("ctl00_phBody_SignUp_txtEmail"));
        number.sendKeys("9787891887");
        WebElement continueEl = driver.findElement(By.id("ctl00_phBody_SignUp_btnContinue"));
        continueEl.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_phBody_SignUp_lblmsg")));
        WebElement error = driver.findElement(By.id("ctl00_phBody_SignUp_lblmsg"));
        String geterror = error.getText();
        String expecterror = "The mobile number you entered already exist.";
        Assert.assertEquals(geterror,expecterror);
    }
    @Then("I enter Different password")
    public void enterDiffPas(){
        WebElement mobileNum = driver.findElement(By.id("ctl00_phBody_SignIn_txtEmail"));
        mobileNum.sendKeys("9787891887");
        WebElement password = driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword"));
        password.sendKeys("pri1587");
        WebElement clickLogin = driver.findElement(By.id("ctl00_phBody_SignIn_btnLogin"));
        clickLogin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_phBody_SignIn_lblmsg")));
        WebElement errorPas = driver.findElement(By.id("ctl00_phBody_SignIn_lblmsg"));
        String getError = errorPas.getText();
        String expectErr = "Please enter correct password.";
        Assert.assertEquals(getError,expectErr);
    }
    @Then("I reset password")
    public void resetPass(){
        WebElement forgotPass = driver.findElement(By.className("forgotpasswordlink"));
        forgotPass.click();
        WebElement enterNum = driver.findElement(By.id("ctl00_phBody_ForgotPassword_txtFGEmail"));
        enterNum.sendKeys("9787891887");
        WebElement continueClick = driver.findElement(By.id("ctl00_phBody_ForgotPassword_lnkForgotPassword"));
        continueClick.click();
       /* wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/login"));
        WebElement enetrOtp = driver.findElement(By.id("ctl00_phBody_ForgotPassword_txtFGOTP"));
        enetrOtp.sendKeys("54698");
        WebElement pass = driver.findElement(By.id("ctl00_phBody_ForgotPassword_txtFGPassword"));
        pass.sendKeys("Sia1702!");
        WebElement rePass = driver.findElement(By.id("ctl00_phBody_ForgotPassword_txtConfirmFGPwd"));
        rePass.sendKeys("Sia1702!");
        WebElement con = driver.findElement(By.id("ctl00_phBody_ForgotPassword_btnFGLogin"));
        con.click();*/
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/login"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/login");
    }
    @Then("I navigate the Home page")
    public void giveninput(){
        WebElement mobileNum = driver.findElement(By.id("ctl00_phBody_SignIn_txtEmail"));
        mobileNum.sendKeys("9787891887");
        WebElement password = driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword"));
        password.sendKeys("Sia1702!");
        WebElement submit = driver.findElement(By.id("ctl00_phBody_SignIn_btnLogin"));
        submit.click();

        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/myaccount.aspx"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/myaccount.aspx");
    }
}
