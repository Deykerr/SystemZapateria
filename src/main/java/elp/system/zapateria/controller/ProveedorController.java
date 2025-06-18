package elp.system.zapateria.controller;

import elp.system.zapateria.controller.dto.ProveedorRequest;
import elp.system.zapateria.controller.dto.ProveedorResponse;
import elp.system.zapateria.service.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("Zapat/proveedor") // Define la ruta base para los endpoints de proveedor, igual que en AlumnoController
public class ProveedorController {

    @Autowired // Se mantiene el uso de @Autowired en el campo, igual que en AlumnoController
    private ProveedorService proveedorService;

    @GetMapping("/proveedores") // Mapea solicitudes GET a Zapat/proveedor/proveedores
    public ResponseEntity<Collection<ProveedorResponse>> getProveedores() {
        return ResponseEntity.ok(proveedorService.findAllProveedores());
    }

    @GetMapping("/proveedor/{id}") // Mapea solicitudes GET a Zapat/proveedor/proveedor/{id}
    public ResponseEntity<ProveedorResponse> getProveedorById(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorService.findByIdProveedor(id));
    }

    @PostMapping("/save/proveedor") // Mapea solicitudes POST a Zapat/proveedor/save/proveedor
    public void saveProveedor(@RequestBody ProveedorRequest request) {
        proveedorService.saveProveedor(request);
    }

    @PutMapping("/update/proveedor/{id}") // Mapea solicitudes PUT a Zapat/proveedor/update/proveedor/{id}
    public void updateProveedor(@PathVariable Long id, @RequestBody ProveedorRequest request) {
        proveedorService.updateProveedor(id, request);
    }

  
    @PutMapping("/delete/proveedor/{id}") // Mapea solicitudes PUT a Zapat/proveedor/delete/proveedor/{id}
    public void deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
    }
}