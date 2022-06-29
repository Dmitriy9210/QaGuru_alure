import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepTests {
    @Test
    void googleTest() {
        Allure.label("owner", "Dima");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature(" Ищем");
        Allure.story("Ищем лучше");
        Allure.link("линка", "google.com");

        String text = "yandex";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();
        steps.openGoogle().findText(text).checkText(text).attachment();

    }

}
