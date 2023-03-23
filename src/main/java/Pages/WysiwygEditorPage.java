package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textEditorArea = By.id("tinymce");
    private By indentButton = By.xpath("//*[@class=\"tox-tbtn\"][@title=\"Increase indent\"]");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToIframeArea();
        driver.findElement(textEditorArea).clear();
        switchToMainArea();
    }

    public void sendText(String text){
        switchToIframeArea();
        driver.findElement(textEditorArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextArea(){
        switchToIframeArea();
        String text = driver.findElement(textEditorArea).getText();
        switchToMainArea();
        return text;
    }

    public void clickIndentButton(){
        driver.findElement(indentButton).click();
    }

    public void switchToIframeArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
