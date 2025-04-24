package com.example.taller1.Controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.taller1.Repository.ProductRepository;
import com.example.taller1.Modelo.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/products")
    public List<Product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        int skip = size*page;
        List<Product> producticos = repo.findAll();
        List<Product> listadoFiltrado = producticos.stream()
            .filter(product -> minPrice == null || product.getPrice() >= minPrice)
            .filter(product -> maxPrice == null || product.getPrice() <= maxPrice)
            .filter(product -> category == null || product.getCategory().equalsIgnoreCase(category))
            .skip(skip)
            .limit(size)
            .collect(Collectors.toList());
      	//Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden aplicarse todos o ninguno
        return listadoFiltrado;
    }
    
@GetMapping("/products/stats")
public Map<String, Double> getStats(
    @RequestParam(required = false) String category
) {
    List<Product> producticos = repo.findAll();
    DoubleSummaryStatistics statistics = producticos.stream()
        .filter(product -> category == null || product.getCategory().equalsIgnoreCase(category))
        .mapToDouble(Product::getPrice)
        .summaryStatistics();
  //Obtenga el listado de productos filtrados por categoría

    return Map.of(
        "count", (double) statistics.getCount(),
        "avgPrice", statistics.getAverage(),
        "minPrice", statistics.getMin(),
        "maxPrice", statistics.getMax(),
        "totalValue", statistics.getSum()
    );
}

}
