package FileSystem;


public class sellGoods {

	private Manager confirmed;
	private sellInfo theClient;
	
	private String gName;
	private int hPrice;
	
	sellGoods(){
		
	}
	
	sellGoods(String g, int h){
		gName = g;
		hPrice = h;
		
	}
	
	
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public int gethPrice() {
		return hPrice;
	}
	public void sethPrice(int hPrice) {
		this.hPrice = hPrice;
	}
}
