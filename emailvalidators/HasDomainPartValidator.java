package emailvalidators;

import interfaces.ValidatorInterface;

public class HasDomainPartValidator implements ValidatorInterface{

    @Override
    public boolean validate(String email) {

        String[] parts = email.split("@");

        if (parts.length != 2) {
            return false;
        }
        
        return parts[1].length() != 0;
    }

    @Override
    public String description() {
        return "must contain a domain";
    }
    
}
