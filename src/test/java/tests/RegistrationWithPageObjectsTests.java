package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Female";
    String phone = "7777777777";
    String subject = "Arts";
    String hobby = "Sports";
    String picture = "1.jpg";
    String adress = "NN VV dom 7";
    String state = "NCR";
    String city = "Delhi";
    String day = "16";
    String month = "October";
    String year = "1997";

    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGender(gender)
                .typePhone(phone)
                .setDateOfBirth(day, month, year)
                .typeSubject(subject)
                .typeHobby(hobby)
                .typePicture(picture)
                .currentAddress(adress)
                .currentState(state)
                .currentCity(city)
                .submit();

        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue((firstName + " " + lastName));
        registrationPage.checkResultsValue((email));
        registrationPage.checkResultsValue((gender));
        registrationPage.checkResultsValue((phone));
        registrationPage.checkResultsValue((day + " " + month + "," + year));
        registrationPage.checkResultsValue((subject));
        registrationPage.checkResultsValue((hobby));
        registrationPage.checkResultsValue((picture));
        registrationPage.checkResultsValue((state + " " + city));
    }
}
