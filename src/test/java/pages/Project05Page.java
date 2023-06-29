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
    @FindBy(css = "h1[class*='is-size-2']")
    public WebElement header;

    @FindBy(id = "sub_heading")
    public WebElement subHeader;

    @FindBy(id = "#content")
    public WebElement paragraph;

    @FindBy(id = "#previous")
    public WebElement previous;

    @FindBy(id = "#next")
    public WebElement next;

    @FindBy(css = "div.Pagination_pagBodyData__up2c0 > p")
    public Map<String, String> cityInfo;

    @FindBy(css = "p[class*='city_info']")
    public WebElement cityName;

    @FindBy(css = "p[class*='country_info']")
    public WebElement country;

    @FindBy(css = "p[class*='population_info']")
    public WebElement population;

    public Map<String, String> getCityInfo(String cityName) {
        Map<String, String> cityInfo = new HashMap<>();

        cityInfo.put("City", cityName);
        cityInfo.put("Country", country.getText());
        cityInfo.put("Population", population.getText());

        return cityInfo;
    }






}
