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

import lombok.RequiredArgsConstructor;
import suucilha.com.DTO.UsuarioDTO;
import suucilha.com.Entity.Usuario;
import suucilha.com.Service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
@RequiredArgsConstructor
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
	public ResponseEntity<?> registrarUsuario(@RequestBody Usuario Usuario){
		try {
	        Usuario usuario = UsuarioService.registrarUsuario(Usuario);
	        
	        if (usuario != null) {
	            return ResponseEntity.ok().body(usuario);
	        } else {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
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
	
	@GetMapping("/session")
	@ResponseBody
	public ResponseEntity<?> iniciarSesion(@RequestBody Usuario Usuario) {
	    try {
	        UsuarioDTO usuario = UsuarioService.getUsuario(Usuario.getUsername(), Usuario.getPassword());
	        
	        if (usuario != null) {
	            return ResponseEntity.ok().body(usuario);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
	    }
	}

}