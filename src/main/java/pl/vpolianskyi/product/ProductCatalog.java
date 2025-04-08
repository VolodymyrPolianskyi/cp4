package pl.vpolianskyi.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    ArrayListProductStorage arrayStorage;

    public ProductCatalog( ArrayListProductStorage arrayStorage) {
        this.arrayStorage = arrayStorage;
    }

    public List<Product> allProducts() {
        return arrayStorage.allProducts();
    }

    public String createProduct(String name, String desc) {
        UUID productId = UUID.randomUUID();

        var newProduct = new Product(productId, name, desc);
        arrayStorage.add(newProduct);

        return newProduct.getId();
    }

    public Product loadProductById(String id) {
        return arrayStorage.loadProductById(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        var loaded = arrayStorage.loadProductById(id);
        loaded.changePrice(newPrice);
    }
}
