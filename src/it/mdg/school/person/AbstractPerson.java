package it.mdg.school.person;
 
import java.time.DateTimeException;
import java.time.LocalDate;

import it.mdg.school.person.interfaces.InterfacePerson;
import it.mdg.school.console.Util;


public class AbstractPerson implements InterfacePerson {
		
	
	protected String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String luogoDiNascita;
	private String cF;
	private String email;

	
	public AbstractPerson(String nome, String cognome, String dataDiNascita, String luogoDiNascita, String cF,	String email) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = this.stringToLocalDate(dataDiNascita);
		this.luogoDiNascita = luogoDiNascita;
		this.cF = cF;
		this.email = email;	
		
	}

	@Override
	public String getNome() {
		
		return this.nome;
	}

	@Override
	public void setNome(String nome) {
		
		this.nome = nome;

	}

	@Override
	public String getCognome() {
		
		return this.cognome;
	}

	@Override
	public void setCognome(String cognome) {
		
		this.cognome = cognome;

	}

	@Override
	public LocalDate getDataDiNascita() {
		
		return this.dataDiNascita;
		
	}

	@Override
	public void setDataDiNascita(LocalDate dataDiNascita) {
		
		this.dataDiNascita = dataDiNascita;

	}

	@Override
	public String getLuogoDiNascita() {
		
		return this.luogoDiNascita;
	}

	@Override
	public void setLuogoDiNascita(String luogoDiNascita) {
		
		this.luogoDiNascita = luogoDiNascita;

	}

	@Override
	public String getEmail() {
		
		return this.email;
		
	}

	@Override
	public void setEmail(String email) {
		
		this.email = email;

	}

	@Override
	public String getCf() {
		
		return this.cF;
		
	}

	@Override
	public void setCf( String cF) {
		
		this.cF = cF;

	}

	@Override
	public boolean isValidCF() {
		
		return Util.check(email, Util.PATTERN_CF);
	}
	
public boolean isValidEmail(String email){
		
		return Util.check(email, Util.PATTERN_EMAIL);
		
	}
	
	public boolean isValidDate(String date){
		
		return (Util.check(date, Util.PATTERN_DATE)) ;			
		
	}	
	
	public LocalDate stringToLocalDate(String date) {
		
		String[] dates;
		
		LocalDate localDate = null;
		
		if(this.isValidDate(date)) {
			
			dates = date.split("/");
			
			int dd = Integer.valueOf(dates[0]);
			int mm = Integer.valueOf(dates[1]);
			int yyyy = Integer.valueOf(dates[2]);
			
			try{
				
				localDate = LocalDate.of(yyyy, mm, dd);
				
			}catch (DateTimeException e) {
				
				e.getMessage();
				
			}			
			
		}
		
		return localDate;
		
	}
	
		@Override
		public String toString() {
				
			return "\nStudents nome=" + this.nome + ", cognome=" + this.cognome + ", cF=" + this.cF + ", email=" + this.email  ;
			
			}
		
		


}
