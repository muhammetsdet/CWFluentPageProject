package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactListParallelDriverPage;
import pages.ContactListSingletonDriverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ParallelDriver;

import static org.testng.AssertJUnit.assertTrue;

public class C03_PositiveLoginParallelDriver {
    ContactListParallelDriverPage contactListPage;

    @BeforeMethod
    public void setUp() {

        ParallelDriver.getDriver().get(ConfigReader.getProperty("contact_list_url"));
        contactListPage = new ContactListParallelDriverPage();//Bu classın driverını kullanarak obje oluşturuyoruz
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        ParallelDriver.closeDriver();
    }


    @Test
    public void positiveLoginTest() {

        contactListPage.enterEmail("a_atas_12@hotmail.com");
        contactListPage.enterPassword("Atas3325");
        contactListPage.clickSubmit();
        contactListPage.assertLogout();

    }


    @Test
    public void testMethodChain() {

        //Her method ContactListPage class'ının objesini döneceğinden, method chain şeklinde kullanılabilir
        contactListPage.enterEmail("john.doe@gmail.com").enterPassword("John.123").clickSubmit().assertLogout();

    }

    @Test
    public void usingByObject() {

        //BeforeMthod ile anasayfaya gittikten sonra, bu method ile signUp butonunun varlığını By objesini kullanarak doğruluyoruz
        boolean isDisplayed = ParallelDriver.getDriver().findElement(contactListPage.signup).isDisplayed();

        assert isDisplayed : "signup button is not displayed";// 'assert' -> Java assertion: yanına gelen değer true dönerse test geçer.

    }
}
