package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoanDetailsPage {

    public SelenideElement fullNameField = $x("//*[@data-testId='final-page-full-name']");

    //Homework 21

    public SelenideElement languageField = $x("//*[@data-testId='final-page-communication-language']");
    public SelenideElement finalPageContinueButton = $x("//*[@data-testId='final-page-continue-button']");
    public SelenideElement okSuccessButton = $x("//*[@data-testId='final-page-success-ok-button']");

}