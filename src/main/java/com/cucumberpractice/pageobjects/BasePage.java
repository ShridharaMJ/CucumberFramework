package com.cucumberpractice.pageobjects;

import com.cucumberpractice.drivers.DriverFactory;
import com.cucumberpractice.utils.GlobalVars;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(getDriver(),this);
    }

   public WebDriver getDriver(){
        return DriverFactory.getDriver();
   }

    public String generateRandom(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public void navigateToURL(String url){
        getDriver().get(url);
    }


    public void sendKeys(By by,String textToEnter){

        WebDriverWait wait =new WebDriverWait(getDriver(), GlobalVars.DEFAULT_EXTRANAL_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToEnter);


    }
    public void sendKeys(WebElement element, String textToEnter){

        WebDriverWait wait =new WebDriverWait(getDriver(), GlobalVars.DEFAULT_EXTRANAL_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToEnter);

    }

    public void clickOnElement(By by)
    {
        WebDriverWait wait =new WebDriverWait(getDriver(), GlobalVars.DEFAULT_EXTRANAL_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void clickOnElement(WebElement element)
    {
        WebDriverWait wait =new WebDriverWait(getDriver(), GlobalVars.DEFAULT_EXTRANAL_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public List<WebElement> getWebElements(By by){
        WebDriverWait wait =new WebDriverWait(getDriver(), GlobalVars.DEFAULT_EXTRANAL_TIMEOUT);
         return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public WebElement getWebElement(By by){
        WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
   public  void validatewAlertMessage(String expectedMessage){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
       String alertMessage = getDriver().switchTo().alert().getText();
       Assert.assertEquals(alertMessage,expectedMessage);

    }

}
