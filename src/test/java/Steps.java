import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {
    @Step("открываем гугл")
    public Steps openGoogle() {
        open("https://www.google.ru/");
        return this;
    }

    @Step("Вводим текст")
    public Steps findText(String text) {
        $(byName("q")).setValue(text).pressEnter();
        return this;
    }

    @Step("Проверяем найденное")
    public Steps checkText(String text){
        $("#center_col").shouldHave(Condition.text(text));
    return this;
    }

    @Attachment(value = "Name", type = "image/png", fileExtension = "png")
    public byte[] attachment(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
