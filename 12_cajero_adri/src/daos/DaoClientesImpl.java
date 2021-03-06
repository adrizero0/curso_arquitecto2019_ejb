package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;
import model.Cuenta;


@Stateless
public class DaoClientesImpl implements DaoClientes {
	@PersistenceContext (unitName="cajeroPU")
	EntityManager em;

	@Override
	public void altacliente(Cliente cliente) {
		em.persist(cliente);		
	}

	@Override
	public List<Cliente> clientesDeCuenta(int numeroCuenta) {
		Cuenta cuenta=em.find(Cuenta.class, numeroCuenta);
		return cuenta.getClientes();
	}

	@Override
	public void eliminarCliente(int idCliente) {
		Cliente cliente=em.find(Cliente.class, idCliente);
		if(cliente!=null) {
			em.remove(cliente);
		}		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<Cliente> clientesConMovimientosFecha(Date fecha) {
		String jpql="Select c From Cliente c join c.cuentas t join t.movimientos m ";
		jpql+="Where m.fecha=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, fecha);
		return (List<Cliente>)qr.getResultList();
	}

}
