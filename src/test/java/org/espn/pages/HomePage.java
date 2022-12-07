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
    private WebElement loginOrDeleteAccountbuttonInIframe;
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


    public HomePage(WebDriver driver) {
        super(driver);
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
    public void clickSubmitButton() throws InterruptedException {
        log.info("Clicking submit button...");
        super.waitForVisibility(this.loginOrDeleteAccountbuttonInIframe);
        super.waitForClickable(this.loginOrDeleteAccountbuttonInIframe);
        clickWebElement(this.loginOrDeleteAccountbuttonInIframe);
        Thread.sleep(3000);
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
        super.waitForVisibility(this.loginOrDeleteAccountbuttonInIframe);
        return this.loginOrDeleteAccountbuttonInIframe.isDisplayed();
    }
    public boolean isSignUpButtonDisplayedInLoginModal() {
        super.waitForVisibility(this.signupButtonInIframe);
        return this.signupButtonInIframe.isDisplayed();
    }


    public void moveOutOfTheIframe() {
        log.info("Moving back from the iFrame...");
        super.getDriver().switchTo().defaultContent();
    }

    public WatchPage navigateFromHomePageToWatchPage(){
        log.info("Navigating to " + "WatchPage");
        WebDriver driver = super.getDriver();
        driver.get("https://www.espn.com.co/watch/?redirected=true");
        return new WatchPage(super.getDriver());
    }
    public WatchPage clickWatch(){
        log.info("Navigating to " + "WatchPage");
        WebDriver driver = super.getDriver();
        driver.get("http://www.espn.com/watch/");
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

    // logout

    public void clickLogoutButton() throws InterruptedException {
        waitForClickable(this.logOutButton);
        super.clickWebElement(this.logOutButton);
        Thread.sleep(3000);
    }

    //deactivate account

    public void clickOnEspnProfileButton() {
        waitForVisibility(this.espnProfileButton);
        waitForClickable(this.espnProfileButton);
            clickWebElement(espnProfileButton);
    }


    public void clickOnDeleteAccount() {
        waitForVisibility(this.deleteAccountButton);
        waitForClickable(this.deleteAccountButton);
        clickWebElement(deleteAccountButton);
    }

    public String getDeactivatedAccountTextMessage() {
        waitForVisibility(deactivatedAccountMessageSpan);
        if (deactivatedAccountMessageSpan.isDisplayed()) {
            return deactivatedAccountMessageSpan.getText();
        }
        return "";
    }

}
