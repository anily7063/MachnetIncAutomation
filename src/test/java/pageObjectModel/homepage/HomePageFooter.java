package pageObjectModel.homepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class HomePageFooter {
    WebDriver driver;
    public static final Logger log= Logger.getLogger(HomePageFooter.class.getName());
    @FindBy(xpath = "//a[@class='footer-brand w-inline-block w--current']")
    WebElement homePageFooterLogo;

    public HomePageFooter(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void scrollToFooter() throws InterruptedException{
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
    }

    public void clickFooterLOgo() throws InterruptedException{
        log.info("clicking on HoemPage footer logo");
        scrollToFooter();
        homePageFooterLogo.click();
        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();
        // Switch to the new window
        driver.switchTo().window(currentWindowHandle);
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,5500)");
        Thread.sleep(5000);
    }
}


