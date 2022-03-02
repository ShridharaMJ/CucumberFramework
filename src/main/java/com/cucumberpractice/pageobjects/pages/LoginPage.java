package com.cucumberpractice.pageobjects.pages;

import com.cucumberpractice.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private @FindBy(id= "text")
    WebElement usernameTextField;
    private @FindBy(id= "password")
    WebElement passwordTextField;
    private @FindBy(id= "login-button")
    WebElement loginButton;

public LoginPage(){
    super();
}

public void navigateToLoginPage(){
    navigateToURL("https://webdriveruniversity.com/Login-Portal/index.html");
}

public void enterUserName(String username){
    sendKeys(usernameTextField,username);
}

public void enterPassword(String password){
    sendKeys(passwordTextField,password);
}

public void clickOnLogin(){
    clickOnElement(loginButton);
}

public void verifyAlertMessage(String expectedMessage){
    validatewAlertMessage(expectedMessage);
}




}
