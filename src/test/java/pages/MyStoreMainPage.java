package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMainPage {

    @FindBy(css = "span.hidden-sm-down")
    private WebElement userInfo;

    @FindBy(className = "user-info")
    private WebElement signInButton;

    @FindBy(name = "s")
    private WebElement searchField;


    public MyStoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void ClickSignInButton() {
        signInButton.click();
    }

    public void SearchElement(String search) {
        searchField.sendKeys(search);
        searchField.submit();
    }

    public void ClickUserInfo(){
        userInfo.click();
    }
}
