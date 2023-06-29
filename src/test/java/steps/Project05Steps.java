package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project05Page;
import utils.Driver;

import java.util.List;

public class Project05Steps {

    WebDriver driver;
    Project05Page project05Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        project05Page = new Project05Page();
    }
    @And("the user should see the {string} paragraph")
    public void theUserShouldSeeTheParagraph(String paragraph) {
        Assert.assertEquals(paragraph, project05Page.content.getText());
    }

    @Then("the user should see the {string} button is disabled")
    public void theUserShouldSeeTheButtonIsDisabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertFalse(project05Page.previous.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(project05Page.next.isEnabled());
                break;
            default:
        }
    }

    @When("the user clicks on the {string} button till it becomes disabled")
    public void theUserClicksOnTheButtonTillItBecomesDisabled(String button) {
        project05Page.clickNextButton();
    }

    @Then("the user should see {string} City with the info below and an image")
    public void the_user_should_see_city_with_the_info_below_and_an_image(String string, DataTable dataTable) {
        List<String> expectedText = dataTable.asList();

        for (int i = 0; i < expectedText.size(); i++) {
            Assert.assertTrue(project05Page.cityImage.isDisplayed());
            Assert.assertEquals(expectedText.get(i), project05Page.cityInfo.get(i).getText());
        }
    }
}