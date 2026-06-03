package passwordvalidators;

import interfaces.ValidatorInterface;

public class UpperCaseValidator implements ValidatorInterface {

    @Override
    public boolean validate(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String description() {
        return "must contain an uppercase letter";
    }
    
}
