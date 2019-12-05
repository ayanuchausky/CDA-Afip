package examen.Afip.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.Afip.dominio.impuesto;

import java.sql.Date;
import java.util.List;

@Repository
public interface ImpuestoRepository extends JpaRepository<impuesto, Long> {
	
	List<impuesto> findAllByFechaBetween(Date desde, Date hasta);
	
	impuesto findByIdimpuestoLike(int impuesto);
	
	//List <impuesto> findAllByClavefiscalLike(int clavefiscal);

}
