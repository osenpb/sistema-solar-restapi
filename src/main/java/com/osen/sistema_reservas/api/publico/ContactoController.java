package com.osen.sistema_reservas.api.publico;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/public/contacto")
public class ContactoController {
    @GetMapping("/contacto")
    public String mostrarContacto() {

        //aqui no se que poner D:
        return "usuario/contacto";
    }
}
