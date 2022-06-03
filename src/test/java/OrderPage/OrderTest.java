package OrderPage;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.OrderPage;

import static org.testng.Assert.assertTrue;

public class OrderTest extends BaseTests {

    //order
    @Test
    public void testDeleteItemFromShoppingCart(){
       var orderPage = GetOrderPreconditionObj();
        orderPage.scrollToCenter();
        orderPage.clickToDeleteIcon();
        orderPage.getTextEmptyCheckout();
        assertTrue(orderPage.getTextEmptyCheckout()
                        .contains("Your shopping cart is empty."),
                "Alert text is incorrect");
    }

    private OrderPage GetOrderPreconditionObj(){
        homePage.scrollDownToLeftItem();
        homePage.mouseOverLeftItem();
        homePage.clickToAddCardItem();
        homePage.clickToCloseModalCheckout();
        homePage.scrollUp();
        return homePage.clickToCart();
    }
}
