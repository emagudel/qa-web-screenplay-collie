package com.reto.tasks;

import com.reto.interactions.FileUpload;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import java.nio.file.Path;

import static com.reto.interactions.SeleniumActions.clearAndWriteField;
import static com.reto.interactions.SeleniumActions.clickField;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CreateExperience.*;
import static com.reto.userinterfaces.NewCampaign.BOTON_MANAGE_CAMPAIGN;
import static com.reto.userinterfaces.NewCampaign.BUTTON_UPLOAD;
import static com.reto.util.ConstantManager.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FillExperience {
    private FillExperience() {
    }

    public static Performable addExperience() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(BOTON_MANAGE_CAMPAIGN)).andIfSo(Click.on(BOTON_MANAGE_CAMPAIGN)));
            actor.attemptsTo(Wait.aTime(10));
            actor.attemptsTo(Click.on(BOTON_ADD_EXPERIENCE));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("experienceName")).into(TXT_NAME));
            actor.attemptsTo(Click.on(LIST_CATEGORY));
            actor.attemptsTo(Click.on(OPTION_LIST_CATEGORY.of(getInstance().getDatosPrueba().get("experienceCategory"))));
            actor.attemptsTo(SwagBagSelection.inApp());
            actor.attemptsTo(Click.on(BOTON_CREATE_EXPERIENCE));
            actor.attemptsTo(Wait.aTime(10));
        });
    }
    public static Performable addImage() {
        return Task.where(actor -> {
            Path imageExperience1 = Path.of(IMAGE_EXPERIENCE_ROAD_RUNNING).toAbsolutePath();
            Path imageExperience2 = Path.of(IMAGE_EXPERIENCE_TRAIL_RUN).toAbsolutePath();
            actor.attemptsTo(Check.whether(Visibility.of(LABEL_EXPERIENCE_IMAGES)).andIfSo(Click.on(LABEL_EXPERIENCE_IMAGES)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGE_EXPERIENCE)).andIfSo(Click.on(ADD_IMAGE_EXPERIENCE)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageExperience1)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGE_EXPERIENCE)).andIfSo(Click.on(ADD_IMAGE_EXPERIENCE)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageExperience2)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
        });
    }
    public static Performable addGeneralSettings() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(LABEL_GENERAL_SETTINGS)).andIfSo(Click.on(LABEL_GENERAL_SETTINGS)));
            Serenity.setSessionVariable("urlGeneralSettings").to(URL_GENERAL_SETTINGS.resolveFor(actor).getText());
            String urlGeneralSettings = Serenity.sessionVariableCalled("urlGeneralSettings");
            System.out.println(urlGeneralSettings);
        });
    }
    public static Performable addRegistrationOptions() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(ADD_REGISTRATION_OPTIONS)).andIfSo(Click.on(ADD_REGISTRATION_OPTIONS)));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Registration Name']]",getInstance().getDatosPrueba().get("registrationName")));
            actor.attemptsTo(clickField("//*[text()='Description (Recommended)']"));
            actor.attemptsTo(clearAndWriteField("//*[text()='Description (Recommended)']",getInstance().getDatosPrueba().get("description")));
            actor.attemptsTo(clickField("//*[@name='attendeesCapEnabled']"));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Maximum Attendees']]",getInstance().getDatosPrueba().get("attendeeCap")));
            actor.attemptsTo(Click.on(BOTON_SAVE_CONTINUE));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Minimum Fundraising (USD)']]",getInstance().getDatosPrueba().get("minimumFundraising")));
            actor.attemptsTo(Click.on(BOTON_SAVE_CONTINUE));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(clearAndWriteField("//*[@placeholder='Search']",getInstance().getDatosPrueba().get("nameProduct")));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Click.on(OPTION_SWAG_BAG.of(getInstance().getDatosPrueba().get("nameProduct"))));
            actor.attemptsTo(Click.on(BOTON_SAVE));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Click.on(BOTON_CLOSED_REGISTRATION_OPTIONS));
            actor.attemptsTo(Wait.aTime(7));
        });
    }
    public static Performable addEarlyBirdUrlCode() {
        return Task.where(actor -> {
            theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_EARLY_BIRD)).andIfSo(Click.on(LABEL_EARLY_BIRD)));
            actor.attemptsTo(Check.whether(Visibility.of(TXT_EARLY_BIRD_URL_CODE)).andIfSo(Click.on(TXT_EARLY_BIRD_URL_CODE)));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("urlCode")).into(TXT_EARLY_BIRD_URL_CODE));
            actor.attemptsTo(Click.on(BOTON_SAVE_EARLY_BIRD));
            actor.attemptsTo(Wait.aTime(5));
        });
    }
    public static Performable addWaiver() {
        return Task.where(actor -> {
            theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_WAIVER)).andIfSo(Click.on(LABEL_WAIVER)));
            actor.attemptsTo(clickField("//*[text()='Copy and Paste the Waiver here']"));
            actor.attemptsTo(clearAndWriteField("//*[text()='Copy and Paste the Waiver here']",getInstance().getDatosPrueba().get("description")));
            actor.attemptsTo(Click.on(BOTON_SAVE_WAIVER));
            actor.attemptsTo(Wait.aTime(5));
        });
    }
    public static Performable addDonationsOptions() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(ADD_DONATION_OPTIONS)).andIfSo(Click.on(ADD_DONATION_OPTIONS)));
            Path imageDonations = Path.of(IMAGE_DONATIONS).toAbsolutePath();
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGE_DONATIONS)).andIfSo(Click.on(ADD_IMAGE_DONATIONS)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageDonations)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Donation Amount']]",getInstance().getDatosPrueba().get("donationAmount")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Description']]",getInstance().getDatosPrueba().get("descriptionDonation")));
            actor.attemptsTo(Click.on(BOTON_ADD));
            actor.attemptsTo(Wait.aTime(5));
        });
    }
    public static Performable addStore() {
        return Task.where(actor -> {
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(clearAndWriteField("//*[@placeholder='Search']",getInstance().getDatosPrueba().get("storeProductName")));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Click.on(OPTION_STORE.of(getInstance().getDatosPrueba().get("storeProductName"))));
            actor.attemptsTo(Click.on(BOTON_ADD));
            actor.attemptsTo(Wait.aTime(5));
        });
    }
    public static Performable addTeamSettings() {
        return Task.where(actor -> {
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Maximum Teams']]",getInstance().getDatosPrueba().get("maximunTeam")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Maximum Team Members']]",getInstance().getDatosPrueba().get("maximunTeamMembers")));
            actor.attemptsTo(Click.on(BOTON_SAVE_TEAM_SETTINGS));
            actor.attemptsTo(Wait.aTime(5));
        });
    }
    public static Performable addBibPool() {
        return Task.where(actor -> {
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Bib Pool Name']]",getInstance().getDatosPrueba().get("bibPoolName")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Start Number']]",getInstance().getDatosPrueba().get("starNumber")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='End Number']]",getInstance().getDatosPrueba().get("endNumber")));
            actor.attemptsTo(Wait.aTime(3));
            actor.attemptsTo(Click.on(OPTION_ALLOCATION.of(getInstance().getDatosPrueba().get("allocation"))));
            actor.attemptsTo(Click.on(BOTON_SAVE_BIB_POOL));
            actor.attemptsTo(Wait.aTime(7));
        });
    }
}
