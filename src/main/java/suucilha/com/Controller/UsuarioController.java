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

import suucilha.com.Entity.Usuario;
import suucilha.com.Service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService UsuarioService;
	

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllUsuarios(){
		try {
			return ResponseEntity.ok().body(UsuarioService.getAllUsuarios());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public Usuario createUsuario(@RequestBody Usuario Usuario){
		return UsuarioService.createUsuario(Usuario);
	}
	
	@PutMapping("/")
	@ResponseBody
	public Usuario updateUsuario(@RequestBody Usuario Usuario){
		return UsuarioService.updateUsuario(Usuario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteUsuario(@PathVariable (value = "id") Long id){
		UsuarioService.deleteUsuario(id);
	}
	

}