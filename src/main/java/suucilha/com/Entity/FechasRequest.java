package suucilha.com.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FechasRequest {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
}
