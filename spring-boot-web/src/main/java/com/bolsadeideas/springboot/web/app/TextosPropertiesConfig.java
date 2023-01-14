package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
    @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {
    
}
