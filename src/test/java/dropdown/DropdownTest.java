package dropdown;

import Pages.DropdownPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.List;

public class DropdownTest extends BaseTests {

    @Test
    public  void  testSelectOption(){
        String option = "Option 2";
        DropdownPage dropdownPage = homePage.clickDropDown();
        dropdownPage.selectFromDropDown(option);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option no selected");

    }

}
