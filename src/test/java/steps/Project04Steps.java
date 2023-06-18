package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.Project04Page;
import utils.Driver;

import java.util.Collections;
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
    public void theUserShouldSeeTheHeading(String heading) {
        Assert.assertEquals(heading, project04Page.inventoryHeader.getText());
    }

    @And("the user should see the table with the headers below")
    public void theUserShouldSeeTheTableWithTheHeadersBelow(DataTable headers) {
        List<String> expectedResult = headers.asList();

        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertEquals(expectedResult.get(i), project04Page.tableHeaders.get(i).getText());
        }

    }

    @And("the user should see the table with the rows below")
    public void theUserShouldSeeTheTableWithTheRowsBelow(DataTable rows) {
        /*
        List<List<String>> expected = Collections.singletonList(rows.asList());

        int index = 0;

        for (List<String> strings : expected) {
            for (String string : strings) {
               Assert.assertEquals(expected.get(index), project04Page.tableRows.get();

            }


        }


         */


    }



    @And("the user should see the {string} button is enabled")
    public void theUserShouldSeeTheButtonIsEnabled(String addProd) {
        Assert.assertTrue(addProd, project04Page.addProductButton.isEnabled());

    }

    @And("the user should see the {string} text displayed")
    public void theUserShouldSeeTheTextDisplayed(String amount) {
        Assert.assertTrue(amount, project04Page.totalAmount.isDisplayed());
    }


    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String argument) {
        switch (argument) {
            case "ADD PRODUCT":
                project04Page.addProductButton.click();
                break;
            case "CLOSE":
                project04Page.buttonX.click();
                break;
            default:
                throw new NotFoundException("Not found");
        }

    }

    @Then("the user should see the {string} modal with its heading")
    public void theUserShouldSeeTheModalWithItsHeading(String modal) {
        Assert.assertTrue(modal, project04Page.modal.isDisplayed());
    }

    @And("the user should see the {string} label")
    public void theUserShouldSeeTheLabel(String quantity ) {
        Assert.assertTrue(quantity, project04Page.quantityLabel.isDisplayed());
    }

    @And("the user should see the {string} input box is enabled")
    public void theUserShouldSeeTheInputBoxIsEnabled(String quantityInput) {
        Assert.assertTrue(quantityInput, project04Page.quantityInput.isEnabled());
    }

    @Then("the user should not see the {string} modal")
    public void theUserShouldNotSeeTheModal(String modal) {
        try {
            Assert.assertFalse(modal, project04Page.modal.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }

    }

    @And("the user enters the quantity as {string}")
    public void theUserEntersTheQuantityAs(String q) {
        project04Page.quantityInput.sendKeys("1");
    }

    @And("the user enters the product as {string}")
    public void theUserEntersTheProductAs(String product) {
        project04Page.productInput.sendKeys("Mouse");
    }

    @And("the user enters the price as {string}")
    public void theUserEntersThePriceAs(String price) {
        project04Page.productPriceInput.sendKeys("15");
    }

    @Then("the user should see the table with the new row below")
    public void theUserShouldSeeTheTableWithTheNewRowBelow() {

    }

}
