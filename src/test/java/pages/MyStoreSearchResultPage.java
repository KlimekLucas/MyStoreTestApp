package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreSearchResultPage {

//    @FindBy(partialLinkText = "Hummingbird+Printed+Sweater")
//    private WebElement shirt;

//    @FindBy(partialLinkText = "brown-bear-printed-sweater")
//    private WebElement shirt;

    @FindBy(xpath = "//img[@alt='Brown bear printed sweater']")
    private WebElement shirt;


    public MyStoreSearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectHummingbirdShirt() {
        shirt.click();
    }


}
