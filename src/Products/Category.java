package Products;

public enum Category {
    FURNITURE ("Мебель"),
    EQUIPMENT ("Оборудование"),
    INSTRUMENT ("Инструмент"),
    PRODUCTS ("Проудкты");

    private String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

//    @Override
//    public String toString() {
//        return "Category{" +
//                "title='" + title + '\'' +
//                "} " + super.toString();
//    }
}
