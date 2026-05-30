package validators;

public class PasswordLowerCaseValidator implements PasswordValidatorInterface {

    @Override
    public boolean validate(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String description() {
        return "must contain a lowercase letter";
    }
    
}
