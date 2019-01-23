package com.sqa.demo.smart_config;

import com.sqa_days_demo.config.pck.SmartConfig;
import com.sqa_days_demo.config.pck.SmartConfigProperties;

import static smart_config.SmartConfigSystemKeys.*;
import static smart_config.SmartConfigSystemValues.*;

public class SmartConfigHolder {
    private static SmartConfig SMART_CONFIG;

    public static SmartConfig getSmartConfig() {
        SMART_CONFIG = SmartConfigProperties.getConfig(
                System.getProperty(INFRA.toString(), GREEN.toString()),
                System.getProperty(AGENT.toString(), LOCAL.toString()).replaceAll("-", ""),
                System.getProperty(ENV.toString(), SIT.toString()),
                System.getProperty(ZONE.toString(), UK.toString()),
                System.getProperty(LOCATION.toString(), INT.toString())
        );
        return SMART_CONFIG;
    }
}
