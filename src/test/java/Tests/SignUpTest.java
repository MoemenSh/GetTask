package Tests;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{


    @Test
    public void signUPtest(){
        try {
            signUp.assertPageHeader();
            signUp.setFirstName();
            signUp.setLastName();
            signUp.setPhone();
            signUp.setEmailField();
            signUp.setCouseSelection();
            signUp.setMonthSelection();
            signUp.clickOnLinkedINLink();
            signUp.clickOnRegisterBtn();
            signUp.assertSuccessfullRegisteration();
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

    }

}
