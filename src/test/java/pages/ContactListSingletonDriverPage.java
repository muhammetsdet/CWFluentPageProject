package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class ContactListSingletonDriverPage {
    public By email = By.id("email");
    public By password = By.id("password");
    public By submit = By.id("submit");
    public By logout = By.id("logout");
    public By addContact = By.id("add-contact");
    public By signup = By.id("signup");

    public ContactListSingletonDriverPage enterEmail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;//Her method bu class'ın objesini döneceğinden, method chain şeklinde kullanılabilir
    }
    //    public void enterEmail(String emailStr){
//        driver.findElement(email).sendKeys(emailStr); //this demediğimiz bu class'tan almayacağı için iki aynı ismi karıştıracak
//
//    }

    public ContactListSingletonDriverPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public ContactListSingletonDriverPage clickSubmit() {
        Driver.getDriver().findElement(this.submit).click();
        return this;
    }

    public ContactListSingletonDriverPage assertLogout() {
        assertTrue(Driver.getDriver().findElement(logout).isDisplayed());
        return this;
    }


}
