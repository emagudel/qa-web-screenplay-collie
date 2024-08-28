package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.TIME_OUT_20;
import static net.serenitybdd.screenplay.targets.Target.the;

public class CreateExperience {
    public static final Target BOTON_ADD_EXPERIENCE = the("Button add experience")
            .located(By.xpath("//button[span[text()='Add experience']]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target TXT_NAME = the("Name experience")
            .located(By.xpath("//*[@name='name']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LIST_CATEGORY = the("Categoty experience")
            .located(By.xpath("//*[@id='mui-component-select-experienceCategory']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target OPTION_LIST_CATEGORY = the("Option categoty list")
            .locatedBy("//*[@data-value='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_CREATE_EXPERIENCE = the("Button create experience")
            .located(By.xpath("//button[text()='Create']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_EXPERIENCE_IMAGES = the("Label experience imagens")
            .located(By.xpath("//*[text()='Experience Images']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_IMAGE_EXPERIENCE = the("Add image experience")
            .located(By.xpath("(//*[@data-test='addImageButton'])[1]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_GENERAL_SETTINGS = the("Label general settings")
            .located(By.xpath("//*[text()='General Settings']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target URL_GENERAL_SETTINGS = the("URL general settings")
            .located(By.xpath("//*[@target='_blank']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));


}
