package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "global-user-trigger")
    private WebElement profileIconSelector;
    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginButtonSelector;
    @FindBy (id = "oneid-iframe")
    private WebElement loginAndUpdateAccountIframe;
    @FindBy (id = "InputLoginValue")
    private WebElement emailLoginIframe;
    @FindBy (id = "InputPassword")
    private WebElement passwordLoginIframe;
    @FindBy (id = "BtnSubmit")
    private WebElement loginOrDeleteAccountButtonInIframe;
    @FindBy (css = "div.view-starry-night >div:first-child")
    private WebElement loginModalIframe;
    @FindBy (id = "logo")
    private WebElement logoInIframe;
    @FindBy (css = "li.user > div.global-user:last-child")
    private WebElement userProfileOptionsContainer;
    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement logOutButton;
    @FindBy (id = "BtnCreateAccount")
    private WebElement signupButtonInIframe;
    @FindBy(css = "li.pillar.watch > a")
    private WebElement linkToWatchPage;
    @FindBy (css = ".display-user")
    private WebElement welcomeTextGeneral;
    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeText;
    @FindBy (css = "div.global-user:last-child ul.account-management > li:nth-child(5) > a")
    private WebElement espnProfileButton;
    @FindBy (id = "AccountDeleteLink")
    private WebElement deleteAccountButton;
    @FindBy(css = "#Title > span")
    private WebElement deactivatedAccountMessageSpan;
    @FindBy (id = "sideLogin-left-rail")
    private WebElement loginElementOnTheLeftOfThePage;
    @FindBy (id = "BtnSubmit")
    private WebElement loginButtonInIframe;
    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpButtonInIframe;
    @FindBy (css = "h2#Title span")
    private WebElement signUpTitleInIframe;
    @FindBy (id = "InputFirstName")
    private WebElement firstNameInputInIframe;
    @FindBy (id = "InputLastName")
    private WebElement lastNameInputInIframe;
    @FindBy (id = "InputEmail")
    private WebElement emailInputInSignUpIframe;
    @FindBy (id = "password-new")
    private WebElement passwordInputInSignUpIframe;
    @FindBy (id = "BtnSubmit")
    private WebElement signUpButtonInSignUpIframe;
    @FindBy (id = "close")
    private WebElement closeModalButtonInIframe;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickOnSignUpButtonIframe() {
        super.clickWebElement(this.signUpButtonInIframe);
    }

    public boolean signUPTitleIsDisplayed() {
        super.waitForVisibility(this.signUpTitleInIframe);
        return this.signUpTitleInIframe.isDisplayed();
    }

    public boolean firstNameInputSignUpIframeIsDisplayed() {
        super.waitForVisibility(this.firstNameInputInIframe);
        return firstNameInputInIframe.isDisplayed();
    }

    public boolean lastNameSignUpInputIsDisplayed() {
        super.waitForVisibility(this.lastNameInputInIframe);
        return lastNameInputInIframe.isDisplayed();
    }

    public boolean emailInputSignUpIframe() {
        super.waitForVisibility(this.emailInputInSignUpIframe);
        return emailInputInSignUpIframe.isDisplayed();
    }
    public boolean passwordInputSignUpIframe() {
        super.waitForVisibility(this.passwordInputInSignUpIframe);
        return passwordInputInSignUpIframe.isDisplayed();
    }
    public boolean signUpButtonToSubmitIframeIsDisplayed(){
        super.waitForVisibility(this.signUpButtonInSignUpIframe);
        return signUpButtonInSignUpIframe.isDisplayed();
    }
    public boolean closeSignUpIframeButton() {
        super.waitForVisibility(this.closeModalButtonInIframe);
        return closeModalButtonInIframe.isDisplayed();
    }

    public void typeOnFirstNameInput(String text) {
        super.waitForVisibility(this.firstNameInputInIframe);
        super.typeOnInput(this.firstNameInputInIframe, text);
    }

    public void typeOnLastNameInput(String text) {
        super.waitForVisibility(this.lastNameInputInIframe);
        super.typeOnInput(this.lastNameInputInIframe, text);
    }
    public void typeOnEmailInput(String text) {
        super.waitForVisibility(this.emailInputInSignUpIframe);
        super.typeOnInput(this.emailInputInSignUpIframe, text);
    }
    public void typeOnPasswordInput(String text) {
        super.waitForVisibility(this.passwordInputInSignUpIframe);
        super.typeOnInput(this.passwordInputInSignUpIframe, text);
    }

    public void clickOnSignUpForSignUpButtonIframe() {
        super.waitForClickable(this.signUpButtonInSignUpIframe);
        super.clickWebElement(this.signUpButtonInSignUpIframe);
    }

    public void hoverProfileIcon() {
        log.info("Hovering to the profile icon in the top right...");
        super.waitForVisibility(this.profileIconSelector);
        super.mouseHover(this.profileIconSelector);
        super.waitForVisibility(this.userProfileOptionsContainer);
    }
    public void clickOnLoginButton(){
        log.info("Clicking login button...");
        super.waitForVisibility(this.loginButtonSelector);
        super.waitForClickable(this.loginButtonSelector);
        super.clickWebElement(this.loginButtonSelector);
    }
    public void enterLoginOrUpdateAccountIframe() {
        log.info("Switching to the iFrame...");
        super.getDriver().switchTo().frame(this.loginAndUpdateAccountIframe);
    }
    public void typeEmailAndPasswordOnLoginInputs(String email, String password) {
        log.info("Waiting for visibility of email and password inputs...");
        super.waitForVisibility(this.emailLoginIframe);
        super.waitForVisibility(this.passwordLoginIframe);
        log.info("Typing email and password on the login inputs...");
        super.typeOnInput(this.emailLoginIframe, email);
        super.typeOnInput(this.passwordLoginIframe, password);
    }
    public void clickSubmitButton() {
        log.info("Clicking submit button...");
        super.waitForVisibility(this.loginOrDeleteAccountButtonInIframe);
        super.waitForClickable(this.loginOrDeleteAccountButtonInIframe);
        clickWebElement(this.loginOrDeleteAccountButtonInIframe);
        waitForTheUserToBeLogged();
    }

    public void waitForTheUserToBeLogged() {
        super.waitToSeeIfElementAppears("#sideLogin-left-rail");
        super.waitForChangeInTheAttribute(loginElementOnTheLeftOfThePage, "style", "display: none;");
    }
    public void waitForTheUserToBeLoggedOut() {
        super.waitToSeeIfElementAppears("#sideLogin-left-rail");
        super.waitForChangeInTheAttribute(loginElementOnTheLeftOfThePage, "style", "display: block;");
    }

    public boolean isLoginIframePresent() {
        super.waitForVisibility(this.loginModalIframe);
        return this.loginModalIframe.isDisplayed();
    }
    public boolean isEspnLogoDisplayedInLoginModal() {
        super.waitForVisibility(this.logoInIframe);
        return this.logoInIframe.isDisplayed();
    }
    public boolean isLoginButtonDisplayedInLoginModal() {
        super.waitForVisibility(this.loginOrDeleteAccountButtonInIframe);
        return this.loginOrDeleteAccountButtonInIframe.isDisplayed();
    }
    public boolean isSignUpButtonDisplayedInLoginModal() {
        super.waitForVisibility(this.signupButtonInIframe);
        return this.signupButtonInIframe.isDisplayed();
    }

    public void moveOutOfTheIframe() {
        log.info("Moving back from the iFrame...");
        super.getDriver().switchTo().defaultContent();
    }

    public WatchPage goToWatchPage() {
        super.clickWebElement(this.linkToWatchPage);
        return new WatchPage(super.getDriver());
    }

    public String focusedGreetingsText(){
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }
    public String generalGreetingsText(){
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }

    public void clickLogoutButton() {
        waitForClickable(this.logOutButton);
        super.clickWebElement(this.logOutButton);
        waitForTheUserToBeLoggedOut();
    }
}
