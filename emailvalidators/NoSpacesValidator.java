package emailvalidators;

import interfaces.ValidatorInterface;

public class NoSpacesValidator implements ValidatorInterface{

    @Override
    public boolean validate(String email) {
        return !email.contains(" ");
    }

    @Override
    public String description() {
        return "must have zero spaces";
    }
    
}
