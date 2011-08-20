package datastructures;

public class Stock implements IStock {

	private int quantity;
	private double price;
	private String name;

	public Stock() {
		this.quantity = 0;
		this.price = 0;
		this.name = "";
	}

	public Stock(String name, int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean equals(Stock s) {
		return (this.name.equals(s.getName())
				&& this.quantity == s.getQuantity() && this.price == s
				.getPrice());
	}

	public String toString() {
		return this.name.toString() + " " + this.quantity + " $" + this.price;
	}

}
