package suucilha.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import suucilha.com.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Boolean existsByEmail(String email);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.contrasena = :contrasena")
	Usuario findByEmailAndPassword(@Param("email") String email, @Param("contrasena") String contrasena);



}
