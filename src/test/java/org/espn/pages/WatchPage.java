package org.espn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the selectors and methods for the watch-page
 */
public class WatchPage extends BasePage {

    @FindBy(css = ".BucketsContainer > div")
    private List<WebElement> carouselContainer;

    @FindBy (css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy(css = ".BucketsContainer > div:nth-child(1) > section > div:nth-child(2) > div > div > ul")
    private List<WebElement> carouselListOfcards;

    @FindBy(css = ".BucketsContainer > div:nth-child(1) > section > div:nth-child(2) > div > div > ul > li:nth-child(2)")
    private WebElement secondCarouselSecondCard;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement exitXButtonInModal;

    /**
     * Constructor method
     * @param driver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if at least one carousel is being displayed, counts every instance and
     * @return true if there is at least one
     */
    public boolean isAtLeastOneCarouselDisplayed() {
        super.waitForVisibility(carouselContainer);
        return carouselContainer.size() > 0;
    }

    /**
     * Gets all the cards in the carousel number 2, because the number 1 its harder to manage
     * @return the cards that it can get
     */
    public List<WebElement> getCardsInTheCarouselTwo() {
        final By CARD = By.cssSelector("ul.Carousel__Inner li");
        return carousels.get(1).findElements(CARD);
    }

    /**
     * Checks if each card has a title
     * @return true if every card has it
     */
    public boolean checkTitleInAllCardsInTheCarouselTwo() {
        List<Boolean> cardsHaveTitle = new ArrayList<>();
        this.waitToSeeIfElementAppears("ul.Carousel__Inner li");
        getCardsInTheCarouselTwo().stream().forEach(element -> {
            final By watchTitle = By.cssSelector("h2.WatchTile__Title");
            cardsHaveTitle.add(!element.findElement(watchTitle).getText().equals(""));
        });
        return cardsHaveTitle.contains(false);
    }
    /**
     * Checks if each card has a description
     * @return true if every card has it
     */
    public boolean checkDescriptionInAllCardsInTheCarouselTwo() {
        List<Boolean> cardsHaveTitle = new ArrayList<>();
        this.waitToSeeIfElementAppears("ul.Carousel__Inner li");
        getCardsInTheCarouselTwo().stream().forEach(element -> {
            cardsHaveTitle.add(!element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return cardsHaveTitle.contains(false);
    }

    /**
     * Clicks on the card number 2 in the carousel number 2 (because using the carousel 1 is harder)
     */
    public void clickOnCardNumberTwoInCarouselTwo() {
        super.waitForVisibility(secondCarouselSecondCard);
        super.clickWebElement(secondCarouselSecondCard);
    }

    /**
     * Checks if the close button in the modal is displayed
     * @return true if it is
     */
    public boolean isSecondCardXButtonDisplayed() {
        super.waitForVisibility(secondCarouselSecondCard);
        super.waitForVisibility(exitXButtonInModal);
        return exitXButtonInModal.isDisplayed();
    }

    /**
     * Clicks the close button to close the detail card modal
     */
    public void clickXButtonToCloseModal(){
        super.waitForVisibility(exitXButtonInModal);
        super.waitForClickable(exitXButtonInModal);
        super.clickWebElement(exitXButtonInModal);
    }

}