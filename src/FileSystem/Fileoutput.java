package FileSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Fileoutput {
	public static void main(String[] ar) throws IOException{

		File f = new File("test.txt");
		FileWriter fw = new FileWriter(f);

		//BufferedWriter bw = new BufferedWriter(fw,1024);
		client c1 = new client("ȫ�浿",25,50);
		
		fw.write(c1.getcName());
		//w.newLine();
		fw.write(c1.getNumber());
		//bw.newLine();
		fw.write(c1.getmileage());
		//bw.close();
		fw.close();
		System.out.printf("%d %d",c1.getNumber(),c1.getmileage());
	}
}
