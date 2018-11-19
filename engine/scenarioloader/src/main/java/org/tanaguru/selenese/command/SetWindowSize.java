package org.tanaguru.selenese.command;

import jp.vmi.selenium.selenese.Context;
import jp.vmi.selenium.selenese.command.AbstractCommand;
import jp.vmi.selenium.selenese.command.ArgumentType;
import jp.vmi.selenium.selenese.result.Result;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static jp.vmi.selenium.selenese.result.Success.SUCCESS;

public class SetWindowSize extends AbstractCommand {
    private static final int ARG_DIMENSION = 0;

    public SetWindowSize(int index, String name, String[] args, ArgumentType... argTypes) {
        super(index, name, args, ArgumentType.VALUE);
    }

    @Override
    protected Result executeImpl(Context context, String... curArgs) {
        WebDriver driver = (WebDriver) context.getWrappedDriver();
        String dimStr = curArgs[ARG_DIMENSION];
        String[] dimSplited = dimStr.split("x");
        driver.manage().window().setSize(new Dimension(Integer.valueOf(dimSplited[0]), Integer.valueOf(dimSplited[1])));
        return SUCCESS;
    }
}
