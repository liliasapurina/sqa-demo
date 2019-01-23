package com.sqa.demo.page_blocks.program;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.sqa.demo.smart_config.SmartConfigHolder.getSmartConfig;
import static org.junit.Assert.assertTrue;

@PageBlock
@FindBy(className = "program-data-block")
public class ProgramDataBlock {
    @FullPageBlock
    SelenideElement programDataBlock;

    @FindBy(className = "old-program")
    SelenideElement oldProgram;

    public void verifyProgramVisible() {
        programDataBlock.waitUntil(visible, getSmartConfig().getMainTimeout());
    }

    public void verifySectionFinished() {
        String agendaValue = oldProgram.$("strong").getText();
        assertTrue("Agenda value is " + agendaValue, agendaValue.equals("Talk selection is finished. The agenda can change insignificantly up to the conference."));
    }
}
