package it.mdg.school.main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.mdg.school.console.Util;
import it.mdg.school.person.Secretariat;
import it.mdg.school.person.Student;
import it.mdg.school.person.Teacher;



/*
 * fatta lista studenti e insegnanti gestito inserimento controllo validazione salvataggio file e stampa a schermo
 * 
 * TODO:
 *  - path + file conf
 *  - aggiornare menu con colori o titolo 
 *  - vorrei unire stampa e scrivi file in uno generico 
 *  - impostare per dbms -> jdbc
 *  - voti media generale e media materia
 *  - lista segreteria  agg (ufficio, orario lavoro)
 *  - stampa classe (classe,sezione)
 *  - migliorare messaggi feedback
 * 
 */

public class Main {
	
	protected static List<Student> s = new ArrayList<Student>();
	protected static List<Teacher> t = new ArrayList<Teacher>();
	protected static List<Secretariat> se = new ArrayList<Secretariat>();
	
	protected static final String STUDENT_FILE = "student.txt";
	protected static final String TEACHER_FILEe = "teacher.txt";
	protected static final String SECRETARIAT_FILEe = "secretariat.txt";

	public Main() {
		
	}

	public static void main(String[] args) {
		
		
		
		try {
			choose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	protected static void menu() {
		
		System.out.println("""
				--------          MENU           --------
				-1) inserisci studente
				-2) inserisci insegnante
				-3) stampa lista studenti
				-4) stampa lista insegnanti
				-5) salva lista studenti
				-6) salva lista insegnanti
				- premi un altro numero per uscire
				""");
		
	}
	
	protected static void choose() {		
		
		Scanner l = new Scanner(System.in);
		
		int choose = -1;
		
		do {
			menu();
			
			choose = l.nextInt();
			
			switch(choose) {
			
				case 1:
					addStudent();
				break;
				
				case 2:
					System.out.println("Inserisci insegnante");
					addTeacher();
				break;
				
				case 3:
					System.out.println("stampa studenti");
					printStudent();
					
				break;
				
				case 4:
					System.out.println("stampa Insegnanti");
					printTeacher();
				break;
				
				case 5:
					System.out.println("salva studenti");
					Util.saveEntity(s);
					
				break;
				
				case 6:
					System.out.println("salva Insegnanti");
					Util.saveEntity(t);
					//saveTeacher();
				break;
				
				default:
					System.out.println("Ciao");
					return;
				
			
			}
		}while(choose!=0);
		
		l.close();
		
	}

	protected static void addStudent() {	
		
		Scanner l = new Scanner(System.in);
				
		System.out.println("Inserisci studente");
		
		System.out.println("Inserisci nome");
		String nome = l.nextLine();
		
		System.out.println("Inserisci cognome");
		String cognome = l.nextLine();
		
		System.out.println("Inserisci data di nascita");
		String dataDiNascita = l.nextLine();
		
		System.out.println("Inserisci luogo di nascita");
		String luogoDiNascita = l.nextLine();
		
		System.out.println("Inserisci codice fiscale");
		String cF = l.nextLine();
		
		System.out.println("Inserisci email");
		String email = l.nextLine();
		
		System.out.println("Inserisci classe");
		Integer classe = Integer.valueOf(l.nextLine()); 		
				
		System.out.println("Inserisci sezione");		
		String sezione = l.nextLine();			
		
		Student student = new Student(nome, cognome, dataDiNascita, luogoDiNascita, cF, email, classe, sezione);
		System.out.println(nome + cognome + dataDiNascita + luogoDiNascita+ cF + email + classe +sezione);
			
		s.add(student);		
		
		l.close();
	}
	
	protected static void addTeacher() {	
		
		Scanner l = new Scanner(System.in);
		
		//Main m = new Main();
				
		System.out.println("Inserisci nome");
		String nome = l.nextLine();
		
		System.out.println("Inserisci cognome");
		String cognome = l.nextLine();
		
		System.out.println("Inserisci data di nascita (gg/mm/aaaa)");		
		String dataDiNascita = l.nextLine();
		if ( !Util.check(dataDiNascita, Util.PATTERN_DATE) ) 
			dataDiNascita = "01/01/1900";
		
		System.out.println("Inserisci luogo di nascita");
		String luogoDiNascita = l.nextLine();
		
		System.out.println("Inserisci codice fiscale");
		String cF = l.nextLine();
		if ( !Util.check(cF, Util.PATTERN_CF) ) 
			cF = "0000000000000";
		
		System.out.println("Inserisci email");
		String email = l.nextLine();
				
		Teacher teacher = new Teacher(nome, cognome, dataDiNascita, luogoDiNascita, cF, email);
		System.out.println(t.add(teacher));
		
		l.close();
			
		
	}
	
	protected static void printTeacher() {
		
		for( Teacher elem :  t ) {
						
			System.out.println( elem.getNome() + " " + elem.getCognome() + " " + elem.getCf() + " " + elem.getEmail() + " " + elem.getDataDiNascita().toString() + " " + elem.getLuogoDiNascita());
		}
		
	}

	protected static void printStudent() {	
	
		
		for( Student elem :  s ) {
			System.out.println( elem.getNome() + " " + elem.getCognome() + " " + elem.getCf() + " " + elem.getEmail() + " " + elem.getClasse() + " " + elem.getSezione() + " " + elem.getDataDiNascita().getDayOfMonth() + "/" + elem.getDataDiNascita().getMonthValue() + "/" + elem.getDataDiNascita().getYear() + " " + elem.getLuogoDiNascita());
		}
	
}
	
	
	
/*	private static void saveTeacher() {
		
		try {
			Util.resetFile("teacher.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Teacher elem : t)
			try {
				Util.writeToFile( elem.toString() , "teacher.txt");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
	}

	private static void saveStudent() {
		
		try {
			Util.resetFile("student.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Student elem : s)
			try {
				Util.writeToFile( elem.toString(), "student.txt" );
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}*/
	
	

}
