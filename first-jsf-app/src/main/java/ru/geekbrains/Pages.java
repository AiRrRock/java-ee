package ru.geekbrains;

public enum Pages {
    Main("Главная", "main"),
    Catalog("Каталог", "catalog"),
    Product("Товар", "product"),
    Category("Категория", "category"),
    User("Пользователь", "user"),
    Order("Заказ", "order"),
    Cart("Корзина", "cart");

    private String heading;
    private String path;


    Pages(String heading, String path) {
        this.heading = heading;
        this.path = path;
    }

    public String getHeading() {
        return heading;
    }

    public String getPath() {
        return path;
    }
}
