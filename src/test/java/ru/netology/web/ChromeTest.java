package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChromeTest {
    private WebDriver driver;// основная сущность c полем драйвер

    @BeforeAll
    public static void setUpClass() { // метод вызывается 1 раз перед проходом всех тестов
        WebDriverManager.chromedriver().setup(); // указываем что используем и где оно у нас лежит (путь)
    }

    @BeforeEach // выполняется перед каждым тестом
    public void setupTest() { // перед каждым тестом создаём хром драйвер
        ChromeOptions options = new ChromeOptions(); // в режиме headless мы отключаем графический интерфейс браузера (при этот все процессы браузера продолжают работать так же)
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach // выполняется после каждого теста
    public void tearDown() { // после каждого теста закрываем браузер и присваиваем null полю driver
        if (driver != null) {
            driver.quit();
        }
    }
}
