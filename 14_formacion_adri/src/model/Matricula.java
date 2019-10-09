package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matriculas database table.
 * 
 */
@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaPK id;

	private double nota;

	public Matricula() {
	}

	public MatriculaPK getId() {
		return this.id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

}