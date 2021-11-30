package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreYourAccountPage {

    @FindBy(id = "address-link")
    WebElement myAddressButton;

    @FindBy (id = "history-link")
    WebElement ordersHistory;


    public MyStoreYourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMyAddressButton() {
        myAddressButton.click();
    }

    private void setInput(WebElement input, String value) {
        input.click();
        input.clear();
        input.sendKeys(value);
    }

    public void clickOrdersHistory(){
        ordersHistory.click();
    }
}
