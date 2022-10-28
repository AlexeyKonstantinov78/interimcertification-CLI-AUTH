package User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Registration {
    private static String lastName;
    private static String firstName;
    private static String patronymic;
    private static String phone;
    private static String email;
    private static String login;
    private static String password;

    public static void registration() {
        System.out.println("необходимо ввести\nФамилию Имя Отчество\nТелефон email\nlogin пароль\n");
        setLastName(); // фамилия
        setFirstName(); // имя
        setPatronymic(); // отчество
        setPhone();
        setEmail();
        setLogin();
        setPassword();
        System.out.println("Фамилия: " + lastName
                + "\nИмя: " + firstName + "\nОтчество: " + patronymic + "\nТелефон: " + phone + "\nEmail: " + email + "\nLogin: " + login + "\nPassword " + password);
        ListUser.addUserList(lastName, firstName, patronymic, phone, email, login, password);
        System.out.println("Регистрация завершена\n");
    }

    private static void setLastName() {
        int name = 1;
        String str = "";
        String regex = "[a-zA-Zа-яА-ЯёЁ]*";
        System.out.println("Введите фамилию");
        str = scan(name);
        if (str.matches(regex)) {
            lastName = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setLastName();
        }
    }

    private static void setFirstName() {
        int name = 2;
        String str = "";
        String regex = "[a-zA-Zа-яА-ЯёЁ]*";
        System.out.println("Введите имя");
        str = scan(name);
        if (str.matches(regex)) {
            firstName = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setFirstName();
        }
    }

    private static void setPatronymic() {
        int name = 3;
        String str = "";
        String regex = "[a-zA-Zа-яА-ЯёЁ]*";
        System.out.println("Введите Отчество");
        str = scan(name);
        if (str.matches(regex)) {
            patronymic = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setPatronymic();
        }
    }

    private static void setPhone() {
        int name = 4;
        String str = "";
        String regex = "^((\\+7|7|8)+([0-9]){10})$";
        System.out.println("Введите телефон России");
        str = scan(name);
        if (str.matches(regex)) {
            phone = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setPhone();
        }
    }

    private static void setEmail() {
        int name = 5;
        String str = "";
        String regex = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
        System.out.println("Введите email");
        str = scan(name);
        if (str.matches(regex)) {
            email = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setEmail();
        }
    }

    private static void setLogin() {
        int name = 6;
        String str = "";
        String regex = "^[a-z][a-z0-9-_\\.]{1,20}$";
        System.out.println("Введите логин для входа мин 2 мах 20\nпрописные латинские буквы, цифры" +
                "\nпервый символлатинская буква");
        str = scan(name);
        if (str.matches(regex)) {
            login = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setLogin();
        }
    }

    private static void setPassword() {
        int name = 7;
        String str = "";
        String regex = "(?=^.{3,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
        System.out.println("Введите пароль \n обязательно должны присутсвуовать\n строчные и прописные латинские буквы, цифры \n мин количесво символов 3 ");
        str = scan(name);
        if (str.matches(regex)) {
            password = str;
        } else {
            System.out.println("Введенны не коректные данные");
            setPassword();
        }
    }

    private static String scan(int panel) {
        Scanner input = new Scanner(System.in);
        String code = "";
        try {
            code = input.nextLine().trim();

        } catch (InputMismatchException e) {
            System.out.println("Неверная команда");
            switch (panel) {
                case 1 -> setLastName();
                case 2 -> setFirstName();
                case 3 -> setPatronymic();
                case 4 -> setPhone();
                case 5 -> setEmail();
                case 6 -> setLogin();
                case 7 -> setPassword();
            }
        }
        return code;
    }
}
