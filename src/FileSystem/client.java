package FileSystem;

import java.io.Serializable;


public class client implements Serializable {

	private buyInfo theGoods;
	private sellInfo theSellGoods;
	
	private String cName;
	private int	   number;
	private int    mileage;
	
	client(){
		
	}
	
	client(String c, int n, int m){
		cName  = c;
		number = n;
		mileage = m;
	}
	
	public void buyGoods(String name,int bMile){		
		mileage = mileage - bMile;
	}
	
	public void sellgoods(String name,int sMile){
		mileage = mileage + sMile;
		
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getNumber() {
		return number;
	}
	public int getmileage() {
		return mileage;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
