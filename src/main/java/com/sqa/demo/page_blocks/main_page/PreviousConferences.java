package com.sqa.demo.page_blocks.main_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

@PageBlock
@FindBy(id = "previous-conference-block")
public class PreviousConferences {
    @FindBy(css = ".list .conference")
    AutoRefreshableElementsCollection conferencesList;

    public ConferenceIcon getConferenceByNumber(String number) {
        Optional<SelenideElement> conferenceWithNumber = conferencesList.stream()
                .filter(conferenceIcon -> conferenceIcon.find(By.className("conf-number")).getText().equals(number))
                .findAny();
        return conferenceWithNumber.map(selenideElement -> PageObjectsUtils.create(ConferenceIcon.class, selenideElement)).orElse(null);
    }
}
