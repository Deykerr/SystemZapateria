package elp.system.zapateria.service;


import java.util.List;

import elp.system.zapateria.controller.dto.CalzadoRequest;
import elp.system.zapateria.controller.dto.CalzadoResponse;

public interface CalzadoService {
CalzadoResponse crear(CalzadoRequest request);
List<CalzadoResponse> listar();
CalzadoResponse buscarPorId(long id);
CalzadoResponse actualizar(long id, CalzadoRequest request);
void eliminar(long id);
}
