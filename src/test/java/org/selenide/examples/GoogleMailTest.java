package org.selenide.examples;


import com.codeborne.selenide.Selenide;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleMailTest {

    //data for test
    @DataProvider
    public Object[][] LoginCredentials(){
        Object[][] Cred = new Object[3][3];
        //first two iterations verify incorrect login\password
        Cred[0][0] = "UserId1"; Cred[0][1] = "Pass1"; Cred[0][2] = false;
        Cred[1][0] = "UserId2"; Cred[1][1] = "Pass2"; Cred[1][2] = false;
        //use your or other correct credentials for the third iteration
        Cred[2][0] = "putValidLoginHere"; Cred[2][1] = "putValidPasswordHere"; Cred[2][2] = true;
        return Cred;
    }

    @Test(dataProvider="LoginCredentials")
    public void verifyGmailAuthorization(String userLogin, String userPassword, Boolean isCorrect) throws InterruptedException {

        String baseUrl = "http://gmail.com";
        String INCORRECT_PASSWORD_MESSAGE = "The email and password you entered don't match.";

        //go to gmail url
        Selenide.open(baseUrl);

        GmailPage gmail = new GmailPage();

        //set values
        gmail.setLogin(userLogin);
        gmail.setPassword(userPassword);
        if(isCorrect){
            //wait 'till page loading
            Thread.sleep(5000);
            Assert.assertTrue("Verify that 'new message' button is displayed indicating that page was correctly loaded",
                    gmail.isNewMessageButtonDisplayed());
        }
        else {
            Assert.assertEquals("Verify that error message is displayed in case of incorrect data",
                    gmail.getErrorPasswordMessage(), INCORRECT_PASSWORD_MESSAGE);
        }
    }
}
