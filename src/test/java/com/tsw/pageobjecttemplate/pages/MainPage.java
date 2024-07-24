package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://loan-app.tallinn-learning.ee/small-loan/
public class MainPage {
    public SelenideElement monthlyPaymentValue = $x("//*[@data-testId='ib-small-loan-calculator-field-monthlyPayment']");
    public SelenideElement loanCalcAmountField = $x("//*[@data-testId='id-small-loan-calculator-field-amount']");
    public SelenideElement errorMessage =$x("something went wrong");

    public SelenideElement applyNowButton = $("[data-testId='id-small-loan-calculator-field-apply']");
    public SelenideElement usernameField = $("[data-testId='login-popup-username-input']");
    public SelenideElement passwordField = $("[data-testId='login-popup-password-input']");
    public SelenideElement continueButton = $("[data-testId='login-popup-continue-button']");

    public SelenideElement FullNameField = $x("//*[@data-testId='final-page-full-name']");
    public SelenideElement languageField = $x("//*[@data-testId='final-page-communication-language']");
    public SelenideElement finalPageContinueButton = $x("//*[@data-testId='Final-page-continue-button']");
    public SelenideElement okSuccessButton = $x("//*[@data-testId='final-page-success-ok-button']");

    public LoanDetailsPage performLoginAndReturnLoanDetailsPage() {
        applyNowButton.click();
        usernameField.setValue("JACK");
        passwordField.setValue("123456789");
        continueButton.click();
        return new LoanDetailsPage();
    }
}
