package demo.controller.dto;


import lombok.Getter;
import lombok.Setter;

public class ProductDTO {
    @Getter
    private String name;
    @Getter
    private int code;
    @Getter @Setter
    private int stock;
    @Getter
    private int price;
    @Override
    public String toString() {
        return "PetDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", code=" + code +
                '}';
    }
}


