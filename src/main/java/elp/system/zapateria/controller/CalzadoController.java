package elp.system.zapateria.controller;

import elp.system.zapateria.controller.dto.CalzadoRequest;
import elp.system.zapateria.controller.dto.CalzadoResponse;
import elp.system.zapateria.service.CalzadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calzados")
@RequiredArgsConstructor
public class CalzadoController {

    private final CalzadoService service;

    @PostMapping
    public CalzadoResponse crear(@RequestBody CalzadoRequest request) {
        return service.crear(request);
    }

    @GetMapping
    public List<CalzadoResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CalzadoResponse obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CalzadoResponse actualizar(@PathVariable Long id, @RequestBody CalzadoRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
