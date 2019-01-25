package com.sqa.demo.smart_config;

import com.sqa_days_demo.config.pck.SmartConfig;
import com.sqa_days_demo.config.pck.SmartConfigProperties;

public class SmartConfigHolder {
    private static SmartConfig SMART_CONFIG;

    public static SmartConfig getSmartConfig() {
        SMART_CONFIG = SmartConfigProperties.getConfig(
                System.getProperty("env", "prod"),
                System.getProperty("locale", "ru")
        );
        return SMART_CONFIG;
    }
}
