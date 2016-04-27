package org.selenide.examples;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GmailPage {

    //gmail page content
    SelenideElement loginInput = $(By.id("Email"));
    SelenideElement passwordInput = $(By.id("Passwd"));
    SelenideElement errorMessage = $(By.id("errormsg_0_Passwd"));
    SelenideElement newMessageButton = $(By.xpath(".//*[@id=':it']/div/div"));

    /**
     * Sets login to related field
     * @param login represents string login
     */
    public void setLogin(String login){
        loginInput.setValue(login).pressEnter();
    }

    /**
     * Sets password to related field
     * @param password represents string password
     */
    public void setPassword(String password){
        passwordInput.setValue(password).pressEnter();
    }

    /**
     * Gets error message in case of incorrect password
     * @return string error message
     */
    public String getErrorPasswordMessage(){
        return errorMessage.text();
    }

    /**
     * Checks if 'new message '
     * @return true if button is displayed
     */
    public Boolean isNewMessageButtonDisplayed(){
        return newMessageButton.isDisplayed();
    }

}
