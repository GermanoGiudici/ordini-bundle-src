package com.entando.hub.catalog.rest;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api")
public class TemplateController {
    /*

    @RolesAllowed("et-first-role")
    //@PreAuthorize("hasAuthority('ROLE_et-first-role')")
    @CrossOrigin
    @GetMapping("/")
    public MyResponse getExample() {
        return new MyResponse("test Data");
    }


    @Data
    public static class MyResponse{
        private final String payload;
    }
    */
    
    //@PreAuthorize("hasAuthority('ROLE_et-first-role')")
    @CrossOrigin
    @GetMapping("/order")
    public List<Order> getOrders() {
        return Arrays.asList(new Order[]{ new Order("test Data ", 1,"descrizione")});
    }

    @Data
    public static class Order{
        private final String name;
        private final Integer id;
        private final String description;

    }

}
