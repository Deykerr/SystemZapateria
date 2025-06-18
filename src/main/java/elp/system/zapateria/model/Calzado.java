package elp.system.zapateria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Calzado {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 
private long id;
private String marca;
private String talla;
private double precio;

}
