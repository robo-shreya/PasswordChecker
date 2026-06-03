package emailvalidators;

import interfaces.ValidatorInterface;

public class DomainDotValidator implements ValidatorInterface {

    @Override
    public boolean validate(String email) {

        String[] parts = email.split("@");

        if (parts.length != 2) {
            return false;
        }

        String domain = parts[1];

        if(!domain.contains("."))
            return false;

        if(domain.startsWith("."))
            return false;

        if(domain.endsWith("."))
            return false;

        return true;

    }

    @Override
    public String description() {

        return "domain is not valid";
    }


    
}
