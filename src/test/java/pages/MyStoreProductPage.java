package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreProductPage {

    public MyStoreProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "discount-percentage")
    private WebElement discount;

    @FindBy(id = "group_1")
    private WebElement changeSize;

    @FindBy(id = "quantity_wanted")
    private WebElement nrOfProducts;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-content-btn > .btn-primary")
    private WebElement procedButton;

    public void setChangeSizeto(String size) {
        changeSize.sendKeys(size);
    }

    public void setNrOfProducts(int numberOfProducts) {
        nrOfProducts.click();
        nrOfProducts.clear();
        nrOfProducts.sendKeys(String.valueOf(numberOfProducts));
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean checkDiscount() {
        return discount.getText().contains("20%");
    }

    public void proceed() {
        procedButton.click();
    }
}
