package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreAddressFormPage {

    @FindBy(name = "alias")
    private WebElement alias;
    @FindBy(name = "address1")
    private WebElement address;
    @FindBy(name = "postcode")
    private WebElement postcode;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(name = "id_country")
    private WebElement country;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(xpath = "//section[@id='content']/div/div/form/footer/button")
    private WebElement submitButton;


    public MyStoreAddressFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void fillPersonalInformation(MyStoreAddressFormData formData) {

        setInput(alias, formData.getAlias());
        setInput(address, formData.getAddress());
        setInput(postcode, formData.getPostcode());
        setInput(city, formData.getCity());
        setCountryToUK();
        setInput(phone, formData.getPhone());
    }


    private void setInput(WebElement input, String value) {
        input.click();
        input.clear();
        input.sendKeys(value);
    }

    public void setCountryToUK() {
        country.click();
        country.sendKeys("U");
        country.click();
    }


    public void clickSave() {
        submitButton.submit();
    }
}
