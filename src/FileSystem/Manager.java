package FileSystem;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Manager {

	private Goods manage;
	private sellGoods confirm;
	private client theClient;
	
	Manager(){
		
	}
	
	
	
	
	
	public void deleteGoods(String name)throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream("test.txt"));
		
		in.readUTF().replace(name, "");
		
		in.close();
		
	}
	public void deleteClient(String name)throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream("test.txt"));
	
		
		in.readUTF().replace(name, "");
					
		in.close();
		
	}
	public Goods getManage() {
		return manage;
	}
	public void setManage(Goods manage) {
		this.manage = manage;
	}
	public client getTheClient() {
		return theClient;
	}
	public void setTheClient(client theClient) {
		this.theClient = theClient;
	}
	public sellGoods getConfirm() {
		return confirm;
	}
	public void setConfirm(sellGoods confirm) {
		this.confirm = confirm;
	}
	
}
