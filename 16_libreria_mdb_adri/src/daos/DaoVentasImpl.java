package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Cliente;
import model.Venta;

/**
 * Session Bean implementation class DaoVentasImpl
 */
@Stateless
public class DaoVentasImpl implements DaoVentas {
	@PersistenceContext (unitName="librosPU")
	EntityManager em;	

	@Override
	public List<Venta> recuperarVentas(Cliente c) {
		return c.getVentas();
	}

	@Override
	public void altaVenta(Venta v) {
		em.persist(v);
	}
}
