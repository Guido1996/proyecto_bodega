package bodega.controller.admin;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bodega.model.admin.ManagerCategoria;
import bodega.model.entities.Categoria;

@Named
@SessionScoped
public class BeanCategoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List<Categoria>listaCategoria;
	@EJB
	private ManagerCategoria managerCategoria;
	private Categoria categoria;
	
	@PostConstruct
	public void inicializar()  {
		try {
			listaCategoria=managerCategoria.findAllCategorias();	
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
		}
	
	categoria=new Categoria();
	}

	
	
	
	
	
	
	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
