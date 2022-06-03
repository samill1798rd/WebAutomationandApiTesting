package pages;

import base.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
  private WebDriver driver;
  private Utils utils;

  //Locator
  private By btnAddtoCardLocator = By.cssSelector("#homefeatured [data-id-product='1']");
  private By itemTshirtOverElementLocator = By.cssSelector("#homefeatured [alt='Faded Short Sleeve T-shirts']");
  private By addressTextLocator = By.xpath("//section[@id='block_contact_infos']//li[1]");
  private By telephoneTextLocator = By.xpath("//span[.='(347) 466-7432']");
  private By textCartSuccessLocator = By.cssSelector(".layer_cart_product > h2");
  private By btnCloseModalSuccessLocator = By.xpath("//span[@class='cross']");
  private By btnCartViewLocator = By.cssSelector("[title='View my shopping cart']");
  private By inputSearchLocator = By.id("search_query_top");
  private By btnSumitSearchLocator = By.name("submit_search");

  public HomePage  (WebDriver driver){
    this.driver = driver;
    this.utils = new Utils(driver);

  }

  public void scrollDownToLeftItem (){
    utils.runJavascriptExecutor("window.scrollBy(0,800)");
    utils.wait(5);
  }

  public void scrollDownToFooter (){
    utils.runJavascriptExecutor("window.scrollBy(0,3000)");
  }


  public void mouseOverLeftItem(){
    Actions actions = new Actions(driver);
    var element = driver.findElement(itemTshirtOverElementLocator);
    actions.moveToElement(element).perform();
  }

  public void clickToAddCardItem (){
    utils.clickBtnElement(btnAddtoCardLocator);

  }
  public String getTextAddCartSuccess(){
    utils.waitForVisibleElement(textCartSuccessLocator);
    return driver.findElement(textCartSuccessLocator).getText();
  }

  //test case delete from cart
  public void clickToCloseModalCheckout(){
    utils.waitForClickableElement(btnCloseModalSuccessLocator);
    utils.clickBtnElement(btnCloseModalSuccessLocator);
  }
  public void scrollUp (){
    utils.runJavascriptExecutor("window.scrollBy(0,-1500)");
  }

  public OrderPage clickToCart(){
    utils.waitForClickableElement(btnCartViewLocator);
    utils.clickBtnElement(btnCartViewLocator);
    return new OrderPage(driver);
  }

  //Text Search
  public void insertTextToSearch(String value){
    driver.findElement(inputSearchLocator).sendKeys(value);
  }

  public SearchOrderPage clickToSearchBotton(){
    utils.waitForClickableElement(btnSumitSearchLocator);
    utils.clickBtnElement(btnSumitSearchLocator);
    return new SearchOrderPage(driver);
  }

  public String getAddressText(){
    utils.waitForVisibleElement(addressTextLocator);
    return driver.findElement(addressTextLocator).getText();
  }

  public String getTelephoneText(){
    utils.waitForVisibleElement(telephoneTextLocator);
    return driver.findElement(telephoneTextLocator).getText();
  }




}
