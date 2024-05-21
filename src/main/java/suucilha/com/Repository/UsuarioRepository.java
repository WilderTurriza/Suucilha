package suucilha.com.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import suucilha.com.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Boolean existsByUsername(String username);

	@Query("SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password")
	Usuario findByEmailAndPassword(@Param("username") String username, @Param("password") String password);
	
	Usuario findByNombre(String nombre);
	
	Optional<Usuario> findByUsername(String username);

	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	Usuario findByUsername2(String username); 
	
	



}
