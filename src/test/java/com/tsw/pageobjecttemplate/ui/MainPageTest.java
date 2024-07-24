package com.tsw.pageobjecttemplate.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.tsw.pageobjecttemplate.pages.LoanDetailsPage;
import com.tsw.pageobjecttemplate.pages.MainPage;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://loan-app.tallinn-learning.ee/small-loan");
    }

    @Test
    public void checkDefaultMonthlyPayment() {
        mainPage.monthlyPaymentValue.shouldBe(visible);
    }

    @Test
    public void fillIncorrectLoanAmountAndCheckErrorMessage() {
        mainPage.loanCalcAmountField.setValue("50");
        mainPage.errorMessage.shouldBe(visible);
    }
    @Test
    public void checkLoginDetailsWithDefaultParams() {
        mainPage.applyNowButton.click();
        mainPage.usernameField.shouldBe(visible);
        mainPage.passwordField.shouldBe(visible);
        mainPage.continueButton.shouldBe(disabled);
    }


//21
    @Test
    public void whenUserLoggedInThenCheckLoanDetailsPageIsVisible2() {
        LoanDetailsPage loanDetailsPage= mainPage.performLoginAndReturnLoanDetailsPage();
        loanDetailsPage.fullNameField.shouldBe(visible);
        loanDetailsPage.languageField.shouldBe(visible);
        loanDetailsPage.finalPageContinueButton.shouldBe(visible);
    }
    @Test
    public void whenUserAddedOnlyUsernameWithoutPasswordErrorMessageCheck() {
        mainPage.applyNowButton.click();
        mainPage.usernameField.setValue("Jack");
        mainPage.passwordField.setValue("");
        mainPage.continueButton.shouldBe(disabled);
        Selenide.sleep(5000);
    }
    @Test
    public void successfulLoanApplicationCheck() {
        LoanDetailsPage loanDetailsPage = mainPage.performLoginAndReturnLoanDetailsPage();
        loanDetailsPage.finalPageContinueButton.click();
        loanDetailsPage.okSuccessButton.click();
    }
}