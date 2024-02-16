package stepdefinitions;

import io.cucumber.java.en.And;
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

public class bookCatelogPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("I check the available Book")
    public void chekAvailabe(){
        WebElement clickBook = driver.findElement(By.xpath("//li[@id ='ctl00_lihome']/a"));
        clickBook.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/myaccount.aspx#"));
        WebElement biographyPresent = driver.findElement(By.xpath("(//a[@href='https://www.bookswagon.com/biographies-memoirs-books'])[1]"));
        boolean checkIt = biographyPresent.isDisplayed();
        Assert.assertTrue(checkIt);
    }
    @Then(("Each book should have details like title, author, price, and availability"))
    public void checkBookDetails(){
        WebElement clickBook = driver.findElement(By.xpath("//li[@id ='ctl00_lihome']/a"));
        clickBook.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/myaccount.aspx#"));
        WebElement biographyPresent = driver.findElement(By.xpath("(//a[@href='https://www.bookswagon.com/biographies-memoirs-books'])[1]"));
        biographyPresent.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/biographies-memoirs-books"));
        List<WebElement> presentbioBook = driver.findElements(By.xpath("//div[@class ='title']"));
        Assert.assertEquals(presentbioBook.size(),21);

        WebElement getTitle = driver.findElement(By.xpath("(//div[@class ='title'])[3]/a"));
        String currentTitle = getTitle.getText();
        String expectTitle = "VAJPAYEE: The Ascent of the Hindu Right, 1924-1977";
        Assert.assertEquals(currentTitle,expectTitle);

        WebElement getAuthor = driver.findElement(By.xpath("(//div[@class ='author-publisher'])[3]/a"));
        String currentAuthor = getAuthor.getText();
        String expectAuthor = "Choudhary, Abhishek";
        Assert.assertEquals(currentAuthor,expectAuthor);

        WebElement getPrice = driver.findElement(By.xpath("(//div[@class ='sell'])[2]"));
        String currentPrice = getPrice.getText();
        String expectPrice = "₹530";
        Assert.assertEquals(currentPrice,expectPrice);

        WebElement getAvailable = driver.findElement(By.xpath("(//div[@class ='available-stock'])[2]"));
        String currentAvailable = getAvailable.getText();
        String expectAvailable = "Available";
        Assert.assertEquals(currentAvailable,expectAvailable);
    }

    @And("I Search with book name")
    public void searchBook(){
        WebElement searchEl = driver.findElement(By.id("inputbar"));
        searchEl.sendKeys("Nikon D90");
        WebElement searchIcon = driver.findElement(By.id("btnTopSearch"));
        searchIcon.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/search-books/nikon-d90"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/search-books/nikon-d90");
    }
    @Then("I search with author name")
    public void searchAuthor(){
        WebElement searchEl = driver.findElement(By.id("inputbar"));
        searchEl.sendKeys("Focal Press");
        WebElement searchIcon = driver.findElement(By.id("btnTopSearch"));
        searchIcon.click();
        wait.until(ExpectedConditions.urlToBe("https://www.bookswagon.com/search-books/focal-press"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/search-books/focal-press");
    }

}
