package pageObjectModel.homepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class HomePageKeyClients {
    WebDriver driver;
    public static final Logger log=Logger.getLogger(HomePageKeyClients.class.getName());
    @FindBy(xpath = "//div[@class='left-arrow-image']")
    WebElement keyClietsSlider;
    public HomePageKeyClients(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void scrollToKeyClients() throws InterruptedException{
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,450)");
        Thread.sleep(500);
    }
    public void clickOnKeyClientsDot() throws InterruptedException{
        log.info("clicking on KeyclientsSlider");
scrollToKeyClients();
keyClietsSlider.click();
Thread.sleep(500);


    }

}
