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
import suucilha.com.Auth.LoginRequest;
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
	
	@PostMapping("sesion")
	@ResponseBody
	public ResponseEntity<?> getUsuario(@RequestBody String username){
		try {
			return ResponseEntity.ok().body(UsuarioService.getUsuario(username));
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	
	@PutMapping("/")
	@ResponseBody
	public Usuario updateUsuario(@RequestBody Usuario Usuario){
		return UsuarioService.updateUsuario(Usuario);
	}
	
	@PutMapping("changePassword")
	@ResponseBody
	public Usuario updatePassword(@RequestBody LoginRequest request){
		
		return UsuarioService.updatePassword(request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteUsuario(@PathVariable (value = "id") Long id){
		UsuarioService.deleteUsuario(id);
	}

}