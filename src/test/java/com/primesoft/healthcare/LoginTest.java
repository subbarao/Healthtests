package com.primesoft.healthcare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class LoginTest {

  WebDriver driver;

  @Before
  public void setUp() throws InterruptedException, MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    capabilities.setVersion("70.0");
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", false);

    driver =
        new RemoteWebDriver(
            URI.create("http://ec2-54-221-14-113.compute-1.amazonaws.com:4444/wd/hub").toURL(),
            capabilities);

    driver.get("https://hidden-chamber-33381.herokuapp.com/#/");
    Thread.sleep(5000);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testLogin() throws InterruptedException {
    driver
        .findElement(By.xpath("//*[@id='app-view-container']/div[1]/div/div/div[1]/div/div[1]/a"))
        .click();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("admin");
    driver.findElement(By.xpath("//*[@id='login-page']/div/form/div[3]/button[2]")).click();
  }
}
