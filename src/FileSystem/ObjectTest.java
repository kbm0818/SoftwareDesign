package FileSystem;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectTest {
	public static void main(String[] args) {
		int id; 
		String name;
		int mil;
		File file = null;
		ObjectInputStream input = null;
		ObjectOutputStream output = null;
	//	BufferedWriter bw = new BufferedWriter(output,1024);
		client record;
		
		try {
			file = new File("text.txt");
			output = new ObjectOutputStream(new FileOutputStream( file) );
			
			record = new client("이순신", 32, 25 );
			output.writeObject( record );
			//record = new client("이순신", 33, 26 );
			//output.writeObject( record );
			output.close();
			
						
			input = new ObjectInputStream(new FileInputStream( file) );
			try {
				while (true) {
					record = (client) input.readObject();

					id = record.getNumber(); name = record.getcName(); mil = record.getNumber();

					System.out.printf("%d %s\n", id, name  );
				}
			} catch( EOFException e ) { ; }
			catch ( ClassNotFoundException e){System.err.println( "Unable to create object." );}
			input.close();
		}
		catch(FileNotFoundException e) {System.err.println( "File not found." ); return;}
		catch(IOException e) {System.err.println( "Error either on opening file, writing to file, or closing file." ); return; }
		finally {
			if (input != null) try { input.close(); } catch (IOException e) {e.printStackTrace();}
			if (output != null) try { output.close();} catch (IOException e) {e.printStackTrace();}
		} }
}
