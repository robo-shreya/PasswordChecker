package passwordvalidators;

import interfaces.ValidatorInterface;

public class SymbolValidator implements ValidatorInterface {

    @Override
    public boolean validate(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String description() {
        return "must contain atleast 1 symbol or special character";
    }
    
}
