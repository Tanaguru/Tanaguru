package org.tanaguru.selenese.command;

import jp.vmi.selenium.selenese.Context;
import jp.vmi.selenium.selenese.command.AbstractCommand;
import jp.vmi.selenium.selenese.command.ArgumentType;
import jp.vmi.selenium.selenese.result.Result;
import org.tanaguru.webdriver.driver.TanaguruDriver;

import static jp.vmi.selenium.selenese.result.Success.SUCCESS;

public class TanaguruAudit extends AbstractCommand {
    private static final int ARG_VALUE = 1;

    public TanaguruAudit(int index, String name, String[] args, ArgumentType... argTypes) {
        super(index, name, args, ArgumentType.LOCATOR, ArgumentType.VALUE);
    }

    @Override
    protected Result executeImpl(Context context, String... strings) {
        TanaguruDriver driver = (TanaguruDriver) context.getWrappedDriver();
        driver.fireNewPage(driver.getCurrentUrl(), false, strings[ARG_VALUE]);
        return SUCCESS;
    }
}
