package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.FlyPage;
import page.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid = true;
    DesiredCapabilities desiredCapabilities;
    final static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeScenario
    public void setup() throws MalformedURLException {
        logger.info("!!!!!!!!!!! Localde test başlıyor !!!!!!!!!!");

        if (localAndroid){
            logger.info("!!!!!!!!!!! Localde Android  testi başlıyor !!!!!!!!!!");

            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.m.qr");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.m.qr.home.main.ui.HomeActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url, desiredCapabilities);
        }else {
            logger.info("!!!!!!!!!!! Localde İos testi  başlıyor !!!!!!!!!!");

            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "lokalinizde bağlı olan telefonun udid bilgisini gir");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "bundle id bilgisini gir");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "lokaldeki telefonun ismini gir");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "lokaldeki telefon version bilgisini gir");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new IOSDriver(url, desiredCapabilities);
        }
    }
    @AfterScenario
    public void teardown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
