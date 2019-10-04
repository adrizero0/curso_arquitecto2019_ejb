package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Pedido;

@Stateless
public class DaoPedidosImpl implements DaoPedidos {
	@PersistenceContext(unitName ="almacenPU" )
	EntityManager em;

	@Override
	public void altaPedido(Pedido pedido) {
		em.persist(pedido);		
	}

	@Override
	public List<Pedido> recuperarPedidos() {
//		String jpql="SELECT p FROM Pedido p";
//		Query qr=em.createQuery(jpql);
		Query qr=em.createNamedQuery("Pedido.findAll");
		return (List<Pedido>)qr.getResultList();
	}

	@Override
	public void eliminar(int idPedido) {
		Pedido pedido=em.find(Pedido.class, idPedido);
		if(pedido!=null) {
			em.remove(pedido);
		}		
	}

	@Override
	public Pedido recuperarPedidoPorId(int id) {
		return em.find(Pedido.class, id);
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		em.merge(pedido);
	}
}
