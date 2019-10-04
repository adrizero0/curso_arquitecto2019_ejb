package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Contacto;


@Stateless
public class DaoContactosImpl implements DaoContactos {
	@PersistenceContext(unitName ="contactosPU" )
	EntityManager em;

	@Override
	public void eliminarContacto(int id) {
		Contacto contacto=em.find(Contacto.class, id);
		if(contacto!=null) {
			em.remove(contacto);
		}		
	}

	@Override
	public List<Contacto> recuperarContactos() {
		String jpql="SELECT c FROM Contacto c";
		Query qr=em.createQuery(jpql);
		return (List<Contacto>)qr.getResultList();
	}

	@Override
	public void altaContacto(Contacto contacto) {
		em.persist(contacto);
		
	}

	@Override
	public List<Contacto> recuperarContactosPorNombre(String n) {
		//String jpql="SELECT c FROM Contacto c WHERE c.nombre LIKE '%"+n+"%'";
		String jpql="SELECT c FROM Contacto c WHERE c.nombre LIKE ?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, "%"+n+"%");
		return (List<Contacto>)qr.getResultList();
	}

	@Override
	public Contacto recuperarContactoPorEmail(String email) {
		//String jpql="SELECT c FROM Contacto c WHERE c.email='"+email+"'";	
		String jpql="SELECT c FROM Contacto c WHERE c.email=?1";		
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, email);
		return (Contacto) qr.getSingleResult();
	}

}





