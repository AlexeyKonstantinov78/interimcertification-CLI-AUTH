import Products.ListProducts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Panel {

    protected static void adminPanel() {
        System.out.println("Admin panel");
    }

    protected static void userPanel() {
        int code;
        System.out.println();
        System.out.println("User panel");
        System.out.println("Выбирете команду из списка");
        System.out.println("1 - Просмотр товаров");
        System.out.println("2 - Вернутся в основное меню с выходом");
        System.out.println("3 - Завершение");
        code = scan(2);
        switch (code){
            case 1 -> {
                System.out.println();
                ListProducts.printProduct();
                userPanel();
            }
            case 2 -> Main.menu();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Такой команды нет");
                userPanel();
            }
        }
    }

    private static int scan(int panel) {
        Scanner input = new Scanner(System.in);
        int code = 0;
        try {
            code = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Неверная команда");
            if (panel == 1) {
                adminPanel();
            } else {
                userPanel();
            }
        }
        return code;
    }
}
