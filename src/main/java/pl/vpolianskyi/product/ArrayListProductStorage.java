package pl.vpolianskyi.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProductStorage {
    private List<Product> products;

    public ArrayListProductStorage() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public void add(Product newProduct) {
        products.add(newProduct);
    }

    public Product loadProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
}
