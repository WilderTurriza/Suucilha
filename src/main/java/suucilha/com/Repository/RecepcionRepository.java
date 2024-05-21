package suucilha.com.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import suucilha.com.Entity.Recepcion;

public interface RecepcionRepository extends JpaRepository<Recepcion, Long> {
	 @Query("SELECT r FROM Recepcion r WHERE r.fechaEntrada >= CURRENT_DATE")
	    List<Recepcion> findRecepcionesDesdeHoy();
	 
	 @Modifying
	 @Transactional
	 @Query("DELETE FROM Recepcion r WHERE r.fechaSalida < CURRENT_DATE")
	 	void deleteRecepcionesPasadas();

	 @Query("SELECT r FROM Recepcion r WHERE r.fechaEntrada <= :fechaSalida AND r.fechaSalida >= :fechaEntrada")
	    List<Recepcion> findRecepcionesPorFechas(@Param("fechaEntrada") LocalDate fechaEntrada, @Param("fechaSalida") LocalDate fechaSalida);

	 
	 @Query("SELECT r FROM Recepcion r WHERE r.fechaEntrada = :fechaEntrada")
	    List<Recepcion> findRecepcionesDelDia(LocalDate fechaEntrada);

}
