package Pages;

import Base.BasePage;
import Base.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;


public class Loginpage extends BasePage {

    @AndroidFindBy(id = "signup_button_horizontal")
    MobileElement signUpButton;

    @AndroidFindBy(id = "continue_button")
    MobileElement continueButton;

    @AndroidFindBy(id = "display_name_first_name_field")
    MobileElement firstName;

    @AndroidFindBy(id = "display_name_last_name_field")
    MobileElement lastName;

    // press continue button

    @AndroidFindBy(id = "birthday_form_title")
    MobileElement birthdayTitle;

    @AndroidFindBy(xpath = "//android.widget.NumberPicker/android.widget.EditText")
    List<MobileElement> datePicker;

    //press continue button

    @AndroidFindBy(id = "username_form_field")
    MobileElement username;
    //press continue

    @AndroidFindBy(id = "change_username_link")
    MobileElement changeUsername;

    @AndroidFindBy(id = "password_form_field")
    MobileElement password;

    //continue

    @AndroidFindBy(id = "email_field")
    MobileElement emailField;
//continue

    @AndroidFindBy(id = "skip_button")
    MobileElement skipButton;
    //hit again skip button

    @AndroidFindBy(id = "cancel_button")
    MobileElement cancelButton;


    public Loginpage() throws Exception {
    }


    public Loginpage clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
        return this;
    }

    public Loginpage clickContinueButton() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        }catch (Exception e){
            wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        }
        continueButton.click();
        return this;
    }

    public Loginpage enterFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.clear();
        firstName.sendKeys(name);
        return this;
    }

    public Loginpage enterLastName(String name) {
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.clear();
        lastName.sendKeys(name);
        return this;
    }

    public Loginpage chooseDateofBirth(String year) {
        wait.until(ExpectedConditions.visibilityOf(birthdayTitle));
        wait.until(ExpectedConditions.elementToBeClickable(datePicker.get(2))).click();
        datePicker.get(2).clear();
        datePicker.get(2).sendKeys(year);
        datePicker.get(1).click();
        return this;
    }

    public Loginpage enterUsername(String name) {

        wait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(name);
        return this;
    }

    public Loginpage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public Loginpage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(this.emailField));
        this.emailField.clear();
        this.emailField.sendKeys(email);
        return this;
    }

    public Loginpage clickSkip() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(skipButton));
        } catch (Exception e){
            wait.until(ExpectedConditions.elementToBeClickable(skipButton));
        }
        skipButton.click();
        return this;
    }

    public Loginpage clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
        return this;
    }
}
