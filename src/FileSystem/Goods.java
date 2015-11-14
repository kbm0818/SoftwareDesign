package FileSystem;

import java.util.List;

public class Goods {

	private Manager managed;
	private buyInfo theClient;
	
	private String name;
	private int number;
	private int price;
	
	Goods(){
		
	}
	
	Goods(String n, int num, int p){
		name = n;
		number = num;
		price = p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
		
}
