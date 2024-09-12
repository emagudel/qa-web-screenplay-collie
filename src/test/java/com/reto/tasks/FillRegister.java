package com.reto.tasks;

import com.reto.interactions.AddOption;
import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.Keys;

import static com.reto.interactions.SeleniumActions.*;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CreateExperience.ADD_REGISTRATION_OPTIONS;
import static com.reto.userinterfaces.Register.*;

public class FillRegister {
    private FillRegister() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            String dataItemOption = getInstance().getDatosPrueba().get("minor");
            int itemOption = 1;
            int positionObject = 1;

            if(dataItemOption.isEmpty()){
                actor.attemptsTo(AddOption.item(1));
            }else{
                positionObject++;
                itemOption++;
                itemOption = Integer.parseInt(dataItemOption);
                actor.attemptsTo(AddOption.item(itemOption));
            }

            for (int i = 1; i < itemOption; i++) {
                actor.attemptsTo(clearAndWriteField("//*[@data-test='Phone Number']", getInstance().getDatosPrueba().get("phone_number")));
                actor.attemptsTo(Click.on(COMBOBOX_GENDER));
                actor.attemptsTo(Click.on(SELECT_GENDER.of(getInstance().getDatosPrueba().get("gender"))));
                actor.attemptsTo(Click.on(TXT_ADDRESS));
                actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_ADDRESS));
                actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_ADDRESS));
                actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("address")).into(TXT_ADDRESS));
                actor.attemptsTo(Click.on(TXT_CITY));
                actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_CITY));
                actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_CITY));
                actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("city")).into(TXT_CITY));
                actor.attemptsTo(Click.on(TXT_STATE));
                actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_STATE));
                actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_STATE));
                actor.attemptsTo(SendKeys.of(getInstance().getDatosPrueba().get("state")).into(TXT_STATE));
                actor.attemptsTo(Click.on(TXT_ZIP_CODE));
                actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_ZIP_CODE));
                actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_ZIP_CODE));
                actor.attemptsTo(Type.theValue(getInstance().getDatosPrueba().get("zip_code")).into(TXT_ZIP_CODE));
                actor.attemptsTo(Click.on(CHECK_WAIVER));
                actor.attemptsTo(Click.on(SIGNATURE_WAIVER));
                actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(SIGNATURE_WAIVER));
                actor.attemptsTo(SendKeys.of(Keys.DELETE).into(SIGNATURE_WAIVER));
                actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("signature_waiver")).into(SIGNATURE_WAIVER));
                if (itemOption > 1){
                    actor.attemptsTo(clickField("(//*[@data-testid='AccountCircleOutlinedIcon'])["+positionObject+"]"));
                    actor.attemptsTo(Wait.aTime(3));
                    actor.attemptsTo(clickField("(//*[@data-testid='CheckBoxOutlineBlankIcon'])[1]"));
                    actor.attemptsTo(Wait.aTime(3));
                    actor.attemptsTo(clickField("//*[@id='mui-component-select-minor']"));
                    actor.attemptsTo(clickField("//*[@role='option' and text()='"+getInstance().getDatosPrueba().get("name_minor")+"']"));
                    actor.attemptsTo(Wait.aTime(3));
                    positionObject++;
                    itemOption++;
                }
            }
            actor.attemptsTo(Click.on(BOTON_CONTINUE));
        });
    }
}
