package pages;

import base.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;
    private Utils utils;
    //Locator
    private By btnIconDeleteItemLocator = By.cssSelector(".icon-trash");
    private By textAlertEmptyCheckoutLocator = By.cssSelector(".alert");

    public OrderPage(WebDriver driver){
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void scrollToCenter (){
        utils.runJavascriptExecutor("window.scrollBy(0,500)");
    }

    public void clickToDeleteIcon(){
        utils.waitForClickableElement(btnIconDeleteItemLocator);
        utils.clickBtnElement(btnIconDeleteItemLocator);
    }

    public String getTextEmptyCheckout(){
        utils.waitForVisibleElement(textAlertEmptyCheckoutLocator);
        return driver.findElement(textAlertEmptyCheckoutLocator).getText();
    }




}
