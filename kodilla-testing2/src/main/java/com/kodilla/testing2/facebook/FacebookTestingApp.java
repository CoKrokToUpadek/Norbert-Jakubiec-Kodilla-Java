package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String ACCEPT_COOKIES_BUTTON = "//div[@class=\"_9xo5\"]/button[1]";
    public static final String CREATE_ACCOUNT_BUTTON = "//div[@class=\"_6ltg\"][2]/a";
    public static final String SELECT_DAY = "//select[@name=\"birthday_day\"]";
    public static final String SELECT_MONTH = "//select[@name=\"birthday_month\"]";
    public static final String SELECT_YEAR = "//select[@name=\"birthday_year\"]";

    public static final String FORM_IS_LOADED = "//span[@class=\"_5k_4\"]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(ACCEPT_COOKIES_BUTTON)).click();

        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON)).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORM_IS_LOADED)));

        WebElement day=driver.findElement(By.xpath(SELECT_DAY));
        Select daySelect=new Select(day);
        daySelect.selectByValue("10");


        WebElement month=driver.findElement(By.xpath(SELECT_MONTH));
        Select monthSelect=new Select(month);
        monthSelect.selectByValue("6");


        WebElement year=driver.findElement(By.xpath(SELECT_YEAR));
        Select yearSelect=new Select(year);
        yearSelect.selectByValue("1975");


    }
}
