package emailvalidators;

import interfaces.ValidatorInterface;

public class SingleAtValidator implements ValidatorInterface{

    @Override
    public boolean validate(String email) {
        int count = 0;

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    count++;
                }
        }

        return count == 1;
    }

    @Override
    public String description() {

        return "must have one @";
    }

}
