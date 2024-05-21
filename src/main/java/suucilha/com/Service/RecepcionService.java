package suucilha.com.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suucilha.com.DTO.RecepcionDTO;
import suucilha.com.Entity.Habitacion;
import suucilha.com.Entity.Recepcion;
import suucilha.com.Repository.RecepcionRepository;

@Service
public class RecepcionService {
	@Autowired
	private RecepcionRepository RecepcionRepository;
	
	@Autowired
	private HabitacionService habitacionService;
	
	public Recepcion createRecepcion(Recepcion Recepcion) {
		//log.info("Creando Recepcion: " +Recepcion.toString());
		return RecepcionRepository.save(Recepcion);
	}
	
	public Recepcion updateRecepcion(Recepcion Recepcion) {
		//log.info("Actualizando Recepcion: " +Recepcion.toString());
		return RecepcionRepository.save(Recepcion);
	}
	
	public List<RecepcionDTO> getAllRecepciones() {
		 List<Recepcion> recepciones = RecepcionRepository.findRecepcionesDesdeHoy();
		    return recepciones.stream()
		            .map(this::convertirARecepcionDTO)
		            .collect(Collectors.toList());
	}
	
	private RecepcionDTO convertirARecepcionDTO(Recepcion recepcion) {
	    RecepcionDTO recepcionDTO = new RecepcionDTO();
	    recepcionDTO.setId(recepcion.getId());
	    recepcionDTO.setNombreUsuario(recepcion.getUsuario().getNombre());
	    recepcionDTO.setApellidoUsuario(recepcion.getUsuario().getApellido());
	    recepcionDTO.setHabitacion_id(recepcion.getHabitacion().getHabitacion_id());
	    recepcionDTO.setFechaEntrada(recepcion.getFechaEntrada());
	    recepcionDTO.setFechaSalida(recepcion.getFechaSalida());
	    return recepcionDTO;
	}
	
	public void deleteRecepcion() {
		RecepcionRepository.deleteRecepcionesPasadas();
	}

	public List<Habitacion> getAllHabitaciones(LocalDate fechaInicio, LocalDate fechaFin) {
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		List<Recepcion> recepciones = RecepcionRepository.findRecepcionesPorFechas(fechaInicio,fechaFin);
		System.out.println(recepciones);
		List<Habitacion> habitaciones = habitacionService.getAllHabitaciones();
		System.out.println(habitaciones);
		
		List<Long> habitacionesOcupadasIds = recepciones.stream()
                .map(recepcion -> recepcion.getHabitacion().getHabitacion_id())
                .collect(Collectors.toList());

        List<Habitacion> habitacionesDisponibles = habitaciones.stream()
                .filter(habitacion -> !habitacionesOcupadasIds.contains(habitacion.getHabitacion_id()))
                .collect(Collectors.toList());

        return habitacionesDisponibles;
	}
}