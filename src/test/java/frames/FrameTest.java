package frames;

import Pages.WysiwygEditorPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTests {

    @Test
    public void testWysiwyg(){
        String text1 = "Hello";
        String text2 = "word";
        WysiwygEditorPage wysiwygEditorPage = homePage.clickwysiwygEditor();

        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.sendText(text1);
        wysiwygEditorPage.clickIndentButton();
        wysiwygEditorPage.sendText(text2);
        assertEquals(wysiwygEditorPage.getTextArea(), text1+text2, "Error");

    }
}
