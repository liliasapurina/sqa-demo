package com.sqa.demo.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class PageHtmlRunListener extends RunListener {
    private static final String FAIL_HTML_NAME_SUFFIX = "FAIL";

    public PageHtmlRunListener() {
    }

    public void testFailure(Failure failure) {
        Description description = failure.getDescription();
        // Если есть аннотация html
        Html htmlAnnotation = (Html) AnnotationsUtils.getAnnotation(description, Html.class);
        boolean attachHtml = htmlAnnotation != null ? htmlAnnotation.value() : Boolean.valueOf(Configuration.HTML.getValue()).booleanValue();
        if (attachHtml && WebDriverRunner.hasWebDriverStarted()) {
            AllureUtilsE2E.attachPageHtml(WebDriverRunner.source(), description.getDisplayName() + "-" + "FAIL");
        }
    }
}
