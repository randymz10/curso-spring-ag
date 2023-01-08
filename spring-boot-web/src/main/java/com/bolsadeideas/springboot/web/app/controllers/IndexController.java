package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({ "/index", "/", "", "/home" })
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring!!");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Randy");
        usuario.setApellido("Munoz");
        usuario.setEmail("randy@mail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de usuarios");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Randy", "Munoz", "randy@mail.com"),
                new Usuario("John", "Doe", "john@mail.com"),
                new Usuario("Jane", "Doe", "jane@mail.com"));
        return usuarios;
    }
}
