/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Libro;
import model.Tema;

/**
 *
 * @author Profesortarde
 */

@Stateless
 public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext (unitName="librosPU")
	EntityManager em;	
	 
    
    @Override
	public List<Libro> recuperarLibros(){
    	Query qr=em.createNamedQuery("Libro.findAll");
    	return (List<Libro>)qr.getResultList();
    }
    @Override
	public List<Libro> recuperarLibros(int idTema){
    	Tema tm=em.find(Tema.class, idTema);
    	return tm.getLibros();
    }
	@Override
	public Libro recuperarLibrosIsbn(int isbn) {
		return (em.find(Libro.class, isbn));
	}   
    
}
