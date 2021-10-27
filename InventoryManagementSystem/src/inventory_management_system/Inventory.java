package inventory_management_system;

public class Inventory {
	private String name;
	private String iD;
	private int price;
	private int stock;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Inventory(String name, String iD, int price, int stock) {
		super();
		this.name = name;
		this.iD = iD;
		this.price = price;
		this.stock = stock;
	}
}

