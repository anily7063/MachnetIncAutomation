package pageObjectModel.homepage;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class HomePageLatestUpdates {
    WebDriver driver;
   public final static Logger log=Logger.getLogger(HomePageLatestUpdates.class.getName());
   Faker faker= new Faker();
   @FindBy(xpath = "//input[@id='subscription-form']")
   WebElement validEmail;
   @FindBy(xpath = "//input[@type='submit']")
   WebElement submitEmail;
   public HomePageLatestUpdates(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);

   }


   public void subscribeToGetLatestUpdate() throws InterruptedException{
log.info("send valid email and submit for latest update");
validEmail.sendKeys(faker.name().firstName()+"@gmail.com");
Thread.sleep(1000);
submitEmail.click();
Thread.sleep(1000);
   }


}
