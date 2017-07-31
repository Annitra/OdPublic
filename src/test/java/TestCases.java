import Steps.DataSteps;
import org.testng.annotations.Test;


/**
 * Created by User on 30.07.2017.
 */
public class TestCases extends PreconditionsOdPublic{

    @Test(groups = "positive",description = "Registration with correct data", priority = 1)
    void SuccessRegistration(){

        DataSteps dataSteps = new DataSteps(driver);
        dataSteps.doSuccessRegistration();

    }

    @Test(groups = "negative", description = "Registration with the same login or email", priority = 2)
    void UnSuccessRegistration(){

        DataSteps dataSteps = new DataSteps(driver);
        dataSteps.doUnSuccessRegistration();
    }
}
