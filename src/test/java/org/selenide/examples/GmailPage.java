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

    public void setLogin(String login){
        loginInput.setValue(login).pressEnter();
    }

    public void setPassword(String password){
        passwordInput.setValue(password).pressEnter();
    }

    public String getErrorPasswordMessage(){
        return errorMessage.text();
    }

    public Boolean isNewMessageButtonDisplayed(){
        return newMessageButton.isDisplayed();
    }

}
