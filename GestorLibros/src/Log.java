import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Log {
	
	static String logFile = System.getProperty("user.dir") + "/GestorLibros/log.txt";
	
	/*
	 * append(String linea)
	 * 
	 * Adjunta una línea al log
	 * @param linea La linea a imprimir
	 * */
	public void append(String linea) {
		try(FileWriter fw = new FileWriter(logFile, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(linea);
		} catch (IOException e) {
		    
		}
	}
		
}
