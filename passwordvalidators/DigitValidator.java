package passwordvalidators;

import interfaces.ValidatorInterface;

public class DigitValidator implements ValidatorInterface {

    public DigitValidator() {
    }

    @Override
    public boolean validate(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String description() {
        return "must contain atleast 1 digit";
    }
    
}
