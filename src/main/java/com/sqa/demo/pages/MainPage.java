package com.sqa.demo.pages;

import com.sqa.demo.page_blocks.login_page.LoginForm;
import com.sqa.demo.page_blocks.main_page.ConferenceIcon;
import com.sqa.demo.page_blocks.main_page.Header;
import com.sqa.demo.page_blocks.main_page.PreviousConferences;
import com.sqa.demo.page_blocks.main_page.TopBlock;
import com.sqa.demo.page_blocks.program.ProgramDataBlock;

@PageObject
public class MainPage {
    @PageBlock
    Header header;

    @PageBlock
    LoginForm loginForm;

    @PageBlock
    TopBlock topBlock;

    @PageBlock
    PreviousConferences previousConferences;

    @PageBlock
    ProgramDataBlock programDataBlock;

    public MainPage openLoginPage() {
        header.login();
        loginForm.verifyLoginFormVisible();
        return this;
    }

    public MainPage verifyPastConferenceDateAndPlace(String number, String expectedDate, String expectedPlace) {
        ConferenceIcon conferenceIcon = previousConferences.getConferenceByNumber(number);
        conferenceIcon.verifyConferenceDate(expectedDate);
        conferenceIcon.verifyConferencePlace(expectedPlace);
        return this;
    }

    public MainPage goToPastConference(String number) {
        ConferenceIcon conferenceIcon = previousConferences.getConferenceByNumber(number);
        conferenceIcon.clickOnIcon();
        topBlock.verifyTopBlockVisible();
        topBlock.verifyEventIsOver();
        return this;
    }

    public MainPage goToProgram() {
        header.goToProgram();
        programDataBlock.verifyProgramVisible();
        return this;
    }

    public MainPage logout() {
        header.logout();
        topBlock.verifyTopBlockVisible();
        return this;
    }
}
