package Runner;

import Base.Setup;
import Page.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationRunner extends Setup {
    @Test
    public void signUpTest()  {
        RegistrationPage registration= new RegistrationPage(driver);
        driver.get("https://ideb.org.bd/register");
        registration.dosignup();
    }

}
