package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {
    private WebDriver driver;
    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void runJavascriptExecutor (String code){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(code);
    }

    public void waitForSecond(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBtnElement (By element){
        driver.findElement(element).click();
    }

    public void wait(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void waitForVisibleElement(By locator){
        var wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickableElement(By locator){
        var wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
