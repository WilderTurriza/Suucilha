package suucilha.com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
}
