package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by User on 30.07.2017.
 */
public class Tools {
    protected WebDriver driver;

    protected void sleep(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
        }
    }

    protected void Preconditions(){
        driver.get("http://odpublic.net/");
        driver.findElement(By.id("btnRegOpen")).click();

    }

    protected    boolean isAlert(){
        try {
                driver.switchTo().alert();
                return true;
            }
            catch (org.openqa.selenium.NoAlertPresentException e ) {
                return false; }

    }
}
