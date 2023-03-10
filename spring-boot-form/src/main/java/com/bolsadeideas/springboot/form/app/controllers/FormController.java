package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

import jakarta.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {

        Usuario usuario = new Usuario();

        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("123.456.789-K");

        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);

        return "form";
    }

    // @PostMapping("/form")
    // public String procesar(Model model,
    //         @RequestParam String username,
    //         @RequestParam String password,
    //         @RequestParam String email) {

    //     Usuario usuario = new Usuario();

    //     usuario.setUsername(username);
    //     usuario.setPassword(password);
    //     usuario.setEmail(email);

    //     model.addAttribute("titulo", "Resultado form");
    //     model.addAttribute("usuario", usuario);

    //     return "resultado";
    // }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
        
        model.addAttribute("titulo", "Resultado form");

        // if(result.hasErrors()) {
        //     Map<String, String> errores = new HashMap<>();
        //     result.getFieldErrors().forEach(err -> {
        //         errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
        //     });
        //     model.addAttribute("error", errores);
        //     return "form";
        // }

        if(result.hasErrors()) {
            return "form";
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
