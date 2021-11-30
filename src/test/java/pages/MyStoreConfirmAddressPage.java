package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreConfirmAddressPage {

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

    public boolean confirmAddressDeleted() {
        return alert.getText().equals("Address successfully deleted!");
    }

    public boolean confirmData(String compare, String compared) {
        return compare.equals(compared);
    }

    public String[] getAddressInfo() {
        String userInfo = addressInfo.getText();
        String[] addressTable = userInfo.split("\n");
        return addressTable;
    }
}



