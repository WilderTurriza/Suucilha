package suucilha.com.Controller;

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

import suucilha.com.Entity.Habitacion;
import suucilha.com.Service.HabitacionService;

@RestController
@RequestMapping(value="/habitacion")
public class HabitacionController {

	@Autowired
	private HabitacionService HabitacionService;
	

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllHabitaciones(){
		try {
			return ResponseEntity.ok().body(HabitacionService.getAllHabitaciones());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public Habitacion createHabitacion(@RequestBody Habitacion Habitacion){
		return HabitacionService.createHabitacion(Habitacion);
	}
	
	@PutMapping("/")
	@ResponseBody
	public Habitacion updateHabitacion(@RequestBody Habitacion Habitacion){
		return HabitacionService.updateHabitacion(Habitacion);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteHabitacion(@PathVariable (value = "id") Long id){
		HabitacionService.deleteHabitacion(id);
	}
	

}