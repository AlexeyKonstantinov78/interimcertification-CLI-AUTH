import User.ListUser;
import User.*;

import java.util.List;
import java.util.Scanner;

public class Auth {
    private static int count = 0;
    private static boolean auth = false;
    private static String loginAndEmail;
    private static String password;

    public static void autorization() {
        count = 0;
        System.out.println();
        System.out.println("Введите логин или email");
        loginAndEmail = scan().trim();
        System.out.println("Введите пароль");
        password = scan().trim();

        for (User user : ListUser.getUserList()) {
            count += 1;
            if (user.getLogin().equals(loginAndEmail) || user.getEmail().equals(loginAndEmail)) {

                if (user.getPassword().equals(password)) {
                    System.out.println("Вы авторизованны");
                    auth = true;
                    role(user.getRole());
                } else {
                    System.out.println("Неверный пароль");
                    autorization();
                }
                break;
            }
        }

        if (ListUser.getUserList().size() >= count && !auth) {
            System.out.println("Неверный логин или email");
            autorization();
        }
    }

    protected static void role(Role role) {
        System.out.println(role);
        if (role.equals(Role.ADMIN)) {
            Panel.adminPanel();
        } else {
            Panel.userPanel();
        }

    }

    private static String scan() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
