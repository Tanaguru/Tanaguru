package org.tanaguru.selenese.command;

import jp.vmi.selenium.selenese.Context;
import jp.vmi.selenium.selenese.command.AbstractCommand;
import jp.vmi.selenium.selenese.command.ArgumentType;
import jp.vmi.selenium.selenese.result.Result;
import jp.vmi.selenium.selenese.result.Success;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.tanaguru.webdriver.driver.TanaguruDriver;

import static jp.vmi.selenium.selenese.result.Success.SUCCESS;

public class TanaguruClick extends AbstractCommand {

    private static final int ARG_LOCATOR = 0;

    /**
     * Constructor.
     *
     * @param index    command index.
     * @param name     command name.
     * @param args     command args.
     * @param argTypes command argument types.
     */
    public TanaguruClick(int index, String name, String[] args, ArgumentType... argTypes) {
        super(index, name, args, ArgumentType.LOCATOR);
    }

    @Override
    protected Result executeImpl(Context context, String... curArgs) {
        String locator = curArgs[ARG_LOCATOR];
        TanaguruDriver driver = (TanaguruDriver) context.getWrappedDriver();
        boolean isRetryable = !context.getCurrentTestCase().getSourceType().isSelenese();
        int timeout = context.getTimeout(); /* ms */
        WebElement element = context.getElementFinder().findElementWithTimeout(driver, locator, isRetryable, timeout);
        context.getJSLibrary().replaceAlertMethod(driver, element);
        try {
            element.click();

            //Fire onClick event
            driver.onSeleneseClick();
            return SUCCESS;
        } catch (ElementNotInteractableException e) {
            context.executeScript("arguments[0].click()", element);

            //Fire onClick event
            driver.onSeleneseClick();
            return new Success("Success (the element is not visible)");
        }


    }
}
