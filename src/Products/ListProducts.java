package Products;

import java.util.ArrayList;
import java.util.List;

public class ListProducts {
    static List<Products> productsList = new ArrayList<>();

    static {
        productsList.add(new Products("Шкаф", Category.FURNITURE, 15000.00));
        productsList.add(new Products("Дрель", Category.INSTRUMENT, 4500.00));
        productsList.add(new Products("Сканер", Category.EQUIPMENT, 5500.00));
    }

    public static void addProducts(String name, Category category, double price) {
        productsList.add(new Products(name, category, price));
    }

    public static List<Products> getProductsList() {
        return productsList;
    }

    public static void printProduct() {
        for (Products product: productsList) {
            System.out.println(product.getName() + " " + product.getCategory().getTitle() + " " + product.getPrice());
        }
    }

}
