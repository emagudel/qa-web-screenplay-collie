package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.LoginRegistration.*;
import static com.reto.userinterfaces.Register.BUTTON_CONTINUE;
import static com.reto.userinterfaces.Register.BUTTON_REGISTER_NOW;

public class LoginRegistration {
    private LoginRegistration() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_REGISTER_NOW)).andIfSo(Click.on(BUTTON_REGISTER_NOW)));
            actor.attemptsTo(Check.whether(Visibility.of(TXT_EMAIL)).andIfSo(
                    Enter.theValue(getInstance().getDatosPrueba().get("userRegistration")).into(TXT_EMAIL))
            );
            actor.attemptsTo(Check.whether(Visibility.of(TXT_PASSWORD)).andIfSo(
                    Enter.theValue(getInstance().getDatosPrueba().get("passwordRegistration")).into(TXT_PASSWORD))
            );
            actor.attemptsTo(Click.on(BOTON_LOGIN));
            actor.attemptsTo(Wait.aTime(10));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_REGISTER_NOW)).andIfSo(Click.on(BUTTON_REGISTER_NOW)));
            actor.attemptsTo(Wait.aTime(10));
            actor.attemptsTo(Ensure.that(BUTTON_CONTINUE).isDisplayed());
        });
    }
}
