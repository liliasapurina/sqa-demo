package com.sqa.demo.tests;

import com.sqa.demo.steps.PastConferenceSteps;
import com.sqa.demo.steps.SqaLoginSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.sqa.demo.smart_config.SmartConfigHolder.getSmartConfig;
import static io.qameta.allure.SeverityLevel.BLOCKER;

// В Allure отчете будет текстовый файл с ошибками из консоли браузера
@BrowserLogs
// В случае ошибки в отчет будет приложен файл с исходной разметкой страницы, на которой произошла ошибка
@Html
// Вместо обычных скриншотов - полноэкранные
@WholeDesktopScreenshots
@Feature("App Admin cleanup")
@Severity(value = BLOCKER)
@DisplayName("SQA Days Demo - Verify past conference page")
@RunWith(AutomatoE2ERunner.class)
public class SqaDemoTest implements E2ETest/*implements SQAInterface*/ {
    String testUser = getSmartConfig().getTestUser();
    String conferenceNumber = "14";
    String conferenceDate = "November 2013";
    String conferencePlace = "Львов";

    // Dependency injection - вместо SqaLoginSteps sqaLoginSteps = new SqaLoginSteps();
    @Steps
    SqaLoginSteps sqaLoginSteps;

    @Steps
    PastConferenceSteps pastConferenceSteps;

    @Test
    public void test() {
        // Lambda-выражение для аунтификации; можно определить как интерфейс и не использовать статически
        sqaLoginSteps.asSqaUser(testUser, () -> {
            pastConferenceSteps.verifyDateAndPlaceAndGoToPastConference(conferenceNumber, conferenceDate, conferencePlace)
                    .goToProgramAndVerifySectionFinished();
        });
    }
}
