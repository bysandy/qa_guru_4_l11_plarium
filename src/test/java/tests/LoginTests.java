package tests;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Successful Login with Google authorisation")
    void loginWithGoogle(){
        open("");

        $(by("data-qa-entity", "header.login"))
                .click();
        $(by("data-qa-entity", "login.email.section"))
                .setValue("plariumby@gmail.com");
        $(by("data-qa-entity", "auth.next.step"))
                .click();
        $(by("data-qa-entity", "login.password.section"))
                .setValue("Plariumby!2");
        $(by("data-qa-entity", "auth.send.button")).shouldBe(enabled)
               .click();
        $(by("data-qa-entity", "choose.close"))
                .click();

        $(by("data-qa-payload", "{\"title_name\":\"Моя библиотека\"}"))
                .shouldBe(visible);

    }
}
