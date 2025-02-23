public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }

    public static Product fromString(String data) {
        String[] parts = data.split(",");
        return new Product(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2]),
                Double.parseDouble(parts[3])
        );
    }

    public String display() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price;
    }
}
