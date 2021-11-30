package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreLoginPage {

    @FindBy(name = "email")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public MyStoreLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillLoginInput(String login) {
        setInput(loginInput, login);
    }

    public void fillPasswordInput(String password) {
        setInput(passwordInput, password);
    }

    private void setInput(WebElement input, String value) {
        input.click();
        input.clear();
        input.sendKeys(value);
    }

    public void signIn(){
        signInButton.submit();
    }
}
