package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping({"/", ""})
    public String index() {
        return "/params/index";
    }
    
    @GetMapping("/string")
    public String param(@RequestParam(required = false) String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado es : " + texto);
        return "params/ver";
    }
}
