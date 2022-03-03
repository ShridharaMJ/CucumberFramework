package com.cucumberpractice.pageobjects.pages;

import com.cucumberpractice.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    public ContactUsPage(){
        super();
    }


    private @FindBy(xpath="//input[@name='first_name']")
    WebElement firstNameTextField;
    private @FindBy(xpath="//input[@name='last_name']")
    WebElement lastNameTextField;
    private @FindBy(xpath="//input[@name='email']")
    WebElement emailTextField;
    private @FindBy(xpath="//textarea[@name='message']")
    WebElement commentTextField;
    private @FindBy(xpath="//input[@value='SUBMIT']")
    WebElement submitButton;
    private @FindBy(xpath="//div[@id='contact_reply']")
    WebElement sussceeMessage;

    public void navigateToContactUs(){
        navigateToURL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void enterFirstName(String firstName){
        sendKeys(firstNameTextField,firstName);
    }
    public void enterLastName(String lastName){
        sendKeys(lastNameTextField,lastName);
    }
    public void enterEmail(String email){
        sendKeys(emailTextField,email);
    }
    public void enterComments(String comments){
        sendKeys(commentTextField,comments);
    }
    public void clickOnSubmit(){
        clickOnElement(submitButton);
    }

    public boolean isSuccessMessageDisplayed(){
        return sussceeMessage.isDisplayed();
    }




}
