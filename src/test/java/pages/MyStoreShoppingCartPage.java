package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreShoppingCartPage {


    public MyStoreShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".text-sm-center > .btn")
    private WebElement proceedButton;


    public void clickProceedButton() {
        proceedButton.click();
    }
}
