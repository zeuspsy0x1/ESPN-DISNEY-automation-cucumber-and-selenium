package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines the selectors and methods for the homepage
 */
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

    /**
     * Constructor method
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks on the sign-up button inside the login iFrame
     */
    public void clickOnSignUpButtonIframe() {
        super.clickWebElement(this.signUpButtonInIframe);
    }

    /**
     * Checks if the sign up title is displayed.
     * @return true if its displayed
     */
    public boolean signUpTitleIsDisplayed() {
        super.waitForVisibility(this.signUpTitleInIframe);
        return this.signUpTitleInIframe.isDisplayed();
    }

    /**
     * Checks if the firstname input is displayed
     * @return true if its displayed
     */
    public boolean firstNameInputSignUpIframeIsDisplayed() {
        super.waitForVisibility(this.firstNameInputInIframe);
        return firstNameInputInIframe.isDisplayed();
    }
    /**
     * Checks if the lastname input is displayed
     * @return true if its displayed
     */
    public boolean lastNameSignUpInputIsDisplayed() {
        super.waitForVisibility(this.lastNameInputInIframe);
        return lastNameInputInIframe.isDisplayed();
    }
    /**
     * Checks if the email input is displayed
     * @return true if its displayed
     */
    public boolean emailInputSignUpIframe() {
        super.waitForVisibility(this.emailInputInSignUpIframe);
        return emailInputInSignUpIframe.isDisplayed();
    }
    /**
     * Checks if the password is displayed
     * @return true if its displayed
     */
    public boolean passwordInputSignUpIframe() {
        super.waitForVisibility(this.passwordInputInSignUpIframe);
        return passwordInputInSignUpIframe.isDisplayed();
    }
    /**
     * Checks if the sign-up button is displayed
     * @return true if its displayed
     */
    public boolean signUpButtonToSubmitIframeIsDisplayed(){
        super.waitForVisibility(this.signUpButtonInSignUpIframe);
        return signUpButtonInSignUpIframe.isDisplayed();
    }
    /**
     * Checks if the close button is displayed
     * @return true if its displayed
     */
    public boolean closeSignUpIframeButton() {
        super.waitForVisibility(this.closeModalButtonInIframe);
        return closeModalButtonInIframe.isDisplayed();
    }

    /**
     * Types the
     * @param text that it receives into the firstname input
     */
    public void typeOnFirstNameInput(String text) {
        super.waitForVisibility(this.firstNameInputInIframe);
        super.typeOnInput(this.firstNameInputInIframe, text);
    }

    /**
     * Types the
     * @param text that it receives into the lastname input
     */
    public void typeOnLastNameInput(String text) {
        super.waitForVisibility(this.lastNameInputInIframe);
        super.typeOnInput(this.lastNameInputInIframe, text);
    }
    /**
     * Types the
     * @param text that it receives into the email input
     */
    public void typeOnEmailInput(String text) {
        super.waitForVisibility(this.emailInputInSignUpIframe);
        super.typeOnInput(this.emailInputInSignUpIframe, text);
    }
    /**
     * Types the
     * @param text that it receives into the password input
     */
    public void typeOnPasswordInput(String text) {
        super.waitForVisibility(this.passwordInputInSignUpIframe);
        super.typeOnInput(this.passwordInputInSignUpIframe, text);
    }

    /**
     * Clicks on sign-up button inside the iFrame
     */
    public void clickOnSignUpForSignUpButtonIframe() {
        super.waitForClickable(this.signUpButtonInSignUpIframe);
        super.clickWebElement(this.signUpButtonInSignUpIframe);
    }

    /**
     * Performs hover to the profile icon in the top right of the webpage
     */
    public void hoverProfileIcon() {
        log.info("Hovering to the profile icon in the top right...");
        super.waitForVisibility(this.profileIconSelector);
        super.mouseHover(this.profileIconSelector);
        super.waitForVisibility(this.userProfileOptionsContainer);
    }

    /**
     * Clicks on the login button inside the modal of the profile
     */
    public void clickOnLoginButton(){
        log.info("Clicking login button...");
        super.waitForVisibility(this.loginButtonSelector);
        super.waitForClickable(this.loginButtonSelector);
        super.clickWebElement(this.loginButtonSelector);
    }

    /**
     * Switches into the login iFrame
     */
    public void enterLoginOrUpdateAccountIframe() {
        log.info("Switching to the iFrame...");
        super.getDriver().switchTo().frame(this.loginAndUpdateAccountIframe);
    }

    /**
     * Types
     * @param email and
     * @param password into the login inputs inside the login iFrame
     */
    public void typeEmailAndPasswordOnLoginInputs(String email, String password) {
        log.info("Waiting for visibility of email and password inputs...");
        super.waitForVisibility(this.emailLoginIframe);
        super.waitForVisibility(this.passwordLoginIframe);
        log.info("Typing email and password on the login inputs...");
        super.typeOnInput(this.emailLoginIframe, email);
        super.typeOnInput(this.passwordLoginIframe, password);
    }

    /**
     * Clicks on submit button in the login iFrame
     */
    public void clickSubmitButton() {
        log.info("Clicking submit button...");
        super.waitForVisibility(this.loginOrDeleteAccountButtonInIframe);
        super.waitForClickable(this.loginOrDeleteAccountButtonInIframe);
        clickWebElement(this.loginOrDeleteAccountButtonInIframe);
        waitForTheUserToBeLogged();
    }

    /**
     * Waits until the user is logged in
     */
    public void waitForTheUserToBeLogged() {
        super.waitToSeeIfElementAppears("#sideLogin-left-rail");
        super.waitForChangeInTheAttribute(loginElementOnTheLeftOfThePage, "style", "display: none;");
    }

    /**
     * Waits until the logged-in user is logged out
     */
    public void waitForTheUserToBeLoggedOut() {
        super.waitToSeeIfElementAppears("#sideLogin-left-rail");
        super.waitForChangeInTheAttribute(loginElementOnTheLeftOfThePage, "style", "display: block;");
    }

    /**
     * Checks if the login iFrame is being displayed
     * @return true if it is
     */
    public boolean isLoginIframePresent() {
        super.waitForVisibility(this.loginModalIframe);
        return this.loginModalIframe.isDisplayed();
    }
    /**
     * Checks if the ESPN logo inside the login iFrame is being displayed
     * @return true if it is
     */
    public boolean isEspnLogoDisplayedInLoginModal() {
        super.waitForVisibility(this.logoInIframe);
        return this.logoInIframe.isDisplayed();
    }
    /**
     * Checks if the login button inside the login iFrame is being displayed
     * @return true if it is
     */
    public boolean isLoginButtonDisplayedInLoginModal() {
        super.waitForVisibility(this.loginOrDeleteAccountButtonInIframe);
        return this.loginOrDeleteAccountButtonInIframe.isDisplayed();
    }
    /**
     * Checks if the sign-up button inside the login iFrame is being displayed
     * @return true if it is
     */
    public boolean isSignUpButtonDisplayedInLoginModal() {
        super.waitForVisibility(this.signupButtonInIframe);
        return this.signupButtonInIframe.isDisplayed();
    }

    /**
     * Switches context from the iFrame to where it was before
     */
    public void moveOutOfTheIframe() {
        log.info("Moving back from the iFrame...");
        super.getDriver().switchTo().defaultContent();
    }
    /**
     * Clicks the link to go to the watch-page
     * @return a watch-page instance
     */
    public WatchPage goToWatchPage() {
        super.clickWebElement(this.linkToWatchPage);
        return new WatchPage(super.getDriver());
    }
    /**
     * Waits until the welcome text is being displayed
     * @return welcome text
     */
    public String focusedGreetingsText(){
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }
    /**
     * Waits until the general welcome text is being displayed
     * @return general welcome text
     */
    public String generalGreetingsText(){
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }
    /**
     * Clicks the logout button
     */
    public void clickLogoutButton() {
        waitForClickable(this.logOutButton);
        super.clickWebElement(this.logOutButton);
        waitForTheUserToBeLoggedOut();
    }
}
