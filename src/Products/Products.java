package Products;

import java.util.Arrays;

public class Products {
    private String name;
    private Category category;
    private double price;

    protected Products(String name, Category category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    //    public static void main(String[] args) {
//
//        System.out.println(Arrays.toString(Category.values()));
//
//    }

}
