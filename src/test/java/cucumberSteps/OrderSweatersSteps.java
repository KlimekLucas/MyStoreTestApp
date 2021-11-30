package cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class OrderSweatersSteps {

    private WebDriver driver;
    private MyStoreMainPage myStoreMainPage;
    private MyStoreLoginPage myStoreLoginPage;
    private MyStoreSearchResultPage myStoreSearchResult;
    private MyStoreProductPage myStoreProductPage;
    private MyStoreShoppingCartPage myStoreShoppingCartPage;
    private MyStorePersonalInfoPage myStorePersonalInfoPage;
    private MyStoreYourAccountPage myStoreYourAccountPage;
    private MyStoreOrderSummaryPage myStoreOrderSummaryPage;
    private String orderSummary;


    @Given("^Open page: (.*)$")
    public void beforeEach(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(url);
        myStoreMainPage = new MyStoreMainPage(driver);
        myStoreLoginPage = new MyStoreLoginPage(driver);
        myStoreSearchResult = new MyStoreSearchResultPage(driver);
        myStoreProductPage = new MyStoreProductPage(driver);
        myStoreShoppingCartPage = new MyStoreShoppingCartPage(driver);
        myStorePersonalInfoPage = new MyStorePersonalInfoPage(driver);
        myStoreYourAccountPage = new MyStoreYourAccountPage(driver);
        myStoreOrderSummaryPage = new MyStoreOrderSummaryPage(driver);


    }

    @When("click Search our Catalog")
    public void ClickSignInOnMainPage() {
        myStoreMainPage.SearchElement("Hummingbird Printed Sweater");
    }

    @When("SignIn user")
    public void signinUser() {
        myStoreMainPage.ClickSignInButton();
    }

    @And("Valid email and password")
    public void validEmailAndPassword() {
        myStoreLoginPage.fillPasswordInput("password");
        myStoreLoginPage.fillLoginInput("jutripedro@vusra.com");
        myStoreLoginPage.signIn();
    }


    @And("click on Hummingbird Printed Sweater")
    public void clickOnHummingbirdShirt() {
        myStoreSearchResult.selectHummingbirdShirt();
    }

    @And("add to cart")
    public void addToCart() {
        myStoreProductPage.addToCart();
    }

    @And("click proceed button")
    public void clickProceedButton() {
        myStoreProductPage.proceed();
    }

    @And("proceed Cart")
    public void proceedCart() {
        myStoreShoppingCartPage.clickProceedButton();
    }

    @And("select Shipping Method")
    public void selectShippingMethod() {
        myStorePersonalInfoPage.selectShippingMethod();
        myStorePersonalInfoPage.selectPickUpInStore();
    }

    @And("select payment Method")
    public void selectPaymentMethod() {
        myStorePersonalInfoPage.selectPaymentMethod();
        myStorePersonalInfoPage.selectPayByCheckOption();
        myStorePersonalInfoPage.clickTermsCheckbox();
        myStorePersonalInfoPage.clickConfirmPaymentButton();
        saveSum();
    }

    @And("take Screenshot")
    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "screens", "registration-success-evidence-" + currentDateTime + ".png"));
    }

    @And("select size: {word}")
    public void selectSizeM(String size) {
        myStoreProductPage.setChangeSizeto(size);
    }

    @And("select items number {int}")
    public void selectItemsNumber(int noOfItems) {
        myStoreProductPage.setNrOfProducts(noOfItems);
    }

    @And("check discount")
    public void checkDiscount() {
        myStoreProductPage.checkDiscount();
    }

    @And("Open user tab")
    public void openUserTab() {
        myStoreMainPage.ClickUserInfo();
    }

    @And("click order history")
    public void clickOrderHistory() {
        myStoreYourAccountPage.clickOrdersHistory();
    }

    private void saveSum() {
        orderSummary = myStoreOrderSummaryPage.returnSummary();
    }
}
