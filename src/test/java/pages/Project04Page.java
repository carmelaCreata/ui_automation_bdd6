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

    @FindBy(id = "card-24" )
    public WebElement card;

    @FindBy(css = "h1[class='is-size-2']")
    public WebElement inventoryHeader;

    @FindBy(xpath = "//tr[contains(@class, 'DynamicTables_tableHeaders')]")
    public List<WebElement> tableHeaders;

    @FindBy(css = "tbody tr>td")
    public List<List<WebElement>> tableRows;

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "total_amount")
    public WebElement totalAmount;

    @FindBy(xpath = "//div[contains(@class, 'modal-card DynamicTables_modal')] ")
    public WebElement modal;

    @FindBy(css = "button[class='delete']")
    public WebElement buttonX;

    @FindBy(css = "label[for=\"product_quantity\"]")
    public WebElement quantityLabel;

    @FindBy(css = "input[id='quantity']")
    public WebElement quantityInput;

    @FindBy(css = "label[for=\"product_quantity\"]")
    public WebElement productLabel;

    @FindBy(css = "input[id='product']")
    public WebElement productInput;

    @FindBy(css = "label[for=\"product_price\"]")
    public WebElement productPrice;

    @FindBy(css = "input[id='price']")
    public WebElement productPriceInput;

    @FindBy(css = "button[id='submit']")
    public WebElement submitButton;
}
