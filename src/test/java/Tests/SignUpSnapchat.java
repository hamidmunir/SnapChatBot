package Tests;

import Base.BaseTest;
import Pages.Loginpage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Random;

public class SignUpSnapchat extends BaseTest {



    public SignUpSnapchat() throws Exception {
    }

    @Test
    public void signup() throws Exception {
        Random random = new Random();
        int min = 1000;
        int max = 6000; // bound is exclusive
        Loginpage loginpage=new Loginpage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        loginpage.clickSignUpButton();
        Thread.sleep(random.nextInt(max - min) + min);
        loginpage.enterFirstName(firstName);
        loginpage.enterLastName(lastName);
        Thread.sleep(random.nextInt(max - min) + min);
        loginpage.clickContinueButton();

        loginpage.chooseDateofBirth("2001");
        loginpage.clickContinueButton();
        Thread.sleep(random.nextInt(max - min) + min);
        String username = faker.name().username();
        try{
            loginpage.clickContinueButton();
        } catch (Exception e){
            loginpage.enterUsername(firstName+username+1829);
        }
        loginpage.enterPassword(firstName+username+1829);
        loginpage.clickContinueButton();
        loginpage.enterEmail(username+"@gmail.com");
        Thread.sleep(random.nextInt(max - min) + min);
        loginpage.clickContinueButton();
        loginpage.clickSkip();
        loginpage.clickSkip();
        Thread.sleep(random.nextInt(max - min) + min);
        loginpage.clickCancel();
    }
    @Test
    public void test2() throws Exception {
        signup();
    }
    @Test
    public void test3() throws Exception {
        signup();
    }
    @Test
    public void test4() throws Exception {
        signup();
    }
}
