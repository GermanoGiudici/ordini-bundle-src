package com.entando.hub.catalog.rest;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map.Entry;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class TemplateController {

    private static HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    
    @CrossOrigin
    @GetMapping("/orders")
    public Collection<Order> getOrders() {
        return orders.values();
    }

    @PostMapping("/orders")
    public ResponseEntity<String> createOrders(@RequestBody Order order)  {
        
        if(orders.containsKey(order.id)){
            return new ResponseEntity<>("Id già inserito",HttpStatus.BAD_REQUEST);

        }else{
            orders.put(order.id,order);
            return new ResponseEntity<>("Order creato", HttpStatus.OK);
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<String> updateOrders(@PathVariable Integer id, @RequestBody OrderWithoutId orderWithoutId)  {
        Order modifiedOrder;
        if(orders.containsKey(id)){
            Order order  = new Order(orderWithoutId.name,id,orderWithoutId.description);
            orders.put(id,order);
        
        modifiedOrder=(Order)orders.get(id);
        /*System.out.println(orders);*/
        return new ResponseEntity<>("Order modificato", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Impossibile aggiornare l'ordine in quanto id non presente", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrders(@PathVariable Integer id)  {
        if(id!=null && orders.containsKey(id)){
            orders.remove(id);
            return new ResponseEntity<>("Order rimosso", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Impossibile rimuovere l'ordine in quanto id non presente", HttpStatus.BAD_REQUEST);
                }
    
    }

    @Data
    public static class Order implements Serializable{
        private final String name;
        private final Integer id;
        private final String description;

    }
    @Data
    public static class OrderWithoutId implements Serializable{
        private final String name;
        private final String description;

    }

}
