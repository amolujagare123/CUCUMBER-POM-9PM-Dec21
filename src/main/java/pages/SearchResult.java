package pages;

import org.openqa.selenium.By;

import static stepdefinition.SharedSD.getDriver;

public class SearchResult extends Base {

    By starBlocks = By.xpath("//div[@data-testid='rating-stars']");
    By allStarsOnPage = By.xpath("//div[@data-testid='rating-stars']/span");

    public void clickStarRating(String star) // 4,5, 3
    {
        By starRating = By.xpath("//div[@data-filters-group='class']//div[contains(text(),'"+star+" star')]");
        webAction(starRating).click();
    }

    public int countRealStarRatingOnSearchPage()
    {
        getDriver().navigate().refresh();

        int countStarBlocks = getDriver().findElements(starBlocks).size(); // 22 - star blocks
        System.out.println("countStarBlocks="+countStarBlocks);

        int countAllStars = getDriver().findElements(allStarsOnPage).size(); // 88 - individual stars

        System.out.println("countAllStars="+countAllStars);

        return (countAllStars / countStarBlocks); // ->  number of stars per block
    }
}
