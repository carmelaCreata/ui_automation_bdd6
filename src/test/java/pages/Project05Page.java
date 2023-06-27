package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project05Page {

    public Project05Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "h1[style*='Blue']")
    public WebElement header;

    @FindBy(id = "#sub_heading")
    public WebElement subHeader;

    @FindBy(id = "#content")
    public WebElement paragraph;

    @FindBy(id = "#previous")
    public WebElement prevButton;

    @FindBy(id = "#next")
    public WebElement nextButton;

    @FindBy(css = "div.Pagination_pagBodyData__up2c0 > p")
    public List<WebElement> cityInfo;

    public Map<String, String> getCityInfoMap() {
        Map<String, String> cityInfoMap = new HashMap<>();

        for (WebElement element : cityInfo) {
            String attribute = element.getAttribute("class");
            String value = element.getText();
            cityInfoMap.put(attribute, value);
        }

        return cityInfoMap;
    }
}
