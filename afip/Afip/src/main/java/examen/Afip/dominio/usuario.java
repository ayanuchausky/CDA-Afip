package examen.Afip.dominio;

import java.util.List;

import javax.persistence.*;

@Entity
public class usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int clavefiscal;

	public int getClave_fiscal() {
		return clavefiscal;
	}

	public void setClave_fiscal(int clave_fiscal) {
		this.clavefiscal = clave_fiscal;
	}
	
	public List<impuesto> getImplist() {
        return implist;
    }

    public void setImplist(List<impuesto> implist) {
        this.implist = implist;
    }
	
	
	@ManyToMany()
	@JoinColumn(name = "impuesto", nullable = true)
	public List<impuesto> implist;
	

}
