package backend;

import java.util.ArrayList;
import java.util.List;
import validators.PasswordDigitValidator;
import validators.PasswordLengthValidator;
import validators.PasswordLowerCaseValidator;
import validators.PasswordSymbolValidator;
import validators.PasswordUpperCaseValidator;
import validators.PasswordValidatorInterface;

public class PasswordChecker {

    public PasswordChecker() {
    }

    List<PasswordValidatorInterface> validatorList = new ArrayList<>(
            List.of(
            new PasswordDigitValidator(),
            new PasswordLengthValidator(),
            new PasswordLowerCaseValidator(),
            new PasswordSymbolValidator(),
            new PasswordUpperCaseValidator()
        )
    );

    List<PasswordValidatorInterface> failedTestValidatorList = new ArrayList<>();

    public void validate(
        String password
    ) {
        failedTestValidatorList.clear();

        for (int i = 0; i < validatorList.size(); i++) {
            PasswordValidatorInterface validator = validatorList.get(i);
            if (!validator.validate(password)) {
                failedTestValidatorList.add(validator);
            }
        }
    }

    public List<String> getFailedRules() {

        List<String> rulesViolated = new ArrayList<>();

        for (int i = 0; i < failedTestValidatorList.size(); i++) {
            rulesViolated.add(failedTestValidatorList.get(i).description());
        }
        return rulesViolated;
    }

}
