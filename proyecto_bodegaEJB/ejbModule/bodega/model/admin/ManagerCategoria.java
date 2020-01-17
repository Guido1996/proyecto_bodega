package bodega.model.admin;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import bodega.model.entities.Categoria;

/**
 * Session Bean implementation class ManagerCategoria
 */
@Stateless
@LocalBean
public class ManagerCategoria {

    /**
     * Default constructor. 
     */
	private EntityManager em;
	
    public ManagerCategoria() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<Categoria>findAllCategorias() throws Exception{
    	try {
    		String c="SELECT c FROM Categoria c";
        	Query q = em.createQuery(c,Categoria.class);
        	return q.getResultList();
		} catch (Exception e) {
			throw new Exception("No existe registro de categorias");
		}
    	
    }
 
    public Categoria findByIdCategoria(Integer id) {
    	Categoria c=em.find(Categoria.class, id);
    	return c;
    	
    }
    
    public void actualizarCategoria(Categoria cat)throws Exception{
    	Categoria c=findByIdCategoria(cat.getIdCategoria());
    	if (c==null) {
			throw new Exception("No existe la categoría especificada");
			
		} else {
			c.setNombreCategoria(cat.getNombreCategoria());
			c.setEstadoCategoria(cat.getEstadoCategoria());
			em.merge(c);
		}
    	
    }
    
    public void eliminarCategoria(Integer id) {
    	Categoria c=findByIdCategoria(id);
    	if (c!=null) {
			em.remove(c);
		}
    }
    
}
