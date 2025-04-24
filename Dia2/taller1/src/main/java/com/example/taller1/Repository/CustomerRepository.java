package com.example.taller1.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.taller1.Modelo.Customer;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();
    {
        customers.add(new Customer(1L, "Juan", "Pérez", "juan.perez@example.com"));
        customers.add(new Customer(2L, "Ana", "García", "ana.garcia@example.com"));
        customers.add(new Customer(3L, "Carlos", "López", "carlos.lopez@example.com"));
        customers.add(new Customer(4L, "Lucía", "Martínez", "lucia.martinez@example.com"));
        customers.add(new Customer(5L, "Pedro", "Sánchez", "pedro.sanchez@example.com"));
        customers.add(new Customer(6L, "María", "Ramírez", "maria.ramirez@example.com"));
        customers.add(new Customer(7L, "Luis", "Torres", "luis.torres@example.com"));
        customers.add(new Customer(8L, "Laura", "Flores", "laura.flores@example.com"));
        customers.add(new Customer(9L, "Jorge", "Cruz", "jorge.cruz@example.com"));
        customers.add(new Customer(10L, "Sofía", "Moreno", "sofia.moreno@example.com"));
        customers.add(new Customer(11L, "Diego", "Ortiz", "diego.ortiz@example.com"));
        customers.add(new Customer(12L, "Valentina", "Silva", "valentina.silva@example.com"));
        customers.add(new Customer(13L, "Andrés", "Castro", "andres.castro@example.com"));
        customers.add(new Customer(14L, "Camila", "Ruiz", "camila.ruiz@example.com"));
        customers.add(new Customer(15L, "Hugo", "Delgado", "hugo.delgado@example.com"));
        customers.add(new Customer(16L, "Elena", "Ramos", "elena.ramos@example.com"));
        customers.add(new Customer(17L, "Mateo", "Fernández", "mateo.fernandez@example.com"));
        customers.add(new Customer(18L, "Isabel", "Vargas", "isabel.vargas@example.com"));
        customers.add(new Customer(19L, "Ricardo", "Jiménez", "ricardo.jimenez@example.com"));
        customers.add(new Customer(20L, "Natalia", "Herrera", "natalia.herrera@example.com"));
    }
    public List<Customer> findAll(){
        return customers;
    }

}
