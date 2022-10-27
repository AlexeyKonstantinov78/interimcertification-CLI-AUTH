import Products.Category;
import Products.ListProducts;
import User.ListUser;
import User.User;

public class Main {
    public static void main(String[] args) {
//        ListUser.addUserList("1", "1", "1", "89000000", "", "","");
//        ListUser.addUserList("1", "1", "1", "89000000", "", "","");
//        ListUser.addUserList("1", "1", "1", "89000000", "", "","");
//        ListUser.addUserList("1", "1", "1", "89000000", "", "","");
        ListUser.getUserList().forEach((n) -> System.out.println(n));
        System.out.println(ListUser.getUserList().get(0).getRole());

        ListProducts.addProducts("Тумбочка", Category.FURNITURE, 10000.00);
        ListProducts.printProduct();

    }
}
