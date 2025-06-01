package budget.program.data;

import java.io.Serial;
import java.io.Serializable;

public class Purchase implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String item;
    private double price;
    private String type;

    public Purchase(String type, String item, double price) {
        this.item = item;
        this.price = price;
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getType(){return type;}
    public void setType(String type){this. type = type;}
}