package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class RegistrationPage {
    @FindBy(xpath = "//input[contains(@placeholder,'Full Name')]")
    public WebElement textFullName;

    @FindBy(name = "sex")
    public WebElement cbGender;
    @FindBy(xpath = "//input[contains(@placeholder,'-- Select Membership District --')]")
    public List<WebElement>  cbMember;
    @FindBy (name = "department")
    public WebElement cbDepartment;
    @FindBy (xpath = "(//*[@name =\"institution\"])[1]")
    public WebElement cbInstitution;
    @FindBy(xpath = "(//*[@name =\"institution\"])[2]")
    public WebElement cbPassingYear;
    @FindBy(xpath = "//input[contains(@placeholder,'Mobile No Start With 01')]")
    public WebElement textMobileNumber;
    @FindBy(css = "[type=email]")
    public WebElement textEmail;
    @FindBy(xpath = "(//*[@type =\"password\"])[1]")
    public WebElement textPassword;
    @FindBy(xpath = "//input[contains(@placeholder,'Confirm Password')]")
    public WebElement textConfirmPassword;
    @FindBy(css="[type=Submit]")
    public WebElement btnSignUp;
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public void dosignup() {
        // Generate a random three-digit number
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;
        textFullName.sendKeys("Afifa Mumu");
        Select gender= new Select(cbGender);
        gender.selectByValue("Female");
        //Select member= new Select(cbMember);
        cbMember.get(0).click();
        cbMember.get(0).sendKeys(Keys.ARROW_DOWN);
        cbMember.get(0).sendKeys(Keys.ARROW_DOWN);
        cbMember.get(0).sendKeys(Keys.ARROW_DOWN);
        cbMember.get(0).sendKeys(Keys.ARROW_DOWN);
        cbMember.get(0).sendKeys(Keys.ARROW_DOWN);
        cbMember.get(0).sendKeys(Keys.ARROW_DOWN);
        cbMember.get(0).sendKeys(Keys.ENTER);
        //scroll
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textFullName);
        Select department= new Select(cbDepartment);
        department.selectByValue("Computer Science & Technology");
        Select institution= new Select(cbInstitution);
        institution.selectByValue("Ahsanullah University of Science and Technology");
        Select passingYear= new Select(cbPassingYear);
        passingYear.selectByValue("2019");
        textMobileNumber.sendKeys("01644326"+randomNumber);
        textEmail.sendKeys("afifa" +randomNumber+ "@yopmail.com");
        textPassword.sendKeys("Afifamumu1@");
        textConfirmPassword.sendKeys("Afifamumu1@");
        btnSignUp.click();

    }

}
