package it.mdg.school.data;

import java.time.LocalDate;

import it.mdg.school.person.interfaces.InterfaceGrades;

public class Grades implements InterfaceGrades {

	protected float grade;

	public Grades(float grade, String matter,String date) {
		
	}

	@Override
	public float getGrade() {
		
		return this.grade;
	}

	@Override
	public void setGrade(float grade) {
		
		this.grade = grade;

	}

	@Override
	public String getMatter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMattter(String matter) {
		// TODO Auto-generated method stub

	}

	@Override
	public LocalDate getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDate(String date) {
		// TODO Auto-generated method stub

	}

}
