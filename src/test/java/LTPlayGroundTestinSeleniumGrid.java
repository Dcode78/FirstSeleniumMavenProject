import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class LTPlayGroundTestinSeleniumGrid {
    public String username = "";
    public String authkey = "";
    public static RemoteWebDriver driver = null;
    public String hub = "@hub.lambdatest.com/wd/hub";

        @BeforeMethod
        public void setup(Method m, ITestContext ctx) throws MalformedURLException {


            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platform", "MacOS Catalina");
            caps.setCapability("browserName", "Safari");
            caps.setCapability("version", "latest");
            caps.setCapability("build", "TestNG With Java");
            caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
            caps.setCapability("plugin", "git-testng");

            String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
            caps.setCapability("tags", Tags);

            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

        }
        @Test
        public void testCheckBoxStatus(){
            driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
            //get the WebElement of Check Box

            WebElement singleCheckBox= driver.findElement(By.id("isAgeSelected"));
            //click that check box
            singleCheckBox.click();

            //Validate check box is selected or not
            Assert.assertTrue(singleCheckBox.isSelected(),"Checkbox is not selected ");

    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
        System.out.println("Closing the browser");

    }

}


