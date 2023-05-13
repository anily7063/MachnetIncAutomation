package pageObjectModel.homepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
import java.util.logging.Logger;

public class HomePageDesignedForDevelopers {
WebDriver driver;
public static final Logger log=Logger.getLogger(HomePageDesignedForDevelopers.class.getName());
    @FindBy(xpath = "//a/div[contains(text(),'Get API Docs')]")
    WebElement getApiDocs;

    public HomePageDesignedForDevelopers(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
public void clickOnGetApiDocs() throws InterruptedException{
        log.info("clicking on getApiDocs link");
        Thread.sleep(5000);
    JavascriptExecutor jse=(JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0,650)");
        getApiDocs.click();
        //get handle of current window
        String currentWindowHandle= driver.getWindowHandle();
//get handles of all open windows
    Set<String> windowHandles =driver.getWindowHandles();
    //remove handle of current window from the set of handles
    windowHandles.remove(currentWindowHandle);


        //switching to current window
driver.switchTo().window(windowHandles.iterator().next());
Thread.sleep(5000);
//close the switched window
    driver.close();

    driver.switchTo().window(currentWindowHandle);
    jse.executeScript("window.scrollBy(0,400");
    Thread.sleep(5000);




}
}
