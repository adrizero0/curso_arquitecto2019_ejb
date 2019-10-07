package daos;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;
import model.Venta;

@Local
public interface DaoVentas {
	List<Venta> recuperarVentas(Cliente c);

}
