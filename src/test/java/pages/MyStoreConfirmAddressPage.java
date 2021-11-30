package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreConfirmAddressPage {


//        @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address/text()[1]")
//        private WebElement alias;
//    @FindBy(name = "address1")
//    private WebElement address;
//    @FindBy(name = "postcode")
//    private WebElement postcode;
//    @FindBy(name = "city")
//    private WebElement city;
//    @FindBy(name = "id_country")
//    private WebElement country;
//    @FindBy(name = "phone")
//    private WebElement phone;
//    @FindBy(xpath = "//section[@id='content']/div/div/form/footer/button")
//    private WebElement submitButton;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement alert;

    @FindBy(className = "address-body")
    private WebElement addressInfo;


    public MyStoreConfirmAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

//    public WebElement getAlias() {
//        return alias;
//    }

    public boolean confirmAddressDeleted() {
        return alert.getText().equals("Address successfully deleted!");
    }

    public boolean confirmData(String compare, String compared) {
        return compare.equals(compared);
    }

    public String[] getAddressInfo() {
        String userInfo = addressInfo.getText();
        String addressTable[] = userInfo.split("\n");
        return addressTable;
    }
}



