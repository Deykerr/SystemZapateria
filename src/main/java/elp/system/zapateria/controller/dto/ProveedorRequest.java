package elp.system.zapateria.controller.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProveedorRequest {

    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
    private String ruc;
    private Boolean activo;

}