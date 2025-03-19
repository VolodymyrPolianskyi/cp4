package pl.vpolianskyi.product;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String desc;

    private BigDecimal price;

    public Product(UUID productId, String name, String desc) {
        this.id = productId;
        this.name = name;
        this.desc = desc;
    }

    public String getId(){
        return this.id.toString();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void changePrice(BigDecimal newPrice) {
        this.price = newPrice;
    }
}
