package com.sqa.demo.page_blocks.main_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.sqa.demo.smart_config.SmartConfigHolder.getSmartConfig;
import static org.junit.Assert.assertTrue;

@FindBy(id = "conf-top-block")
public class TopBlock {
    @FullPageBlock
    SelenideElement topBlock;

    @FindBy(id = "counter")
    SelenideElement counter;

    public void verifyTopBlockVisible() {
        topBlock.waitUntil(visible, getSmartConfig().getMainTimeout());
    }

    public void verifyEventIsOver() {
        assertTrue("Counter value equals to " + counter.getText(), counter.getText().equals("Event is over"));
    }
}
