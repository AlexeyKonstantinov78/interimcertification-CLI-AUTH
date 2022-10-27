package User;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
    private static int id = 0;
    static List<User> userList = new ArrayList<>();

    static {
        id += 1;
        userList.add(new User(id ,"Admin", "Admin", "Admin", "89000000000", "admin@gmail.com", "admin","admin", Role.ADMIN));
    }

    public static void addUserList(String lastName, String firstName, String patronymic, String phone, String email, String login, String password) {
        id += 1;
        userList.add(new User(id, lastName, firstName, patronymic, phone, email, login, password));
    }

    public static List<User> getUserList() {
        return userList;
    }
}
