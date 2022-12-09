package org.disney.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.disney.configuration.ConfigCapabilities;
import org.disney.screens.DashBoardScreen;
import org.disney.screens.TutorialScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Base class for Test classes.
 *
 * @author helberth.bolivar
 */
public abstract class BaseForMobileTests {

    protected TutorialScreen tutorialScreen;
    public static AndroidDriver<AndroidElement> driver;

    public Logger log = Logger.getLogger(BaseForMobileTests.class);

    public void setUpStartApp() {
        tutorialScreen = new TutorialScreen(getDriver());
    }

    /**
     * SetUp before to run suite of test.
     *
     * @author Arley.Bolivar
     */
    //@Before
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }

    /**
     * Close the application after completing the test.
     *
     * @author Arley.Bolivar
     */
    //@After
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * return the driver.
     *
     * @return driver
     * @author Arley.Bolivar
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     *
     * @return SignUpOrLogInScreen
     * @author Arley.Bolivar
     */
    protected DashBoardScreen loadDashBoardScreen() {
        tutorialScreen.startPermissionsProcess();
        return tutorialScreen.shareLocationPermissions();
    }

}
