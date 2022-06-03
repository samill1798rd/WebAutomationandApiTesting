package HomePage;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTests {

    //HomePage
    @Test(priority=1)
    public void testAddItemToShoppingCartSuccess(){
        homePage.scrollDownToLeftItem();
        homePage.mouseOverLeftItem();
        homePage.clickToAddCardItem();
        assertTrue(homePage.getTextAddCartSuccess()
                        .contains("Product successfully added to your shopping cart"),
                "Alert text is incorrect");
    }

    //Store information
    @Test(priority=2)
    public void testCheckAddressInformation(){
        homePage.scrollDownToFooter();
        assertTrue(homePage.getAddressText()
                        .contains("Selenium Framework, Research"),
                "Alert text is incorrect");
    }

    @Test(priority=3)
    public void testCheckTelephoneNumberInformation(){
        homePage.scrollDownToFooter();
        assertEquals(homePage.getTelephoneText(),"(347) 466-7432");
    }



}
