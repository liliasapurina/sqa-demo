package com.sqa.demo.utils;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;


@Listeners({AllureJunit4.class, ScreenshotRunListener.class, PageHtmlRunListener.class, BrowserLogsListener.class /*, ... - Перечисление всех кастомных листенеров*/})
public class SqaCustomRunner extends BlockJUnit4ClassRunner {
    public SqaCustomRunner(Class<?> type) throws InitializationError {
        // Инициализация Dependency Injection класса, инициализация листенеров
        super(type, FieldsInjectorsE2E.DEFAULT_E2E_INJECTOR, ((Listeners) com.db.automato.junit4.runners.AutomatoE2ERunner.class.getAnnotation(Listeners.class)).value());
    }

    void initEnvironment() {
        // Создание web driver-а
    }

    void finalizeEnvironment() {
        // Закрытие web driver-а
    }
}
