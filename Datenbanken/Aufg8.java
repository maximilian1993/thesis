import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufg8 {
	public static void main(String[] args){
		String dateiname = "EinlesDatei.txt";
		File file = new File(dateiname);
		
		if(!file.canRead() || !file.isFile()) {
			System.out.println("No such file");
			System.exit(0);
		}
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(dateiname));
			String zeile = null;
			String tabelle = " ";
			//Die einzelnen Anweisungen werden in diesem String hintereinander zusammengefasst
			String completeStatement = " ";
			
			
			//mit dieser Schleife werden die Zeilen der Textdatei durchgegangen
			while((zeile = in.readLine()) != null) {
				
				//das erste Zeichen aus jeder Zeile wird ausgelesen
				switch(zeile.charAt(0)) {
				
					//ist das erste Zeichen in der Zeile ein t, wird das hinter den Doppelpunkten 
					//geschrieben Wort als Wert für den Tabellennamen verwendet
					case 't': tabelle = zeile.substring(2,zeile.length());
							  break;
							  
					//ist das erste Zeichen ein i, wird ein SQL-Befehl für eine Einfügung in die Tabelle 
				    // erstellt. Die besagte Tabelle ist aus case 't' bekannt
					case 'i': //zunaechst wird der Primaerschluessel des entsprechenden Datensatzes gesucht
							  //da dieser in der Textzeile ganz forne steht, wird ab den Doppelpunkten
						      //bis zum ertsen | gesucht und dieser Wert als Primaerschluessel verwendet
							  int index = 1;
							  while(!zeile.substring(index - 1,index).contentEquals("|")) {
								  index++;
							  }
							  
							  int firstIndex = index-1;
							  
							  //in der Variable schluessel wird der Primaerschluessel gespeichert
							  String schluessel = zeile.substring(2, firstIndex);
							  
							  //als naechstes wird der Name des Zinssatzes gesucht.
							  //dazu wird in dem String nach dem Auftreten des ertsen |  bis zum naechsten 
							  // Auftreten eines | gesucht und dieser Wert als Name in der Variable 
							  //name gespeichert
							  while(!zeile.substring(firstIndex + 1,firstIndex + 2).contentEquals("|")) {
								  firstIndex++;
							  }
							  
							  int secondIndex = firstIndex + 1;
							  
							  //in der Variable name steht jetzte der Name des Zinssatzes
							  String name = zeile.substring(index, secondIndex);
							  
							  //nach dem Auftreten des |, welches den Namen des Zinssatzes abschliesst, wird
							  // wieder bis zum naechsten | gesucht und der String, der dazwischen liegt, 
							  //als Wert fuer den Zinssatz verwendet
							  while(!zeile.substring(secondIndex + 1 ,secondIndex + 2).contentEquals("|")) {
								  secondIndex++;
							  }
							  
							  int thirdIndex = secondIndex + 1;
							  
							  //in der Variable zinssatz wird der Wert des Zinssatzes gesichert
							  String zinssatz = zeile.substring(firstIndex + 2, thirdIndex);
							  
							  
							  //das Datum zu finden ist nun keine Schwierigkeit mehr. 
							  //Als Wert fuer das Datum kann einfach der ganz hinten im String stehende Wert verwendet werden
							  
							  String date = zeile.substring(secondIndex + 2);
							  
							  //nun wird aus den herausgefundenen Werten ein SQL Kommando fuer das Einfuegen erstellt
							  
							  String sqlinsert = "insert into " + tabelle + " values (" + schluessel + "," + "'" + name + "'" + "," + zinssatz + "," + "'" + date + "');";
							  
							  //Die einzelnen SQL-Anweisungen werden in einem String hintereinander geschrieben
							  completeStatement = completeStatement + sqlinsert;
							  
							  break;
							  
					//Wenn in der gelesenen Zeile ganz forne ein u steht, wird prinzipiell das gleiche wie in dem vorangegangenen 
				    // case gemacht, nur dass anstatt eines einfuegen-Kommandos ein update-Kommando ertsellt wird
					case 'u': //find number
						  int indexu = 1;
						  while(!zeile.substring(indexu - 1,indexu).contentEquals("|")) {
							  indexu++;
						  }
						  
						  int firstIndexu = indexu-1;
				
						  String schluesselu = zeile.substring(2, firstIndexu);
						  
						  //find name
						  while(!zeile.substring(firstIndexu + 1,firstIndexu + 2).contentEquals("|")) {
							  firstIndexu++;
						  }
						  
						  int secondIndexu = firstIndexu + 1;
						  
						  String nameu = zeile.substring(indexu, secondIndexu);
						  
						  //find Zinssatz
						  while(!zeile.substring(secondIndexu + 1 ,secondIndexu + 2).contentEquals("|")) {
							  secondIndexu++;
						  }
						  
						  int thirdIndexu = secondIndexu + 1;
						  
						  String zinssatzu = zeile.substring(firstIndexu + 2, thirdIndexu);
						  
						  
						  //find date
						  
						  String dateu = zeile.substring(secondIndexu + 2);
						  
						  //hier wird das update-Kommando erstellt und wie im vorangegangenen case in 
						  // das Array sqlcommand gepackt
						  
						  String sqlupdate = "UPDATE " +  tabelle + " SET zname = " + "'" + nameu + "'" + ",zinssatz = " + zinssatzu  + ",zdate = " + "'" + dateu + "'" + " WHERE zkey = " + schluesselu + ";";
						  
						  //Die einzelnen SQL-Anweisungen werden in einem String hintereinander geschrieben
						  completeStatement = completeStatement + sqlupdate;
						  
						  break;
						  
					//ist der erste Buchstabe in einer gelesenen Zeile ein d, wird ein delete-Kommando erstellt
					case 'd'://bei dem delete-Befehl muss nur der Primaerschluessel gefunden werden, weil alles zu
						     // diesem Schluessel gehörende geloescht wird
						  int indexd = 1;
						  while(!zeile.substring(indexd - 1,indexd).contentEquals("|")) {
							  indexd++;
						  }
						  
						  int firstIndexd = indexd-1;
				
						  String schluesseld = zeile.substring(2, firstIndexd);
						  
						  //Die einzelnen SQL-Anweisungen werden in einem String hintereinander geschrieben
						  String sqldelete = "DELETE FROM " + tabelle + " WHERE zkey = " + schluesseld + ";"; 
						  completeStatement = completeStatement + sqldelete;
						  break;
				}
			}
			
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
					//es wird eine Verbindung zu der Datenbank Zinsen hergestellt
				   con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Zinsen","postgres","Caracas");
				   //fuer rollback wird setAutocommit auf false gesetzt
				   con.setAutoCommit(false);
				   stmt = con.createStatement();
		   		
				   //hier werden die in dem String completeStatement gespeicherten SQL-Anweisungen
				   //ausgefuehrt.
				   //Doch sie werden in begin transaction und commit eingebettet, damit die Anweisungen als 
				   //"eine Anweisung" ausgefuehrt werden, um zu gewaehrleisten, dass die Kommandos nur ausgefuehrt
				   //werden, wenn auch wirklich kein Fehler auftritt
				   stmt.executeUpdate("begin transaction;" +  completeStatement + "commit");
		   		
				   con.close();
		  	
			   	} catch (Exception e) {
			   		//rollback bei Fehler
			   		try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				   System.out.println(e.getMessage());
			   } finally {
				   try {
					   if(rs != null) rs.close();
					   if(stmt != null) stmt.close();
					   if(con != null) con.close();
					   
				   } catch (Exception e) {
					   System.out.println(e.getMessage());
				   }
			   }
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
}
