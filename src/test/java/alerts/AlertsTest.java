package alerts;

import Pages.AlertsPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTest extends BaseTests {

    @Test
    public void testAcceptAlert(){

        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        //alertsPage.click_acceptAlert();
        alertsPage.click_dsmissAlert();
        assertEquals(alertsPage.getResults(), "You successfully clicked an alert", "Alert");


    }
}
