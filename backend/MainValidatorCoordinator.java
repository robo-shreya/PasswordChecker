package backend;

import interfaces.ValidatorInterface;
import java.util.ArrayList;
import java.util.List;

public class MainValidatorCoordinator {

    public MainValidatorCoordinator(
        List<ValidatorInterface> validatorList
    ) {
        this.validatorList = validatorList;
    }

    List<ValidatorInterface> validatorList = new ArrayList<>();

    List<ValidatorInterface> failedTestValidatorList = new ArrayList<>();

    public void validate(
        String password
    ) {
        failedTestValidatorList.clear();

        for (int i = 0; i < validatorList.size(); i++) {
            ValidatorInterface validator = validatorList.get(i);
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
