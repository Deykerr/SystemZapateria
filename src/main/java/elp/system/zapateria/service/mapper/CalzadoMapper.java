package elp.system.zapateria.service.mapper;

import org.springframework.stereotype.Component;

import elp.system.zapateria.controller.dto.CalzadoRequest;
import elp.system.zapateria.controller.dto.CalzadoResponse;
import elp.system.zapateria.model.Calzado;

@Component
public class CalzadoMapper {
    
    public Calzado toEntity(CalzadoRequest request) {
        Calzado calzado = new Calzado();  
        calzado.setMarca(request.getMarca());  
        calzado.setTalla(request.getTalla());
        calzado.setPrecio(request.getPrecio());
        return calzado;
    }

    public CalzadoResponse toResponse(Calzado calzado) {
        CalzadoResponse response = new CalzadoResponse();
        response.setId(calzado.getId());
        response.setMarca(calzado.getMarca());  
        response.setTalla(calzado.getTalla());
        response.setPrecio(calzado.getPrecio());
        return response;
    }
}
