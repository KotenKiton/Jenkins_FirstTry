package tests.demoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("demoqa") // тэг для запуска отдельно этого класса из грэдла
public class RegistrationFormTest extends TestBase {

    @Test // Аннотация тест всегда ставить наверх
    @DisplayName("Successful fill registration test") // всегда вниз
    void fillFormTest() {

        step("Open registration form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });
        step("Fill registration from", () -> {
            $("#firstName").val("James");
            $("#lastName").setValue("Bond");
            $("#userEmail").setValue("James@Bond.com");
            $(".custom-radio:nth-child(1) > .custom-control-label").click();
            $("#userNumber").setValue("88005553535");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1994");
            $(".react-datepicker__day--020").click();
            $(".subjects-auto-complete__value-container").click();
            $("#subjectsInput").val("m");
            $("#subjectsInput").sendKeys(Keys.DOWN);
            $("#subjectsInput").sendKeys(Keys.DOWN);
            $("#subjectsInput").sendKeys(Keys.ENTER);
            $(".custom-checkbox:nth-child(1) > .custom-control-label").click();// Hobbies.
            $(".custom-checkbox:nth-child(2) > .custom-control-label").click();// Hobbies.
            $("#uploadPicture").uploadFromClasspath("img/Me.png"); // Select picture.
            $("#currentAddress").val("My street");
            $("#state").click();
            $("#react-select-3-option-1").click();
            $("#city").click();
            $("#react-select-4-option-1").click();
            $("#submit").click();
        });

        step("Verify form data ", () -> {

            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            // Делал ошибку в том,что обращался к классу через #.
        });
    }
    //$(".table-responsive").shouldHave(text("James Bond"), text("James@Bond.com"), text("Male"),
    // text("8800555353"), text("20 July,1994"), text("Computer Science"), text("Sports, Reading"),
    // text("James Bond"), text("Me.png"), text("My street"), text("Uttar Pradesh Lucknow"));
}


