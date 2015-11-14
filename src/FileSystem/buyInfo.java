package FileSystem;

public class buyInfo {
	
	private client bClient;
	private Goods bGoods;
	
	private int price;
	private int cNumber;
	private int gNumber;
	private int sTime;
	
	buyInfo(){
	
	}
	buyInfo(int p, int c, int g, int s){
		price = p;
		cNumber = c;
		gNumber = g;
		sTime = s;
	}
	
	public int getsTime() {
		return sTime;
	}
	public void setsTime(int sTime) {
		this.sTime = sTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getcNumber() {
		return cNumber;
	}
	public void setcNumber(int cNumber) {
		this.cNumber = cNumber;
	}
	public int getgNumber() {
		return gNumber;
	}
	public void setgNumber(int gNumber) {
		this.gNumber = gNumber;
	}
	
	
}
