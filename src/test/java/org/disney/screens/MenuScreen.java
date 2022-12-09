package org.disney.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.disney.configuration.MobileOperations;


public class MenuScreen extends MobileOperations {
    /**
     * Constructor.
     * @author Zeus.Vargas
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/avatarImage\")")
    private AndroidElement avatarImageInMenuCategories;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"My Profile\")")
    private AndroidElement myProfileCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"Property Rules\")")
    private AndroidElement propertyRulesCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"Cast Compliment\")")
    private AndroidElement castComplimentCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"Link to Account\")")
    private AndroidElement linkToAccountCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"Car Locator\")")
    private AndroidElement carLocatorCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"Help\")")
    private AndroidElement helpCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textMatches(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textMatches(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalHeaderText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Privacy Policy\")")
    private AndroidElement privacyPolicyOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Terms of Use\")")
    private AndroidElement termsOfUseOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Supplemental Terms and Conditions\")")
    private AndroidElement supplementalTermsAndConditionsOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Legal Notices\")")
    private AndroidElement legalNoticesOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Property Rules\")")
    private AndroidElement propertyRulesOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Electronic Communications Disclosure\")")
    private AndroidElement electronicCommunicationDisclosureOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Your California Privacy Rights\")")
    private AndroidElement yourCaliforniaPrivacyRightsOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"Do Not Sell My Personal Information\")")
    private AndroidElement doNotSellMyPersonalInformationOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"In-App Maps Subject to Google Terms and Conditions\")")
    private AndroidElement inAppMapsSubjectToGoogleTermsAndConditionsOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textMatches(\"In-App Maps Subject to Google Privacy Policy\")")
    private AndroidElement inAppMapsSubjectToGooglePrivacyPolicyOption;

    /**
     * @author Zeus.Vargas
     * return true if Profile Category element is displayed in screen, otherwise false.
     */
    public boolean isProfileCategoryDisplayed() { return isElementAvailable(myProfileCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Property Rules element is displayed in screen, otherwise false.
     */
    public boolean isPropertyRulesDisplayed() { return isElementAvailable(propertyRulesCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Cast Compliment element is displayed in screen, otherwise false.
     */
    public boolean isCastComplimentDisplayed() { return isElementAvailable(castComplimentCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Link To Account element is displayed in screen, otherwise false.
     */
    public boolean isLinkToAccountDisplayed() { return isElementAvailable(linkToAccountCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Car Locator element is displayed in screen, otherwise false.
     */
    public boolean isCarLocatorDisplayed() { return isElementAvailable(carLocatorCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Help element is displayed in screen, otherwise false.
     */
    public boolean isHelpDisplayed() { return isElementAvailable(helpCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Privacy And Legal element is displayed in screen, otherwise false.
     */
    public boolean isPrivacyAndLegalDisplayed() { return isElementAvailable(privacyAndLegalCategory);}
    /**
     * @author Zeus.Vargas
     * return true if Privacy And Legal Header element is displayed in screen, otherwise false.
     */
    public boolean isPrivacyAndLegalHeaderDisplayed() { return isElementAvailable(privacyAndLegalHeaderText);}
    /**
     * @author Zeus.Vargas
     * return true if Privacy And Legal Header element is displayed in screen, otherwise false.
     */
    public boolean isPrivacyPolicyDisplayed() { return isElementAvailable(privacyPolicyOption);}
    /**
     * @author Zeus.Vargas
     * return true if Terms Of Use is displayed in screen, otherwise false.
     */
    public boolean isTermsOfUseDisplayed() { return isElementAvailable(termsOfUseOption);}
    /**
     * @author Zeus.Vargas
     * return true if Supplemental Terms And Conditions element is displayed in screen, otherwise false.
     */
    public boolean isSupplementalTermsAndConditionsDisplayed() { return isElementAvailable(supplementalTermsAndConditionsOption);}
    /**
     * @author Zeus.Vargas
     * return true if Legal Notices element is displayed in screen, otherwise false.
     */
    public boolean isLegalNoticesDisplayed() { return isElementAvailable(legalNoticesOption);}
    /**
     * @author Zeus.Vargas
     * return true if Property Rules Option element is displayed in screen, otherwise false.
     */
    public boolean isPropertyRulesOptionDisplayed() { return isElementAvailable(propertyRulesOption);}
    /**
     * @author Zeus.Vargas
     * return true if Electronic Communication Disclosure element is displayed in screen, otherwise false.
     */
    public boolean isElectronicCommunicationDisclosureDisplayed() { return isElementAvailable(electronicCommunicationDisclosureOption);}
    /**
     * @author Zeus.Vargas
     * return true if Your California Privacy Rights element is displayed in screen, otherwise false.
     */
    public boolean isYourCaliforniaPrivacyRightsDisplayed() { return isElementAvailable(yourCaliforniaPrivacyRightsOption);}
    /**
     * @author Zeus.Vargas
     * return true if Do Not Sell My Personal Information element is displayed in screen, otherwise false.
     */
    public boolean isDoNotSellMyPersonalInformationDisplayed() { return isElementAvailable(doNotSellMyPersonalInformationOption);}
    /**
     * @author Zeus.Vargas
     * return true if In App Maps Subject To Google Terms And Conditions element is displayed in screen, otherwise false.
     */
    public boolean isInAppMapsSubjectToGoogleTermsAndConditionsDisplayed() { return isElementAvailable(inAppMapsSubjectToGoogleTermsAndConditionsOption);}
    /**
     * @author Zeus.Vargas
     * return true if In App Maps Subject To Google Privacy Policy Header element is displayed in screen, otherwise false.
     */
    public boolean isInAppMapsSubjectToGooglePrivacyPolicyDisplayed() { return isElementAvailable(inAppMapsSubjectToGooglePrivacyPolicyOption);}

    /**
     * @author Zeus.Vargas
     * return true if Categories Banner element is displayed in screen, otherwise false.
     */
    public boolean isCategoriesBannerDisplayed(){
        return isElementAvailable(avatarImageInMenuCategories);
    }
    /**
     * @author Zeus.Vargas
     * Scrolls down until privacy and legal category is displayed.
     */
    public void scrollToTheBottomOfTheScreen(){
        log.info("Scrolling to privacy and legal category");
        while(!isPrivacyAndLegalDisplayed()){
            scrollDown();
        }
    }
    /**
     * @author Zeus.Vargas
     * Click privacy and legal category if it is displayed.
     */
    public void clickPrivacyAndLegalButton(){
        log.info("Clicking privacy and legal category");
        click(privacyAndLegalCategory);
    }
}
