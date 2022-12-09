package org.disney.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.disney.configuration.MobileOperations;


import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;


public class MapScreen extends MobileOperations {

    /**
     * Constructor method.
     * @author Hans.Marquez
     * @param driver the driver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*bottomSheetContainer.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"bottomSheetContainer\")")
    private AndroidElement mapContainer;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/categorySelectHeader\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categorySelectHeader.*\")")
    private AndroidElement selectCategoryHeader;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*facilityTypeTitle\").textContains(\"Hotels\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").descriptionContains(\"Hotels\")")
    private AndroidElement hotelsSelector;

    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean isCategoryDisplayed() {
        return isElementAvailable(categoryList);
    }
    /**
     * @author Hans.Marquez
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean isFilterDisplayed() {
        return isElementAvailable(filterButton);
    }
    /**
     * @author Hans.Marquez
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean isShowListDisplayed() {
        return isElementAvailable(showListButton);
    }
    /**
     * @author Zeus.Vargas
     * return true if Map Container element is displayed in screen, otherwise false.
     */
    public boolean isMapContainerDisplayed() {
        return isElementAvailable(mapContainer);
    }
    /**
     * @author Zeus.Vargas
     * Clicks the Attractions header in Map screen if it is displayed in screen.
     */
    public void clickAttractionsCategoryList() {
        click(categoryList);
    }
    /**
     * @author Zeus.Vargas
     * return true if Select Category header is displayed in screen, otherwise false.
     */
    public boolean isSelectCategoryDisplayed() { return isElementAvailable(selectCategoryHeader);}
    /**
     * @author Zeus.Vargas
     * return true if Select Category header is displayed in screen, otherwise false.
     */
    public boolean isHotelsDisplayed() {
        return isElementAvailable(hotelsSelector);
    }
}
