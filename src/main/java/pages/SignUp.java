package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUp extends BasePage{
    public SignUp(WebDriver driver) {
        super(driver);
    }
    By firstNameField= By.xpath(setXpathByName("fname"));
    By lastNameField= By.xpath(setXpathByName("lname"));
    By emailField= By.id("nf-field-19");
    By phoneField= By.id("nf-field-20");
    WebElement couseSelection= driver.findElement(By.id("nf-field-22"));
    WebElement monthSelection = driver.findElement(By.id("nf-field-24"));
    By linkedINLink= By.xpath(setXpathByTextContains("LinkedIn"));
    By registerBTN= By.id("nf-field-15");

    By headerText = By.xpath(setXpathByTextContains("Training Registration Form"));
    By paragraphText = By.id("nf-field-11-container");
    By instructorsTitle = By.id("text-7");
    By successRegisteration = By.xpath(setXpathByClassContains("nf-response-msg"));
    Faker faker = new Faker();
    public void assertPageHeader(){
        softAssertionEqual(headerText,"Training Registration Form");
        softAssertionContain(paragraphText,"If you would like to book your spot for next batch,");
        softAssertionContain(instructorsTitle,"Instructor’s Profile");
    }
    String firstName= faker.name().firstName();
    public void setFirstName(){
        setText(firstNameField,firstName);
    }
    String lastName= faker.name().lastName();
    public void setLastName(){

        setText(lastNameField,lastName);
    }


    public void setEmailField(){
       // String email = faker.internet().emailAddress();
        String email= firstName+lastName+"@gmail.com";
        setText(emailField,email);
    }

    public void setPhone(){
        String phone="011" + faker.number().digits(8);
        setText(phoneField,phone);
    }
    public void setCouseSelection(){
        Select course = new Select(couseSelection);
        course.selectByValue("web-services-api");
    }
    public void setMonthSelection(){
        Select month = new Select(monthSelection);
        month.selectByValue("february");
    }
    public void clickOnLinkedINLink(){
        click(linkedINLink);
    }
    public void clickOnRegisterBtn(){
        click(registerBTN);
    }
    public void assertSuccessfullRegisteration(){
        waitElement(successRegisteration);
        softAssertionEqual(successRegisteration,"Thank you for registering for our event.");
    }

}
