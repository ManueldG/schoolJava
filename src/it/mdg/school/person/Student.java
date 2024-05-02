package it.mdg.school.person;

import java.util.ArrayList;
import java.util.List;

import it.mdg.school.data.Grades;

public class Student extends AbstractPerson {
	
	List<Grades> g = new ArrayList<Grades>();
	
	protected Integer classe;

	protected String sezione;

	public Student(String nome, String cognome, String dataDiNascita, String luogoDiNascita, String cF, String email, Integer classe, String sezione) {
				
		super(nome, cognome, dataDiNascita, luogoDiNascita, cF, email);
		
		this.classe =  classe;
		
		this.sezione = sezione;
		
	}		

	
	public void setVoti( Grades voto) {		
		
		this.g.add(voto) ;
		
	}
	
	public List<Grades> getVoti() {		
		
		return this.g;
		
	}

	public Integer getClasse() {
		return classe;
	}

	public void setClasse(Integer classe) {
		this.classe = classe;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
	
	protected Integer toInteger(String d) {
		
		return Integer.parseInt(d);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + ", classe = " + this.getClasse()+this.getSezione();
		
 	}


}
