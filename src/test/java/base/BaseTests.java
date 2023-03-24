package base;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    private WebDriver driver;

    protected HomePage homePage;
    protected LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        String driverExtention = "";
        if (System.getenv("RUNNER_OS") != null) {
            driverExtention = "-linux";
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver" + driverExtention);
        } else {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        }


        ChromeOptions o = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(System.getenv("HEADLESS_CHROME")) | false;
        o.setHeadless(headless);
        //o.addArguments("--incognito");
        DesiredCapabilities c = DesiredCapabilities.chrome();
        c.setCapability(ChromeOptions.CAPABILITY, o);

        driver = new ChromeDriver(o);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        //Provide a handler to the home page, from the framework level -->
        homePage = new HomePage(driver);
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

/*    //We donde need it cos we are using the testNg annotations
    public static void main(String[] args) {
        BaseTests baseTests = new BaseTests();
        baseTests.setUp();
    }*/
}
