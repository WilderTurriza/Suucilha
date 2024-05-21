package suucilha.com.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import suucilha.com.Entity.FechasRequest;
import suucilha.com.Entity.Recepcion;
import suucilha.com.Service.RecepcionService;


@RestController
@RequestMapping(value="/recepcion")
public class RecepcionController {

	@Autowired
	private RecepcionService RecepcionService;
	

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllRecepciones(){
		try {
			return ResponseEntity.ok().body(RecepcionService.getAllRecepciones());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("disponibles")
	@ResponseBody
	public ResponseEntity<?> getAllHabitaciones(@RequestBody FechasRequest fechaRequest){
		try {
			return ResponseEntity.ok().body(RecepcionService.getAllHabitaciones(fechaRequest.getFechaEntrada(),fechaRequest.getFechaSalida()));
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}

	@PostMapping("/")
	@ResponseBody
	public Recepcion createRecepcion(@RequestBody Recepcion Recepcion){
		return RecepcionService.createRecepcion(Recepcion);
	}
	
	@PutMapping("/")
	@ResponseBody
	public Recepcion updateRecepcion(@RequestBody Recepcion Recepcion){
		return RecepcionService.updateRecepcion(Recepcion);
	}
	
	@DeleteMapping("/")
	@ResponseBody
	public void deleteRecepcion(){
		RecepcionService.deleteRecepcion();
	}
	

}