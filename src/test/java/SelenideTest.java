import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenideTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void firstTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String name = "NameTest";
        String lastName = "SurnameTest";
        String email = "test@mail.ru";
        String phone = "9988898898";
        String mounth = "May";
        String year = "2000";
        String address = "AddressTest";
        String gender = "Male";
        String subjects = "testSubjects";
//        String imgPath = "dog.jpeg";

        open("automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
//        $("#uploadPicture").uploadFromClasspath(imgPath);


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(mounth);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--001").click();
        $("#currentAddress").setValue(address);
        $("#subjectsInput").setValue(subjects).pressEnter();

        $(".table-dark").shouldHave(
                text(name + " " + lastName),
                text(email),
                text(phone),
                text(address),
                text(gender)
//                text(imgPath)
        );
    }

}
