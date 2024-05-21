package suucilha.com.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suucilha.com.Entity.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	private Long id;
	private String nombre;
	private String apellido;
	private String username;
	private Role role;
}
