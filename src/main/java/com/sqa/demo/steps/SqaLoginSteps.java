package com.sqa.demo.steps;

import com.sqa.demo.pages.LoginPage;
import com.sqa.demo.pages.MainPage;

@Steps
public class SqaLoginSteps {
    @PageObject
    LoginPage loginPage;

    @PageObject
    MainPage mainPage;

    public void asSqaUser(String user, Runnable actions) {
        // Пароли тестовых юзеров хранятся в env переменной; можно добавить конф. файл
        String password = System.getenv("user.password");
        loginPage.login(user, password);
        actions.run();
        mainPage.logout();
    }
}
