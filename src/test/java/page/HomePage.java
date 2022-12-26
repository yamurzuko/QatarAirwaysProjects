package page;

import base.BaseTest;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    Logger logger = LogManager.getLogger(HomePage.class);

    @Step("<id> id li element bulunur ve görünür mü kontrol edilir")
    public void checkOpenApp(String id){

        MobileElement element = appiumDriver.findElement(By.id(id));

        if (element.isDisplayed()) {
            Assert.assertTrue("Uygulama Açılmadı!", element.getText().equals("Get notified, never miss an offer!"));
            logger.info("Uygulama Başarılı Şekilde Açıldı");
        } else {
            System.out.println("Element Görünür Değil!");
        }
    }

    @Step("<id> id li elemente tıklanır")
    public void clickStepButton(String id){

        MobileElement element = appiumDriver.findElement(By.id(id));

        if(element.isDisplayed()){
            element.click();
        }
    }

}
