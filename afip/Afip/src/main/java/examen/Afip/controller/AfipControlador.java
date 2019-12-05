package examen.Afip.controller;


import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


import examen.Afip.dominio.*;
import examen.Afip.repositorio.*;

@RestController
public class AfipControlador {
	@Autowired
	ImpuestoRepository impuestorepository;
	
	@Autowired
    UsuarioRepository usuariorepository;
	
	@PutMapping("/fechaimpuesto/{idimpuesto}/{fechanueva}")
	public impuesto ActualizarFecha(@PathVariable int idimpuesto,@PathVariable Date fechanueva) {
		impuesto imp1= this.getImpuesto(idimpuesto);
		
		imp1.setDate(fechanueva);
		return impuestorepository.save(imp1);
	}
	
	@GetMapping("/consultar-liquidacion/{desde}/{hasta}")
	public List<impuesto> getImpuestosByDate(@PathVariable Date desde, @PathVariable Date hasta){
		return impuestorepository.findAllByFechaBetween(desde,hasta);
		
	}
	
	@GetMapping("/lista-impuestos/{clavefiscal}")
	public List<impuesto> getImpuestosByClaveFiscal(@PathVariable int clavefiscal){
		
		return usuariorepository.findByClavefiscalLike(clavefiscal).getImplist();
	}
	
	
	
	//para ir rellenando la tabla usuario x impuesto con clave fiscal y el ID
	
	
	@PutMapping("/asociar/{clavefiscal}/{impuesto}")
	public usuario saveUsuarioximpuesto (@PathVariable int clavefiscal,@PathVariable int impuesto){
		usuario usu = this.getClavefiscal(clavefiscal);
		impuesto imp = this.getImpuesto(impuesto);
		usu.getImplist().add(imp);
		return usuariorepository.save(usu);
	}

	@GetMapping("/usuario/{claveFiscal}")
	public usuario getClavefiscal(@PathVariable int clavefiscal){
		return usuariorepository.findByClavefiscalLike(clavefiscal);
	}
	
	@GetMapping("/impuesto/{impuestoid}")
	public impuesto getImpuesto(@PathVariable int impuestoid){
		return impuestorepository.findByIdimpuestoLike(impuestoid);
	}
}
