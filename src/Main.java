import User.ListUser;
import User.Registration;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ListUser.addUserList("1", "1", "1", "89000000", "", "","");
//        ListUser.addUserList("1", "1", "1", "89000000", "", "","");
        ListUser.addUserList("1", "1", "1", "89000000", "1", "1","1");
        ListUser.addUserList("as", "1", "1", "89000000", "as", "as","as");
//        ListUser.getUserList().forEach((n) -> System.out.println(n));
//        System.out.println(ListUser.getUserList().get(0).getRole());
//
//        ListProducts.addProducts("Тумбочка", Category.FURNITURE, 10000.00);
//        ListProducts.printProduct();
        menu();
    }

    public static void menu(){
        int numMenu = 0;
        System.out.println("МЕНЮ");
        System.out.println("Выбирите действие набрав цифру");
        System.out.println("1 - авторизация");
        System.out.println("2 - зарегистрироватся");
        System.out.println("3 - внести данные в программу");
        System.out.println("4 - завершение");

        Scanner input = new Scanner(System.in);
        try {
            numMenu = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода");
            System.out.println("Веедите цифру из перечня");
            menu();
        }

        switch (numMenu) {
            case 1 -> {
                System.out.println("Авторизация");
                Auth.autorization();
            }
            case 2 -> {
                System.out.println("Регистрация");
                System.out.println();
                Registration.registration();
                Auth.autorization();
            }
            case 3 -> System.out.println("Ввод данных");
            case 4 -> System.exit(0);
            default -> {
                System.out.println("нет такого пункта меню");
                menu();
            }
        }
    }
}
