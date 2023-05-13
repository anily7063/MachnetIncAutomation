package base;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utilities.ReadConfig;

import java.util.logging.Logger;

public class BaseClass {
    ReadConfig readConfig= new ReadConfig();
    String baseUrl= readConfig.getApplicationUrl();
    String chromePath= readConfig.getChromePath();
    public static WebDriver driver;
    public static Logger logger=Logger.getLogger(BaseClass.class.getName());
    public Actions action;
    public SoftAssert softAssert= new SoftAssert();
    public  String baseDirectory= System.getProperty("user.dir");
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void  setUp(@Optional("chrome") String br) throws InterruptedException{
        logger.info("Opening machnetinc.com");
        String log4jConfPath=baseDirectory+ "/src/main/resources/config/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        if(br.equals("chrome")){
            ChromeOptions options =new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", baseDirectory + chromePath);
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        action=new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }
    @AfterClass(alwaysRun = true)
    public  void tearDown(){
        driver.close();
        driver.quit();
    }

//    public void captureScreen(WebDriver driver,String tname) throws IOException {
//        TakeScreenshot ts =(TakeScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
//        FileUtils.copyFile(source, target);
//        System.out.println("Screenshot taken");
//    }
}