package cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class logInUserSteps {


    private String alias;
    private String address;
    private String city;
    private String postal;
    private String country;
    private String phone;
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPage;
    private MyStoreLoginPage myStoreLoginPage;
    private MyStoreYourAccountPage myStoreYourAccountPage;
    private MyStoreAddressFormPage myStoreAddressFormPage;
    private MyStorePersonalInfoPage myStorePersonalInfoPage;
    private MyStoreConfirmAddressPage myStoreConfirmAddressPage;



    @Given("^Open webpage: (.*)$")
    public void beforeEach(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(url);
        myStoreMainPage = new MyStoreMainPage(driver);
        myStoreLoginPage = new MyStoreLoginPage(driver);
        myStoreYourAccountPage = new MyStoreYourAccountPage(driver);
        myStoreAddressFormPage = new MyStoreAddressFormPage(driver);
        myStorePersonalInfoPage = new MyStorePersonalInfoPage(driver);
        myStoreConfirmAddressPage = new MyStoreConfirmAddressPage(driver);

    }

    @When("click SignIn button")
    public void ClickSignInOnMainPage() {
        myStoreMainPage.ClickSignInButton();
    }

    @And("Valid email jutripedro@vusra.com and password password")
    public void fillLoginInfo() {
        myStoreLoginPage.fillPasswordInput("password");
        myStoreLoginPage.fillLoginInput("jutripedro@vusra.com");
        myStoreLoginPage.signIn();
    }

    @And("Click My Address")
    public void clickMyAddressButton() {
        myStoreYourAccountPage.clickMyAddressButton();
    }


    @And("Fill valid user info: {word}, {word}, {word}, {word}, {word}, {word}")
    public void fillValidUserInfo(String alias, String address, String city, String postal, String country, String phone) {
        MyStoreAddressFormData myStoreAddressFormData = new MyStoreAddressFormData();
        myStoreAddressFormData.setAlias(alias);
        this.alias = alias;
        myStoreAddressFormData.setAddress(address);
        this.address = address;
        myStoreAddressFormData.setCity(city);
        this.city = city;
        myStoreAddressFormData.setPostcode(postal);
        this.postal = postal;
        myStoreAddressFormData.setPhone(phone);
        this.phone = phone;
        this.country = country;
        myStoreAddressFormPage.fillPersonalInformation(myStoreAddressFormData);
        myStoreAddressFormPage.clickSave();
    }

    @Then("Confirm registration")
    public void confirmRegistrationSuccess() {
    }

    @And("click Continue")
    public void clickContinue() {
        myStorePersonalInfoPage.confirmButton();
    }

    @And("confirm success")
    public void confirmSuccess() {
        assertTrue(myStoreConfirmAddressPage.confirmAddressDeleted());
    }

    @And("delete address")
    public void deleteAddress() {
        myStoreConfirmAddressPage.clickDeleteButton();
    }

    @And("confirm valid data")
    public void confirmValidData() {
       String[] addressTable =  myStoreConfirmAddressPage.getAddressInfo();
        String alias = addressTable[0];
        String address = addressTable[2];
        String city = addressTable[3];
        String postalCode = addressTable[4];
        String country = addressTable[5];
        String phone = addressTable[6];
        String removeSpacesFromCountry = country.replaceAll("\\s+","");

        assertTrue(myStoreConfirmAddressPage.confirmData(alias,this.alias));
        assertTrue(myStoreConfirmAddressPage.confirmData(address,this.address));
        assertTrue(myStoreConfirmAddressPage.confirmData(city,this.city));
        assertTrue(myStoreConfirmAddressPage.confirmData(postalCode,this.postal));
        assertTrue(myStoreConfirmAddressPage.confirmData(removeSpacesFromCountry,this.country));
        assertTrue(myStoreConfirmAddressPage.confirmData(phone,this.phone));
    }
}






