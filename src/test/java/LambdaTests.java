import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTests {

    @Owner("Dmitriy")
    @Severity(SeverityLevel.MINOR)
    @Feature("Что-то делать")
    @Story("Тлчто что-то делать")
    @DisplayName("Поехали в яндекс")
    @Link(value = "link", url = "ya.ru")
    @Test
    void testYa() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем Ya", () -> {
            open("https://ya.ru/");
        });

        step("Ищем в поиске", () -> {
            $(".mini-suggest__input").setValue("Selenide").pressEnter();
        });

        step("Сверяем результат", () -> {
            $(".main__center").shouldHave(Condition.text("selenide.org"));
            Allure.getLifecycle().addAttachment("Исходники", "text/html", "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });
    }
}
