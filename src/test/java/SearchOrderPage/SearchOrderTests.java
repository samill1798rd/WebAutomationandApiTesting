package SearchOrderPage;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchOrderTests extends BaseTests {

    //SearchOrder
    @Test(priority=1)
    public void testSearchInStockItem(){
        homePage.insertTextToSearch("t-shirt");
        var serchOrderPage = homePage.clickToSearchBotton();
        serchOrderPage.scrollToCenter();
        assertTrue(serchOrderPage.getTextFoundItem()
                        .contains("1 result has been found."),
                "Alert text is incorrect");
        assertTrue(serchOrderPage.getItemText()
                        .contains("T-shirts"),
                "Alert text is incorrect");
    }

    @Test(priority=2)
    public void testSearchIsNotInStockItem(){
        homePage.insertTextToSearch("test");
        var serchOrderPage = homePage.clickToSearchBotton();
        assertTrue(serchOrderPage.getTextFoundItem()
                        .contains("0 results"),
                "Alert text is incorrect");
    }
}
