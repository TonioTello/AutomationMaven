package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By triggerAlertButtton = By.xpath("//button[text()=\"Click for JS Alert\"]");
    private  By results = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButtton).click();
    }

    public void click_acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void click_dsmissAlert(){
        driver.switchTo().alert().dismiss();
    }


    public String getResults(){
        return driver.findElement(results).getText();
    }
}
