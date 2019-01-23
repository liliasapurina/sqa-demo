package com.sqa.demo.page_blocks.main_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

@PageBlock
public class ConferenceIcon {
    @FindBy(className = "conf-date")
    SelenideElement conferenceDate;

    @FindBy(className = "conf-place")
    SelenideElement conferencePlace;

    public void verifyConferenceDate(String expectedDate) {
        assertTrue("Conference date is not " + expectedDate + "; actual value = " + conferenceDate.getText(), conferenceDate.getText().contains(expectedDate));
    }

    public void verifyConferencePlace(String expectedPlace) {
        assertTrue("Conference place is not " + expectedPlace + "; actual value = " + conferencePlace.getText(), conferencePlace.getText().equals(expectedPlace));
    }

    public void clickOnIcon() {
        conferenceDate.click();
    }
}
