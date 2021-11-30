package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePersonalInfoPage {

    @FindBy(name = "confirm-addresses")
    private WebElement continueButton;

    @FindBy(id = "checkout-delivery-step")
    private WebElement selectShippingMethod;

    @FindBy(id = "delivery_option_1")
    private WebElement pickUpOnShopOption;

    @FindBy(id = "checkout-payment-step")
    private WebElement paymentMethod;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(id = "payment-confirmation")
    private WebElement paymentConfirmation;

    public MyStorePersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectPickUpInStore() {
        if (!pickUpOnShopOption.isSelected())
            pickUpOnShopOption.click();
    }

    public void selectShippingMethod() {
        selectShippingMethod.click();
    }

    public void selectPaymentMethod() {
        paymentMethod.click();
    }

    public void selectPayByCheckOption() {
        payByCheckOption.click();
    }

    public void clickTermsCheckbox() {
        if (!termsAndConditionsCheckbox.isSelected())
            termsAndConditionsCheckbox.click();
    }

    public void clickConfirmPaymentButton() {
        paymentConfirmation.click();
    }

    public void confirmButton() {
        continueButton.click();
    }
}
