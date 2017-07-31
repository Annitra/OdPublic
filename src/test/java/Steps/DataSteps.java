package Steps;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.regex.Pattern;

/**
 * Created by User on 30.07.2017.
 */
public class DataSteps extends Tools {

    public DataSteps(WebDriver driver){
        this.driver = driver;
    }

        private  String inputName = "User";
        private String  inputSurname = "User";
        private String inputPassword = "password";

        private By idName = By.id("users_models_RegisterForm_name");
        private By idSurName =By.id("users_models_RegisterForm_family") ;


 private   void NameData(String inputName, String inputSurname){
        Preconditions();
        driver.findElement(idName).sendKeys(inputName);
        driver.findElement(idSurName).sendKeys(inputSurname);

    }

        private By idLogin  = By.id("users_models_RegisterForm_login");
 private    void UserData (String inputLogin){
        NameData(inputName,inputSurname);
        driver.findElement(idLogin).sendKeys(inputLogin);
    }

    private By idEmail =By.id("users_models_RegisterForm_email")  ;
    protected String patterEmails = "^(?i)[a-z0-9](?:[^@ ]{1,29})@(?:[a-z]{1,10}[a-z0-9\\-,.][a-z0-9]{1,17})\\.(?:[a-z]{1,3})$";

 private    void EmailData(String inputEmail){
        if(Pattern.matches(this.patterEmails, inputEmail)) {
            driver.findElement(idEmail).sendKeys(inputEmail);
        }
    }


    private By idPassword =By.id("users_models_RegisterForm_password") ;
    private By idRePassword =By.id("users_models_RegisterForm_password_repeat") ;

 private    void PasswordData(String inputPassword){
        driver.findElement(idPassword).sendKeys(inputPassword);
        driver.findElement(idRePassword).sendKeys(inputPassword);
    }

    private By regButton =By.id("submitRegistration") ;
 private    void Registrarion(){
        driver.findElement(regButton).click();
        sleep(5);
    }
 public    void doSuccessRegistration(){
        UserData("User11Login");
        EmailData("anuta07.0_5@gmail.com");
        PasswordData(inputPassword);
        Registrarion();
        Assert.assertTrue(isAlert());
    }

 public    void doUnSuccessRegistration(){
        driver.navigate().refresh();
        UserData("User1Login");
        EmailData("anuta07_.05@gmail.com");
        PasswordData(inputPassword);
        Registrarion();
        Assert.assertFalse(isAlert());
    }

}
