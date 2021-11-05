package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.awt.SystemColor.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest1() throws InterruptedException {
        driver.get("http://localhost:9999");
        Thread.sleep (1000);
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Александра");
        Thread.sleep (1000);
        driver.findElement(By.cssSelector("[data-test-id=phone] input ")).sendKeys("+79999999988");
        Thread.sleep (1000);
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        Thread.sleep (1000);
        driver.findElement(By.cssSelector("[type='button']")).click();
        Thread.sleep (1000);
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);
    }
}