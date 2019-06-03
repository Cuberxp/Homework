package ShopManagementSystem;

public class Goods {
	int no;
	String name;
	double price;

	Goods(int i, String j, double k) {
		this.no = i;
		this.name = j;
		this.price = k;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
