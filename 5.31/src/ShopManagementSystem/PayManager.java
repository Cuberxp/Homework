package ShopManagementSystem;

public class PayManager {
	double discount;
	double price;

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	double jf(double jf) {// jf代表积分；
		double discountlater;
		if (jf < 1000)
			return jf *= 0.95;
		else if (jf < 2000)
			return jf *= 0.9;
		else if (jf < 3000)
			return discountlater = jf * 0.85;
		else if (jf < 4000)
			return discountlater = jf * 0.8;
		else if (jf < 6000)
			return discountlater = jf * 0.75;
		else if (jf < 8000)
			return discountlater = jf * 0.7;
		else
			discountlater = jf * 0.6;
		return discountlater;

	}
}
