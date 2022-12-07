package com.ventacontable.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.ventacontable", includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Servicio$")
}, useDefaultFilters = false)
public class BeanServicio {
}
