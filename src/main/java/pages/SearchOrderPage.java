package pages;

import base.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchOrderPage {

    private WebDriver driver;
    private Utils utils;

    //Locator
    private By txtHeadingCounterLocator =  By.cssSelector(".heading-counter");
    private By txtItemTextLocator =  By.cssSelector(".product-name[title='Faded Short Sleeve T-shirts']");

    public SearchOrderPage(WebDriver driver){
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void scrollToCenter (){
        utils.runJavascriptExecutor("window.scrollBy(0,500)");
    }
    public String getTextFoundItem(){
        utils.waitForVisibleElement(txtHeadingCounterLocator);
        return driver.findElement(txtHeadingCounterLocator).getText();
    }
    public String getItemText(){
        utils.waitForVisibleElement(txtItemTextLocator);
        return driver.findElement(txtItemTextLocator).getText();
    }

}
