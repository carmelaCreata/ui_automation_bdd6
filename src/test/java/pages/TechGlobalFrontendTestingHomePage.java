package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalFrontendTestingHomePage {

    public TechGlobalFrontendTestingHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[id*='card']")
    public List<WebElement> cards;

    public void clickOnCard(String cardText){
        for(WebElement card: cards){
            if(card.getText().equals(cardText)){
                card.click();
                break;
            }
        }
    }

}
