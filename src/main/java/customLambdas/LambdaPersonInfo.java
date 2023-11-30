package customLambdas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import staff.DepositEmployee;
import staff.Person;

import java.util.function.Function;

public class LambdaPersonInfo {
    private static final Logger LOGGER = LogManager.getLogger(LambdaPersonInfo.class);
    public static void main(String[] args) {
        // Creating an instance of a Person
        DepositEmployee depositEmployee = new DepositEmployee("Matias", "Morales", 25);

        // Lambda function to convert Person information to a string
        Function<Person, String> personInfoLambda = p ->
                "Person Information: " +
                        "First Name: " + p.getFirstName() +
                        ", Last Name: " + p.getLastName() +
                        ", Age: " + p.getPersonAge();

        // Applying the lambda function to get the Person information as a string
        String personInfo = personInfoLambda.apply(depositEmployee);
        LOGGER.info(personInfo);
    }
}
