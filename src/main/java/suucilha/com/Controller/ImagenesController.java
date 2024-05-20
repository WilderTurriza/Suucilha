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

import suucilha.com.Entity.Imagenes;
import suucilha.com.Service.ImagenesService;

@RestController
@RequestMapping(value="/imagenes")
public class ImagenesController {

	@Autowired
	private ImagenesService ImagenesService;
	

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllImageness(){
		try {
			return ResponseEntity.ok().body(ImagenesService.getAllImagenes());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public Imagenes createImagenes(@RequestBody Imagenes Imagenes){
		return ImagenesService.createImagenes(Imagenes);
	}
	
	@PutMapping("/")
	@ResponseBody
	public Imagenes updateImagenes(@RequestBody Imagenes Imagenes){
		return ImagenesService.updateImagenes(Imagenes);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteImagenes(@PathVariable (value = "id") Long id){
		ImagenesService.deleteImagenes(id);
	}
	

}