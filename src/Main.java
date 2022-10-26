import User.ListUser;
import User.User;

public class Main {
    public static void main(String[] args) {
        ListUser.setUserList("1", "1", "1", "89000000", "", "","");
        ListUser.setUserList("1", "1", "1", "89000000", "", "","");
        ListUser.setUserList("1", "1", "1", "89000000", "", "","");
        ListUser.setUserList("1", "1", "1", "89000000", "", "","");
        ListUser.getUserList().forEach((n) -> System.out.println(n));
        System.out.println(ListUser.getUserList().get(1).getRole());

    }
}
