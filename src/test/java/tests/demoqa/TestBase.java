package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {


    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com"; // Задать базовый УРЛ.
        Configuration.browserSize = "1920x1080"; // задать желаемый размер экрана.
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; // путь запуска

        // копипаста для подключения видео отчётов.
        DesiredCapabilities capabilities = new DesiredCapabilities(); // capabilities - ключи и значения
        capabilities.setCapability("enableVNC", true); // enableVNC ключ его значение true
        capabilities.setCapability("enableVideo", true); // enableVideo - ключ его значение true
        Configuration.browserCapabilities = capabilities;
        // EnableVideo - делать записи или нет
        // EnableVNC - транслировать ui или нет. т.е установив false не будет видно окна с тем что происходит.
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }


}


