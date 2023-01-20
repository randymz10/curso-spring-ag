package com.bolsadeideas.springboot.app.springbootdi.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Primary
// @Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio{

    @Override
    public String operacion() {
        return "Ejcutando algun proceso importante complejo";
    }    
}
