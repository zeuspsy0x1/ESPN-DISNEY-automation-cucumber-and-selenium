package org.disney.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.disney.configuration.MobileOperations;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;


public class DashBoardScreen extends MobileOperations {

    /**
     * Constructor method.
     * @author Hans.Marquez
     * @param driver : AndroidDriver
     */

    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.ImageView).descriptionContains(\"More\")")
    private AndroidElement menuButton;

    /**
     * @author Zeus.Vargas.
     * Clicks dismiss buttons at dashboard screen if they are visible.
     */
    public void closeDismissButtonsAtDashboardScreen(){
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }
    /**
     * @author Hans.Marquez, refactored by zeus.vargas
     * Closes pop ups and navigates from DashBoard Screen to Map screen.
     */
    public MapScreen goToMapScreen() {
        closeDismissButtonsAtDashboardScreen();
        click(mapButton);
        return new MapScreen(driver);
    }
    /**
     * @author Zeus.Vargas
     * Closes pop-ups and navigates from DashBoard Screen to Menu screen.
     */
    public MenuScreen clickOnMenuOption() {
        closeDismissButtonsAtDashboardScreen();
        if (this.isElementAvailable(menuButton, 25)){
            click(menuButton);
        }
        return new MenuScreen(driver);
    }
    /**
     * @author Zeus.Vargas
     * Closes pop-ups and navigates from DashBoard Screen to Add Plan Option screen.
     */
    public AddPlanScreen clickOnAddPlanOption() {
        closeDismissButtonsAtDashboardScreen();
        if (this.isElementAvailable(menuButton, 25)){
            click(menuButton);
        }
        return new AddPlanScreen(driver);
    }
}


