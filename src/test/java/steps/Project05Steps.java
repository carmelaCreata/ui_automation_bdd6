package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project04Page;
import pages.Project05Page;
import utils.Driver;

import java.util.Map;

public class Project05Steps {
    WebDriver driver;
    Project05Page project05Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
       project05Page = new Project05Page();
    }
    @Then("the user should see the {string} heading")
    public void theUserShouldSeeTheHeading(String heading) {
        Assert.assertEquals(heading, project05Page.header.getText());
    }

    @Then("the user should see the {string} paragraph")
    public void theUserShouldSeeTheParagraph(String expectedParagraph) {
        Assert.assertEquals(expectedParagraph, project05Page.paragraph.getText());
    }

    @Then("the user should see the {string} button is {string}")
    public void theUserShouldSeeTheButtonIs(String buttonName, String buttonState) {
        boolean expectedState = buttonState.equalsIgnoreCase("enabled");
        boolean actualState = false;

        if (buttonName.equalsIgnoreCase("previous")) {
            Assert.assertFalse(project05Page.previous.isEnabled());
        } else if (buttonName.equalsIgnoreCase("next")) {
            Assert.assertTrue(project05Page.next.isEnabled());
        } else {
            Assert.fail("Invalid button name: " + buttonName);
            return;
        }

        Assert.assertEquals(expectedState, actualState);
    }
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        project05Page.next.click();
    }

    @Then("the user should see {string} City with the info below and an image")
    public void theUserShouldSeeCityWithInfoAndImage(String cityName, DataTable dataTable) {
        Map<String, String> expectedCityInfo = dataTable.asMap(String.class, String.class);
        Map<String, String> actualCityInfo = project05Page.getCityInfo(cityName);
        Assert.assertEquals(expectedCityInfo, actualCityInfo);
    }


}
