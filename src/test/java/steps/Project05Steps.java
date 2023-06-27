package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project05Page;
import utils.Driver;

public class Project05Steps {
    WebDriver driver;
    Project05Page project05Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        project05Page = new Project05Page();
    }


}
