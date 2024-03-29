package ShopManagementSystem.domain;

/**
 * 	商品类
 * @author 零
 *他是在ShopManagementSystem包下的domain包下的
 */
public class Goods {
	 //编号
     private String id;
     //名称
     private String name;
     //价格
     private double price;
     
     public Goods(){}

 	public Goods(String id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
