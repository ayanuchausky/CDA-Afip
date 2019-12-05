package examen.Afip.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.Afip.dominio.impuesto;
import examen.Afip.dominio.usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario,Long> {
	
	usuario findByClavefiscalLike(int clavefiscal);
	
	List <usuario> findAllByClavefiscalLike(int clavefiscal);

}
