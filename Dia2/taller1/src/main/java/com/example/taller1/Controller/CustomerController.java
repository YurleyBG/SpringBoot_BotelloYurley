package com.example.taller1.Controller;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.taller1.Repository.CustomerRepository;
import com.example.taller1.Modelo.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
    
    private final CustomerRepository repo;
    public CustomerController(CustomerRepository repo) { this.repo = repo; }

    @GetMapping("/Customer")
    public List<Customer> getCustomer(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        int skip = size * page;
        List<Customer> clientecitos = repo.findAll();
        List<Customer> listadoFiltrado = clientecitos.stream()
            .filter(customer -> firstName == null || customer.getFirstName().equalsIgnoreCase(firstName))
            .filter(customer -> lastName == null || customer.getLastName().equalsIgnoreCase(lastName))
            .filter(customer -> email == null || customer.getEmail().equalsIgnoreCase(email))
            .skip(skip)
            .limit(size)
            .collect(Collectors.toList());
          
        return listadoFiltrado;
    }
    
    
}
