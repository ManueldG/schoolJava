package it.mdg.school.person.interfaces;

import java.time.LocalDate;

public interface InterfaceCalendar {
	
	//data, fascia oraria, materia, classe
	
	public void setDate(String date);
	
	public void setHour(String hour);
	
	public void setMatter(String matter);
	
	public void setClasses(Integer classes);
	
	public LocalDate getDate();
	
	public String getHour();
	
	public String getMatter();
	
	public Integer getClasses();

}
