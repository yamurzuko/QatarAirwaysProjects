package page;

import base.BaseTest;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

public class FlyPage extends BaseTest {

    Logger logger = LogManager.getLogger(HomePage.class);
    Random rand = new Random();
    String beforeDepartureTime, beforeArrivalTime, afterDepartureTime, afterArrivalTime;

    @Step("<id> id li elemente tıkla <text> değerini gir")
    public void sendKeyById(String id, String text) {

        MobileElement element = appiumDriver.findElement(By.id(id));
        element.click();
        element.sendKeys(text);
    }
    @Step("<xpath> xpath li elemente tıklanır")
    public void clickStepButton(String xpath){
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));

        if(element.isDisplayed()){
            element.click();
        }
    }

    @Step("Bugünün tarihi +7 gün seçilir.")
    public void selectFlightDate(){

        new Actions(appiumDriver).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                                 .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                                 .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                                 .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                                 .sendKeys(Keys.ENTER).perform();

        logger.info("Tarih seçimi başarılı.");
    }

    @Step("<xpath> 'li uçuşlardan rastgele seç ve <departure> ile <arrival> değerlerini kaydet")
    public void randomSelectFly(String xpath, String departurePath, String arrivalPath) {

        int random = rand.nextInt(4);
        if (random==0){
            random = random+1;
        }

        MobileElement departure = appiumDriver.findElement(By.xpath(xpath + "[" + random + "]" + "/" + departurePath));
        beforeDepartureTime = departure.getAttribute("text");
        MobileElement arrival = appiumDriver.findElement(By.xpath(xpath + "["+ random +"]" + "/" + arrivalPath));
        beforeArrivalTime = arrival.getAttribute("text");

        MobileElement element = appiumDriver.findElement(By.xpath(xpath +"[" + random + "]"));
        element.click();

        logger.info("Rastgele ucus secimi basarili.");
    }

    @Step("<departurePath> ile <arrivalPath> sondaki uçuş saatleri verileri")
    public void lastDataFlyHours(String departurePath, String arrivalPath) {

        MobileElement departure = appiumDriver.findElement(By.xpath(departurePath));
        afterDepartureTime = departure.getAttribute("text");

        MobileElement arrival = appiumDriver.findElement(By.xpath(arrivalPath));
        afterArrivalTime = arrival.getAttribute("text");

        logger.info("Detaylı ucus listesindeki ucus saati verilerin kaydi basarili.");

        Assert.assertEquals("Uçuş saatlerinin önceki ve sonraki halleri eşit değil!",beforeDepartureTime,afterDepartureTime);
        Assert.assertEquals("Varış saatlerinin önceki ve sonraki halleri eşit değil!",beforeArrivalTime,afterArrivalTime);
    }
}
