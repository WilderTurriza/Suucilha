package suucilha.com.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "habitacion")
@Data
@NoArgsConstructor
public class Habitacion {
    @Id
    @Column(name = "habitacion_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long habitacion_id;
    @Column(name ="nombre")
    private String nombre;
    @Column(name = "costo")
    private Double costo;
    @Column(name = "descripción")
    private String descripcion;
    @Column(name = "personas")
    private int personas;


}
