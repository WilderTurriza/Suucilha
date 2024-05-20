package suucilha.com.DTO;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecepcionDTO {
    private Long id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private Long habitacion_id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public RecepcionDTO(Long id, String nombreUsuario, String apellidoUsuario, Long habitacion_id, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.habitacion_id = habitacion_id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    // Getters y setters
}