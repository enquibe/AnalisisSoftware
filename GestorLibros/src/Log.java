import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Log {
	
	/*
	 * append(String linea)
	 * 
	 * Adjunta una línea al log
	 * @param linea La linea a imprimir
	 * */
	public void append(String linea) {
		try(FileWriter fw = new FileWriter("log.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(linea);
		} catch (IOException e) {
		    
		}
	}
		
}
