package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ChromeTest {

    @Test
    public void shouldBeAppointmentMeeting() {

        String ld = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        open("http://localhost:9999"); // открываем страницу
        $("[data-test-id = 'city'] input").setValue("Краснодар"); // находим элемент (поле "Город") и вводим туда текст
        $("[data-test-id = 'date'] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // предварительная чистка поля с датой по умолчанию
        $("[data-test-id = 'date'] input").setValue(ld); // находим элемент (поле "Дата") и вводим туда новую дату
        $("[data-test-id = 'name'] input").setValue("Шишкин Алексей"); // находим элемент (поле "Фамилия Имя") и вводим туда текст
        $("[data-test-id = 'phone'] input").setValue("+79371458228"); // находим элемент (поле "Телефон") и вводим туда текст
        $("[class='checkbox__box']").click(); // находим элемент (поле "Чек-бокс") и кликаем по нему
        $("[class='button__text']").click(); // находим элемент (кнопка "Забронировать") и кликаем по нему
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15)); // находится элемент содержащий определённый текст и проверяем что этот элемент с текстом появился через 15 секунд
        $("[class='notification__content']").shouldHave(exactText("Встреча успешно забронирована на " + ld), Duration.ofSeconds(15)); // находим элемент содержащий определённый текст и проверяем что этот элемент с текстом появился через 15 секунд, добавляем к элементу переменную с датой брони
    }

}
