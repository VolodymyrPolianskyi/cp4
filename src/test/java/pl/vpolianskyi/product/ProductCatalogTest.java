package pl.vpolianskyi.product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;


public class ProductCatalogTest {
    @Test
    void itAllowsToListProduct(){
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assertTrue(products.isEmpty());
    }

    @Test
    void itAllowsToAddProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        catalog.createProduct("Lego", "suka");

        List<Product> products = catalog.allProducts();


        assertFalse(products.isEmpty());
    }

    @Test
    void catalogIdentifiesProductsWithUniqueID(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productid1 = catalog.createProduct("Lego2", "blya");
        String productid2 = catalog.createProduct("Lego3", "gg");

        assertNotEquals(productid2,productid2);

    }

    @Test
    void itAllowsToLoadProductByItsID(){
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.createProduct("Lego", "suka");

        Product loaded = catalog.loadProductById(id);

        assertEquals("Lego", loaded.getName());
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.createProduct("Lego", "suka");

        catalog.changePrice(id, BigDecimal.valueOf(200));
        Product loaded = catalog.loadProductById(id);

        assertEquals(BigDecimal.valueOf(200), loaded.getPrice());
    }

    @Test
    void priceCantBeLowerThanZero(){
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.createProduct("Lego", "suka");

        assertThrows(InvalidProductPriceException.class,
                ()->catalog.changePrice(id,BigDecimal.valueOf(-1)));
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }
}
