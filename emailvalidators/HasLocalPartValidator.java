package emailvalidators;

import interfaces.ValidatorInterface;

public class HasLocalPartValidator implements ValidatorInterface{

    @Override
    public boolean validate(String email) {

        String[] parts = email.split("@");

        if (parts.length != 2) {
            return false;
        }
        
        return parts[0].length() != 0;
    }

    @Override
    public String description() {
        return "must have a local part";
    }
    
}
