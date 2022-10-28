import Products.Category;
import Products.ListProducts;
import Products.*;
import User.ListUser;
import User.Role;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Panel {

    protected static void adminPanel() {
        int code;
        System.out.println("Admin panel\n");
        System.out.println("Выбирете команду из списка");
        System.out.println("1 - Просмотр, Добавление, Удаление товаров");
        System.out.println("2 - Просмотри, изменение роли пользователя");
        System.out.println("3 - Выход в главное меню");
        System.out.println("4 - Завершение");
        code = scan(1);
        switch (code) {
            case 1 -> operationsProduct();
            case 2 -> operationsUser();
            case 3 -> Main.menu();
            case 4 -> System.exit(0);
            default -> {
                System.out.println("Такой команды нет");
                adminPanel();
            }
        }
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

    private static void operationsProduct() {
        int code;
        System.out.println("Операции с товарами\n");
        System.out.println("Выбирете команду из списка");
        System.out.println("1 - Просмотр перечня товаров");
        System.out.println("2 - Добавление товара");
        System.out.println("3 - Удаление товара");
        System.out.println("4 - Возврат в предедыдущее меню");
        System.out.println("5 - Возврат в основное меню");
        System.out.println("6 - Завершение");
        code = scan(3);
        switch (code) {
            case 1 -> ListProducts.printProduct();
            case 2 -> addProduct();
            case 3 -> deleteProducts();
            case 4 -> adminPanel();
            case 5 -> Main.menu();
            case 6 -> System.exit(0);
        }
        operationsProduct();
    }

    private static void addProduct() {
        double prise = 0;
        System.out.println("Добавление товара");
        System.out.println("Введите название товара");
        String nameProduct = scanString(4);
        Category category = choisesCategory();
        do {
            prise = addPrase();
        }
        while (prise == 0);

        System.out.println(nameProduct + " " + category + " " + prise);
        ListProducts.addProducts(nameProduct, category, prise);
        System.out.println("Товар добавлен");
    }

    private static void deleteProducts() {

        System.out.println("Удаление продукта\n ");
        System.out.println("Введите номер удаляемого продукта");
        int count = scan(6);

        List<Products> productsList = ListProducts.getProductsList();

        if (count > productsList.size() || count <= 0) {
            System.out.println("Нет такого товара");
            return;
        }

        for (int i = 0 ; i < productsList.size(); i++) {
            if ((i + 1) == count) {
                productsList.remove(i);
                System.out.println("Удаление произведено");

            }
        }
    }

    private static void operationsUser() {
        int code;
        System.out.println("Операции с пользователями\n");
        System.out.println("Выбирете команду из списка");
        System.out.println("1 - Просмотр информации о пользователях");
        System.out.println("2 - Смена ролей пользователя");
        System.out.println("3 - Возврат в предедыдущее меню");
        System.out.println("4 - Возврат в основное меню");
        System.out.println("5 - Завершение");
        code = scan(7);
        switch (code) {
            case 1 -> ListUser.printUser();
            case 2 -> updateUserRole();
            case 3 -> adminPanel();
            case 4 -> Main.menu();
            case 5 -> System.exit(0);
            default -> operationsUser();
        }
        operationsUser();
    }

    private static void updateUserRole() {
        System.out.println("Cмена роли пользователя");
        System.out.println("Введите номер ид пользователя для изменения роли");
        int code;
        do {
            code = scan(8);
            if (code > ListUser.getUserList().size() || code <= 0) {
                System.out.println("Такого пользователя нет");
            }
            if (code == 1) {
                System.out.println("Администраторскому профилю запрещено менять роль");
            }
        }
        while (code > ListUser.getUserList().size() || code <= 1);

        System.out.println("Какую роль установить");
        Role role = choiseRole();
        ListUser.getUserList().get((code - 1)).setRole(role);
        System.out.println("Роль изменена");
    }

    private static Role choiseRole() {
        Role role = Role.USER;
        System.out.println("Выбирите роль из списка");
        System.out.println("1 - ADMIN");
        System.out.println("2 - USER");
        int code;
        do {
            code = scan(9);
            System.out.println(code);

            if (code != 1 && code != 2) {
                System.out.println("Такой роли нет");
            }
        }
        while (code != 1 && code != 2);

        switch (code){
            case 1 -> role = Role.ADMIN;
            case 2 -> role = Role.USER;
        }
        return role;
    }

    private static Category choisesCategory() {
        Category category = Category.UNDEFAINED;
        System.out.println("Выбирете группу из списка и введите числовое значение");
        System.out.println("1 - Мебель");
        System.out.println("2 - Оборудование");
        System.out.println("3 - Инструмент");
        System.out.println("4 - Проудкты");
        System.out.println("5 - Нет категории");
        int code = scan(5);
        switch (code) {
            case 1 -> category = Category.FURNITURE;
            case 2 -> category = Category.EQUIPMENT;
            case 3 -> category = Category.INSTRUMENT;
            case 4 -> category = Category.PRODUCTS;
            case 5 -> category = Category.UNDEFAINED;
        }
        return category;
    }

    private static double addPrase() {
        double prise = 0;
        System.out.println("Введите стоймость товара");
        Scanner input = new Scanner(System.in);
        try {
            prise = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода");
        }
        return prise;
    }

    private static int scan(int panel) {
        Scanner input = new Scanner(System.in);
        int code = 0;
        try {
            code = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Неверная команда");
            switch (panel) {
                case 1 -> adminPanel();
                case 2 -> userPanel();
                case 3 -> operationsProduct();
                case 5 -> choisesCategory();
                case 6 -> deleteProducts();
                case 7 -> operationsUser();
                case 8 -> updateUserRole();
                case 9 -> choiseRole();
            }
        }
        return code;
    }

    private static String scanString(int panel) {
        Scanner input = new Scanner(System.in);
        String code = "";
        try {
            code = input.nextLine().trim();

        } catch (InputMismatchException e) {
            System.out.println("Неверная команда");
            switch (panel) {
                case 4 -> addProduct();
            }
        }
        return code;
    }

}
