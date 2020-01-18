package bodega.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bodega.model.admin.ManagerBodega;
import bodega.model.admin.ManagerPuntoVenta;
import bodega.model.entities.Bodega;
import bodega.model.entities.PuntoVenta;

@Named
@SessionScoped
public class BeanBodega implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Bodega> listaBodega;
	@EJB
	private ManagerBodega managerBodega;
	
	@EJB
	private ManagerPuntoVenta managerPv;
	private Bodega bodega;
	private PuntoVenta puntoVenta;

	@PostConstruct
	public void inicializar() {
		try {
			listaBodega = managerBodega.findAllBodega();
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
		}
		bodega = new Bodega();
	}

	public void actionListenerCargarBodega(Bodega bod) {
		try {
			bodega=new Bodega();
			puntoVenta=managerPv.findByIdPuntoVenta(bod.getPuntoVenta().getIdPtoVenta());
			bodega.setDireccionBodega(bod.getDireccionBodega());
			bodega.setNombreBodega(bod.getNombreBodega());
			bodega.setPuntoVenta(puntoVenta);
				///falta el usuario
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeError("No se ha podido cargar su bodega");
		}
	}
/*
	public void actionListenerActualizarPuntoVenta() {
		try {
			if (puntoVenta.getNombrePtoVenta().length() > 0 && !puntoVenta.getCorreoPtoVenta().isEmpty()) {
				if (puntoVenta.getCorreoPtoVenta().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
				PuntoVenta pv = managerpv.findByIdPuntoVenta(puntoVenta.getIdPtoVenta());
				pv.setCorreoPtoVenta(puntoVenta.getCorreoPtoVenta());
				pv.setDireccionPtoVenta(puntoVenta.getDireccionPtoVenta());
				pv.setNombrePtoVenta(puntoVenta.getNombrePtoVenta());
				pv.setTelefonoPtoVenta(puntoVenta.getTelefonoPtoVenta());
				managerpv.actualizarPuntoVenta(pv);
				listapv = managerpv.findAllPuntoVenta();
				JSFUtil.crearMensajeInfo("Actualizado con éxito");
				} else {
					JSFUtil.crearMensajeError("Debe ingresar un correo válido");
				}
			} else {
				JSFUtil.crearMensajeError("Debe ingresar el nombre del punto de venta");
			}

		} catch (Exception e) {
			JSFUtil.crearMensajeError("Error al actualizar");
		}

	}

	public void limpiarPuntoVenta() {
		puntoVenta.setCorreoPtoVenta("");
		puntoVenta.setDireccionPtoVenta("");
		puntoVenta.setNombrePtoVenta("");
		puntoVenta.setTelefonoPtoVenta("");
	}

	public void actionListenerInsertarPuntoVenta() {
		try {
			if (puntoVenta.getNombrePtoVenta().length() > 0 && !puntoVenta.getCorreoPtoVenta().isEmpty()) {
				if (puntoVenta.getCorreoPtoVenta().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {

					PuntoVenta pv = new PuntoVenta();
					pv.setCorreoPtoVenta(puntoVenta.getCorreoPtoVenta());
					pv.setDireccionPtoVenta(puntoVenta.getDireccionPtoVenta());
					pv.setNombrePtoVenta(puntoVenta.getNombrePtoVenta());
					pv.setTelefonoPtoVenta(puntoVenta.getTelefonoPtoVenta());
					managerpv.insertarPuntoVenta(pv);
					listapv = managerpv.findAllPuntoVenta();
					limpiarPuntoVenta();
					JSFUtil.crearMensajeInfo("Insertado con éxito");

				} else {
					JSFUtil.crearMensajeError("Debe ingresar un correo válido");
				}
			} else {
				JSFUtil.crearMensajeError("Debe ingresar todos los campos");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JSFUtil.crearMensajeError("Error al crear");
		}

	}

	public void actionListenerEliminarPuntoVenta(Integer id) {
		try {
			managerpv.eliminarPuntoVenta(id);
			listapv = managerpv.findAllPuntoVenta();
			JSFUtil.crearMensajeInfo("Su punto de venta ha sido eliminado");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JSFUtil.crearMensajeError("Error al eliminar");
		}

	}

	public List<PuntoVenta> getListapv() {
		return listapv;
	}

	public void setListapv(List<PuntoVenta> listapv) {
		this.listapv = listapv;
	}

	public PuntoVenta getPuntoVenta() {
		return puntoVenta;
	}

	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
*/
}
