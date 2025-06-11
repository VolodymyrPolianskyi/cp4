package pl.vpolianskyi.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.vpolianskyi.ecommerce.catalog.ArrayListProductStorage;
import pl.vpolianskyi.ecommerce.catalog.Product;
import pl.vpolianskyi.ecommerce.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Spring");
        SpringApplication.run(App.class, args);
    }
}