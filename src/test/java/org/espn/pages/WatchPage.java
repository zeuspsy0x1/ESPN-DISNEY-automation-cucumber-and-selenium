package org.espn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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


    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAtLeastOneCarouselDisplayed() {
        super.waitForVisibility(carouselContainer);
        return carouselContainer.size() > 0;
    }

    public List<WebElement> getCardsInTheCarouselTwo() {
        return carousels.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }

    public boolean checkTitleInAllCardsInTheCarouselTwo() {
        List<Boolean> cardsHaveTitle = new ArrayList<>();
        this.waitToSeeIfElementAppears("ul.Carousel__Inner li");
        getCardsInTheCarouselTwo().stream().forEach(element -> {
            cardsHaveTitle.add(!element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return cardsHaveTitle.contains(false);
    }

    public boolean checkDescriptionInAllCardsInTheCarouselTwo() {
        List<Boolean> cardsHaveTitle = new ArrayList<>();
        this.waitToSeeIfElementAppears("ul.Carousel__Inner li");
        getCardsInTheCarouselTwo().stream().forEach(element -> {
            cardsHaveTitle.add(!element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return cardsHaveTitle.contains(false);
    }

    public void clickOnCardNumberTwoInCarouselTwo() {
        super.waitForVisibility(secondCarouselSecondCard);
        super.clickWebElement(secondCarouselSecondCard);
    }
    public boolean isSecondCardXButtonDisplayed() {
        super.waitForVisibility(secondCarouselSecondCard);
        super.waitForVisibility(exitXButtonInModal);
        return exitXButtonInModal.isDisplayed();
    }
    public void clickXButtonToCloseModal(){
        super.waitForVisibility(exitXButtonInModal);
        super.waitForClickable(exitXButtonInModal);
        super.clickWebElement(exitXButtonInModal);
    }

}