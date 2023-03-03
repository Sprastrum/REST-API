package demo.controller.dto;




public class ProductDTO {
    private String name;
    private int code;
    private int stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;
    @Override
    public String toString() {
        return "PetDTO{" +
                "name='" + name + '\'' +
                ", owner='" + price + '\'' +
                ", type='" + stock + '\'' +
                ", age=" + code +
                '}';
    }
}


