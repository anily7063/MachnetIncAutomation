package pageObjectModel.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class HomePage {
    WebDriver driver;
    public static final Logger log=Logger.getLogger(HomePage.class.getName());
    @FindBy(xpath = "//div/a/img[@class=\'flowbase-logo\']")
    WebElement logo;
    @FindBy(xpath = "//a[@id='contact-button-top']")
    WebElement contactSales;
    @FindBy(xpath = "//a[@id='explore-more-button']")
    WebElement exploreMore;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnLogo() throws  InterruptedException{
        log.info("clicking on machnet logo");
        logo.click();
        Thread.sleep(2000);
    }

    public void clickOnContactSales() throws InterruptedException{
        log.info("clicking on homepage Contact Sales button");
        contactSales.click();
        // Get the handle of the current window
        String currentWindowHandle=driver.getWindowHandle();
        // Switch to the new window
        driver.switchTo().window(currentWindowHandle);

        logo.click();//Click on logo to switch to homepage
        Thread.sleep(5000);
    }
    public void clickOnExploreMore() throws InterruptedException{
        log.info("clicking on Homepage Explore More button");

        exploreMore.click();
        Thread.sleep(1000);
        //get the handle of current window
        String currentWindowHandle= driver.getWindowHandle();
        //switch to new window
        driver.switchTo().window(currentWindowHandle);
        Thread.sleep(5000);
//        JavascriptExecutor jse =(JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0,50)");
//        logo.click(); //click on logo to switch to homepage
//        Thread.sleep(1000);

    }
}
