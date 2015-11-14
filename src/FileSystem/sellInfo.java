package FileSystem;


public class sellInfo {

	private sellGoods sSellGoods;
	private client sClient;
	
	private int price;
	private int gNumber;
	private int time;
	
	sellInfo(){
		
	}
	
	sellInfo(int p, int g, int t){
		price = p;
		gNumber = g;
		time = t;
		
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getgNumber() {
		return gNumber;
	}
	public void setgNumber(int gNumber) {
		this.gNumber = gNumber;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
