package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreOrderSummaryPage {

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/div/div[3]/div/div[3]")
    WebElement summary;

    public MyStoreOrderSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String returnSummary() {
        return summary.getText();
    }
}
