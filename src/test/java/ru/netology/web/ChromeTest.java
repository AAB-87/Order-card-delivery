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
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChromeTest {

    @Test
    public void shouldBeAppointmentMeeting() {
        open("http://localhost:9999"); // открываем страницу
        $("[data-test-id = 'city'] input").setValue("Краснодар"); // находим элемент (поле "Город") и вводим туда текст
        $("[data-test-id = 'date'] input").setValue("15.12.2021"); // находим элемент (поле "Дата") и вводим туда текст
        $("[data-test-id = 'name'] input").setValue("Семёнов Алексей"); // находим элемент (поле "Фамилия Имя") и вводим туда текст
        $("[data-test-id = 'phone'] input").setValue("+79371458228"); // находим элемент (поле "Телефон") и вводим туда текст
        $("[class='checkbox__box']").click(); // находим элемент (поле "Телефон") и кликаем по нему
        $("[class='button__text']").click(); // находим элемент (кнопка "Забронировать") и кликаем по нему
        $("").click(); // находим элемент (кнопка "Забронировать") и кликаем по


    }


}
