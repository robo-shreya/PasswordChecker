package passwordvalidators;

import interfaces.ValidatorInterface;

public class LengthValidator implements ValidatorInterface{

    @Override
    public boolean validate(String password) {

        return password.length() >= 8;

    }

    @Override
    public String description() {

        return "length must be 8";
    }

}
