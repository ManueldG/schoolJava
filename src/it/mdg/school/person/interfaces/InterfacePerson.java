package it.mdg.school.person.interfaces;

import java.time.LocalDate;

public interface InterfacePerson {	
	
		public String getNome();
		public void setNome(String nome);

		public String getCognome();
		public void setCognome(String cognome);

		public LocalDate getDataDiNascita();
		public void setDataDiNascita(LocalDate dataDiNascita);

		public String getLuogoDiNascita();
		public void setLuogoDiNascita(String luogoDiNascita);

		public String getEmail();
		public void setEmail(String email);

		public String getCf();
		public void setCf(String cf);
		
		public boolean isValidCF();		
		
		
}
