package com.example.helloworld.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.domain.Producto;

@RestController
public class Api_controller {
    @GetMapping("/")
    public  String  home(){
        return "Home de  Campers!";
    }
    @GetMapping("/saludo") // saludo ? nombre= yurley
    public String saludo(
        @RequestParam(name= "nombre", required= true) String name,
        @RequestParam(name="apellido", required = false, defaultValue= "Apellido comun") String lastName
    ){
        return "hello "+ name+ " "+ lastName;
    }
    @GetMapping("/search") 
    public Map<String,String> buscar(
        @RequestParam(name= "nombre", defaultValue = "") String name
    ){
        Map<String,String>cities=new HashMap<>();
        cities.put("BUC","Bucaramanga");
        cities.put("NYC","New York");
        cities.put("BOG","Bogota");
        cities.put("NVA","Neiva");
        cities.put("LET","Leticia");
        cities.put("PER","Pereira");

        if(cities.containsKey(name)){
            return Map.of(name, cities.get(name));
        }else{
            return cities;
        }
    }


    @GetMapping("/tax") // saludo ? nombre= Camilo
    public Map<String, Object> calcular(
        @RequestParam( defaultValue= "0") double impuestos

    ){
        List<Producto> productos= new ArrayList<>(List.of(new Producto(1, "Pan", 2000.00)));
        productos.add(new Producto(2, "Gaseosa", 3500.00));
        productos.add(new Producto(3, "Salchichon Zenu", 1500.00));

        double total=0;
        double valor_neto=0;
        for (Producto i : productos){
            total+=i.getPrice();
            valor_neto+=i.getPrice()* (1*impuestos/100);
            

        }

        return Map.of("productos", productos, "total", total+valor_neto, "valor_neto", valor_neto/impuestos*100);
    }
}
