package com.alasdoo.developercourseassignment.e2e.common;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;

public class TakeScreenshotAfterFailure implements AfterTestExecutionCallback {

   WebDriverUtils webDriverUtils;

    @Override
    public void afterTestExecution(ExtensionContext context) throws IOException {
        boolean check = context.getExecutionException().isPresent();

        if (check) {
          webDriverUtils.takeScreenshot(context.getDisplayName());
        }
    }
}
