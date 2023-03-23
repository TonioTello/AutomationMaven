package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;

    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropDown (String option){
        //Select is a class from selenium support dependecy
        Select dropDownElement = new Select(driver.findElement(dropdown));
        dropDownElement.selectByVisibleText(option);
    }


    public List<String> getSelectedOptions(){
        Select dropDownElement = new Select(driver.findElement(dropdown));
        List<WebElement> selectedElementes =  dropDownElement.getAllSelectedOptions();
        return selectedElementes.stream().map(e->e.getText()).collect(Collectors.toList());

    }

}
