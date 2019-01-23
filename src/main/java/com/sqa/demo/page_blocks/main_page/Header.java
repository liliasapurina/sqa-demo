package com.sqa.demo.page_blocks.main_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

@PageBlock
@FindBy(className = "header")
public class Header {
    @FindBy(className = "login")
    SelenideElement loginButton;

    @FindBy(className = "index-logout-link")
    SelenideElement logoutButton;

    @FindByTitle(title = "Program", element = FindByTitle.Element.OTHER)
    SelenideElement programLink;

    public void login() {
        loginButton.click();
    }

    public void goToProgram() {
        programLink.click();
    }

    public void logout() {
        logoutButton.click();
    }
}
