package com.example.taller1.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.taller1.Modelo.Product;
@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    {
        products.add(new Product(1L, "Laptop", "Electrónica", 999.99, 20));
        products.add(new Product(2L, "Café", "Alimentos", 12.49, 100));
        products.add(new Product(3L, "Silla ", "Muebles", 189.99, 15));
        products.add(new Product(4L, "Cepillo de dientes", "Higiene", 2.99, 250));
        products.add(new Product(5L, "Zapatillas deportivas", "Ropa", 89.95, 40));
        products.add(new Product(6L, "Auriculares", "Electrónica", 59.99, 35));
        products.add(new Product(7L, "Camiseta", "Ropa", 14.99, 80));
        products.add(new Product(8L, "Termo", "Hogar", 24.99, 60));
        products.add(new Product(9L, "Libro de cocina", "Libros", 18.50, 25));
        products.add(new Product(10L, "Aceite de oliva", "Alimentos", 9.75, 70));
        products.add(new Product(11L, "Lámpara", "Hogar", 34.90, 22));
        products.add(new Product(12L, "Set de herramientas", "Ferretería", 49.99, 18));
        products.add(new Product(13L, "Perfume", "Belleza", 59.95, 28));
        products.add(new Product(14L, "Mochila", "Accesorios", 39.99, 45));
        products.add(new Product(15L, "Detergente líquido", "Limpieza", 6.89, 55));
        products.add(new Product(16L, "Pelota de fútbol", "Deportes", 25.99, 30));
        products.add(new Product(17L, "Mouse", "Hogar", 15.00, 40));
        products.add(new Product(18L, "Cubo rugby", "Juguete", 159.99, 12));
        products.add(new Product(19L, "Pan integral", "Alimentos", 3.20, 90));
        products.add(new Product(20L, "Crema hidratante", "Belleza", 11.50, 35));
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> getProducts() {
        return products;
    }
    
}
