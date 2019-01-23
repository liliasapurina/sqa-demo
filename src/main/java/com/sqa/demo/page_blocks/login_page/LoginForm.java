package com.sqa.demo.page_blocks.login_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.sqa.demo.smart_config.SmartConfigHolder.getSmartConfig;

@FindBy(className = "login-form")
public class LoginForm {
    // == @FindBy(className = "login-form") => берёт локатор родительского класса
    @FullPageBlock
    SelenideElement loginForm;

    @FindBy(name = "login")
    SelenideElement nameField;

    @FindBy(name = "password")
    SelenideElement passwordField;

    @FindBy(className = "ic-submit")
    SelenideElement submitButton;

    public void verifyLoginFormVisible() {
        loginForm.waitUntil(visible, getSmartConfig().getMainTimeout());
    }

    public void setName(String name) {
        nameField.sendKeys(name);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submit() {
        submitButton.click();
    }
}
