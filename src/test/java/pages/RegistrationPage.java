package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final static String PAGE_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    private SelenideElement modal = $("[role=dialog]");

    private Calendar calendar = new Calendar();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(PAGE_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;

    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;

    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").setValue(email);
        return this;

    }

    public RegistrationPage typePhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;

    }


    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;

    }

    public RegistrationPage typeGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;

    }

    public RegistrationPage typeSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;

    }

    public RegistrationPage typeHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;

    }

    public RegistrationPage typePicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
        return this;

    }

    public RegistrationPage currentAddress(String adress) {
        $("#currentAddress").val(adress);
        return this;

    }

    public RegistrationPage currentState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;

    }

    public RegistrationPage currentCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;

    }

    public RegistrationPage submit() {
        $("#submit").click();
        return this;
    }

    public void checkResultsTitle() {
        modal.$("#example-modal-sizes-title-lg").shouldHave(text(RESULTS_TITLE));
    }

    public void checkResultsValue(String value) {
        modal.$(".table-responsive").shouldHave(text(value));

    }
}
