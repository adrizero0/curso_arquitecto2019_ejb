package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@Override
	public List<Cliente> clientesConMovimientosFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
