package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project04Page {
    public Project04Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".mb-5")
    public WebElement mainHeading;

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "modal_title")
    public WebElement modalCardTitle;

    @FindBy(css = ".input")
    public List<WebElement> productDetails;

    @FindBy(css = ".modal label")
    public List<WebElement> labels;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".delete")
    public WebElement closeButton;

    @FindBy(id = "total_amount")
    public WebElement totalAmount;

    @FindBy(css = "tr > th")
    public List<WebElement> tableHeading;

    @FindBy(id = "main_heading")
    public WebElement headingText;

    @FindBy(css = "table")
    public WebElement table;
}