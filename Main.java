import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to be validated: ");
        String password = scanner.nextLine();

        PasswordChecker passwordChecker = new PasswordChecker();

        passwordChecker.validate(password);
        passwordChecker.getFailedRules();

        scanner.close();
    }


}
