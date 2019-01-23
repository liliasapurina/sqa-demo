package com.sqa.demo.utils;

public interface SQAInterface {
    default void asSqaUser(String userName, Runnable actions) {
        // auth logic - see SqaLoginSteps
    }
}
