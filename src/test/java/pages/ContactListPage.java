package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;

public class ContactListPage {

    private WebDriver driver;


    public ContactListPage(WebDriver driver) { // Bu constructor'ın Kullanıldığı class'daki driver bu class'ın driverına assign yapılarak bu classtaki işlemlere devam edilir.


        this.driver = driver;

    }

    public By email = By.id("email");
    public By password = By.id("password");
    public By submit = By.id("submit");
    public By logout = By.id("logout");
    public By addContact = By.id("add-contact");
    public By signup = By.id("signup");


    public ContactListPage enterEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
        return this; //Her method bu class'ın objesini döneceğinden method chain şeklinde kullanılabilir.

    }

//    public void enterEmail(String emailStr){
//        driver.findElement(email).sendKeys(emailStr); //this demediğimiz bu class'tan almayacağı için iki aynı ismi karıştıracak
//
//    }

    public ContactListPage enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public ContactListPage clickSubmit() {
        driver.findElement(this.submit).click();
        return this;
    }

    public ContactListPage assertLogout() {
        assertTrue(driver.findElement(logout).isDisplayed());
        return this;
    }


}
