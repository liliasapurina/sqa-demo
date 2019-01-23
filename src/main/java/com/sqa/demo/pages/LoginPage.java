package com.sqa.demo.pages;

import com.sqa.demo.page_blocks.login_page.LoginForm;

@PageObject
public class LoginPage {
    // LoginPage loginPage - вместо LoginPage loginPage = Selenide.page(SqaLoginSteps());
    @PageBlock
    LoginForm loginForm;

    public LoginPage login(String name, String password) {
        loginForm.setName(name);
        loginForm.setPassword(password);
        loginForm.submit();
        return this;
    }
}
