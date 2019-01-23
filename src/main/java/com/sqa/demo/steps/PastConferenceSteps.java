package com.sqa.demo.steps;

import com.sqa.demo.pages.MainPage;
import com.sqa.demo.pages.ProgramPage;
import io.qameta.allure.Step;

@Steps
public class PastConferenceSteps {
    @PageObject
    MainPage mainPage;

    @PageObject
    ProgramPage programPage;

    @Step("Verify icon and go to past conference")
    public PastConferenceSteps verifyDateAndPlaceAndGoToPastConference(String number, String date, String place) {
        mainPage.verifyPastConferenceDateAndPlace(number, date, place)
                .goToPastConference(number);
        return this;
    }

    @Step("Go to program and verify that section is finidhes")
    public PastConferenceSteps goToProgramAndVerifySectionFinished() {
        mainPage.goToProgram();
        programPage.verifySectionFinished();
        return this;
    }
}
