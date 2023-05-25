package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import pageObjectModel.homepage.*;

public class TC_TestCaseHomePage_000 extends BaseClass {
    HomePage homePage;
    HomePagePlatformFeatures homePagePlatformFeatures;
    HomePageFooter homePageFooter;
    HomePageDesignedForDevelopers homePageDesignedForDevelopers;
    HomePageKeyClients homePageKeyClients;
    HomePageLatestUpdates homePageLatestUpdates;
    HomePageWhyMachnet homePageWhyMachnet;
    @Test(priority = 1)
    public void verifyTitle(){
        String expectedTitle= "Machnet | License, Banking and Payment Processing for Cross Border Payments";
        String actualTitle =driver.getTitle();
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            logger.info("Title matched");
            softAssert.assertEquals(actualTitle,expectedTitle);

        }else{
            logger.info("Title didnt matched");
        }

    }
    @Test(priority = 2)
    public void homePageLogo() throws InterruptedException{
        homePage =new HomePage(driver);
        homePage.clickOnLogo();
    }
@Test(priority = 3)
    public void homePageContactSales() throws InterruptedException{
        homePage=new HomePage(driver);
        homePage.clickOnContactSales();
       homePage.clickOnExploreMore();
    }
    @Test(priority = 4)
public void homePageKeyClients() throws InterruptedException{
        homePageKeyClients = new HomePageKeyClients(driver);
        homePageKeyClients.scrollToKeyClients();
        homePageKeyClients.clickOnKeyClientsDot();
}
@Test(priority = 5)
public void homePagePlatformFeatures() throws InterruptedException {
        homePagePlatformFeatures =new HomePagePlatformFeatures(driver);
        homePagePlatformFeatures.moveToHomepagePlatformFeature();

}

}
