package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class shoppingCartPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("I can add books to their shopping cart")
    public void clickBook(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickBook = driver.findElement(By.xpath("//li[@id ='ctl00_lihome']/a"));
        clickBook.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/myaccount.aspx#"));
        WebElement biographyPresent = driver.findElement(By.xpath("(//a[@href='https://www.bookswagon.com/biographies-memoirs-books'])[1]"));
        biographyPresent.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/biographies-memoirs-books"));
        WebElement addCart = driver.findElement(By.xpath("(//div[@class = 'action-btns'])[2]/input[@class ='btn-red']"));
        addCart.click();
        WebElement addCart2 = driver.findElement(By.xpath("(//div[@class = 'action-btns'])[6]/input[@class ='btn-red']"));
        addCart2.click();
    }
    @Then("I check the card")
    public void checktheCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickCart = driver.findElement(By.xpath("(//span[@class = 'itemcount'])[1]"));
        clickCart.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/shoppingcart.aspx"));
        List<WebElement> cartItem = driver.findElements(By.xpath("//div[@class ='roundbgcontent shoppingcartroundwrapper']/ul/li"));
        Assert.assertEquals(cartItem.size(),2);
        WebElement totalAmount = driver.findElement(By.id("ctl00_phBody_BookCart_lvCart_lblNetAmount"));
        Assert.assertEquals(totalAmount.getText(),"₹1,130");
    }
    @Then("I remove the items form the cart")
    public void removeItemInCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickremove = driver.findElement(By.id("ctl00_phBody_BookCart_lvCart_ctrl1_imgDelete"));
        clickremove.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> cartItem = driver.findElements(By.xpath("//div[@class ='roundbgcontent shoppingcartroundwrapper']/ul/li"));
        Assert.assertEquals(cartItem.size(),1);
    }
    @Then("I update the items form the cart")
    public void updateItem(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickPlus = driver.findElement(By.id("ctl00_phBody_BookCart_lvCart_ctrl1_btnPlus"));
        clickPlus.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement getQty = driver.findElement(By.id("ctl00_phBody_BookCart_lvCart_ctrl1_txtQty"));
        String getText = getQty.getAttribute("value");
        Assert.assertEquals(getText,"2");
    }
}
