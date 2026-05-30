package validators;

public class PasswordLengthValidator implements PasswordValidatorInterface{

    @Override
    public boolean validate(String password) {

        return password.length() >= 8;

    }

    @Override
    public String description() {

        return "length must be 8";
    }

}
