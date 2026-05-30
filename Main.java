import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to be validated: ");
        String password = scanner.nextLine();

        PasswordChecker passwordChecker = new PasswordChecker();

        passwordChecker.validate(password);
        List<String> violatedRulesList = passwordChecker.getFailedRules();

        for (int i = 0; i < violatedRulesList.size(); i++) {
            System.out.println(
                violatedRulesList.get(i)
            );            
        }

        scanner.close();
    }


}
