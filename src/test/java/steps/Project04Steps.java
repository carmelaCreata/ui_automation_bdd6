package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Project04Page;
import utils.Driver;
import utils.TableHandler;

import java.util.List;

public class Project04Steps {

    WebDriver driver;
    Project04Page project04Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        project04Page = new Project04Page();
    }


    @Then("the user should see the {string} heading")
    public void the_user_should_see_the_heading(String headingText) {
        Assert.assertEquals(headingText, project04Page.mainHeading.getText());
    }
    @Then("the user should see the table with the headers below")
    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
        List<String> headerText = dataTable.asList();

        for (int i = 0; i < headerText.size(); i++) {
            Assert.assertEquals(headerText.get(i), project04Page.tableHeading.get(i).getText());
        }
    }
    @Then("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists();
        List<List<WebElement>> actualTable = TableHandler.getTableData(project04Page.table);

        for (int i = 0; i < expectedTable.size(); i++) {
            for (int j = 0; j < expectedTable.get(i).size(); j++) {
                Assert.assertEquals(expectedTable.get(i).get(j), actualTable.get(i).get(j).getText());
            }
        }

    }
    @Then("the user should see the {string} button is enabled")
    public void the_user_should_see_the_button_is_enabled(String button) {
        switch (button){
            case "ADD PRODUCT":
                Assert.assertTrue(project04Page.addProductButton.isEnabled());
                break;
            case "X":
                Assert.assertTrue(project04Page.closeButton.isEnabled());
                break;
            case "SUBMIT":
                Assert.assertTrue(project04Page.submitButton.isEnabled());
                break;
            default:
        }
    }
    @Then("the user should see the {string} text displayed")
    public void the_user_should_see_the_text_displayed(String total) {
        Assert.assertEquals(total, project04Page.totalAmount.getText());
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        switch (button){
            case "ADD PRODUCT":
                project04Page.addProductButton.click();
                break;
            case "X":
                project04Page.closeButton.click();
                break;
            case "SUBMIT":
                project04Page.submitButton.click();
                break;
            default:
        }
    }

    @Then("the user should see the {string} modal with its heading")
    public void theUserShouldSeeTheModalWithItsHeading(String headingText) {
        Assert.assertEquals(headingText, project04Page.modalCardTitle.getText());
    }

    @And("the user should see the {string} label")
    public void theUserShouldSeeTheLabel(String label) {
        switch (label){
            case "Please select the quantity":
                Assert.assertTrue(project04Page.labels.get(0).isDisplayed());
                break;
            case "Please enter the name of the product":
                Assert.assertTrue(project04Page.labels.get(1).isDisplayed());
                break;
            case "Please enter the price of the product":
                Assert.assertTrue(project04Page.labels.get(2).isDisplayed());
                break;
            default:
        }
    }

    @And("the user should see the {string} input box is enabled")
    public void theUserShouldSeeTheInputBoxIsEnabled(String inputBox) {
        switch (inputBox) {
            case "Quantity":
                Assert.assertTrue(project04Page.productDetails.get(0).isEnabled());
                break;
            case "Product":
                Assert.assertTrue(project04Page.productDetails.get(1).isEnabled());
                break;
            case "Price":
                Assert.assertTrue(project04Page.productDetails.get(2).isEnabled());
                break;
            default:
        }
    }

    @Then("the user should not see the Add New Product modal")
    public void theUserShouldNotSeeTheModal() {
        try {
            Assert.assertFalse(project04Page.modalCardTitle.isDisplayed());
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @And("the user enters the {string} as {string}")
    public void theUserEntersTheAs(String details, String input) {
        switch (details){
            case "Quantity":
                project04Page.productDetails.get(0).sendKeys(input);
                break;
            case "Product":
                project04Page.productDetails.get(1).sendKeys(input);
                break;
            case"Price":
                project04Page.productDetails.get(2).sendKeys(input);
                break;
            default:
        }

    }

    @Then("the user should see the table with the new row below")
    public void theUserShouldSeeTheTableWithTheNewRowBelow(DataTable dataTable) {
        List<String> expectedRow = dataTable.asList();

        for (int i = 0; i < expectedRow.size(); i++) {
            Assert.assertEquals(expectedRow.get(i), TableHandler.getTableRow(4).get(i).getText());
        }
    }
}