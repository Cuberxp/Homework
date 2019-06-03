package ShopManagementSystem;

import java.util.Scanner;

import ShopManagementSystem.domain.Goods;
import ShopManagementSystem.service.PayManager;

//购物车
class PayCar{
	//商品编号和数量
	String id;
	
	int num;
	
	PayCar(String id,int num){
		this.id = id;
		
		this.num = num;
	}
}

public class Data {
	Scanner scanner=new Scanner(System.in);
	//会员号
	String x;
	
	//用户类,里面有会员信息
	Date customerDate = Date.getDate();
	//购物车类
	PayCar[] payCar = new PayCar[500];
	
	Goods []goods=new Goods[10];
	public int count=0;
	PayManager parManager = new PayManager();
	
	//初使化商品。如果使用goods方法的话，请在程序的取开始调用该方法，不然，count的值永远为0，那么本类中的第44行for中的语句不会执行
	/**
	 *初始化代码块就像下面的代码一样。。。
		初始化代码块分为静态初始化代码块（加一个static）和非静态初始化代码块（像下面一样）两类。
		初始化代码块出现于类的主体中，在类的声明中，可以包含多个初始化块，当创建类的实例时，就会依次执行这些代码块。如果使用 static 修饰初始化块，就称为静态初始化块。
		这些初始化代码块起到了类的构造方法的作用，当无参实例化一个类的对象时，完全可以用代码块代替构造方法的位置。
		非静态初始化块隐性运行于创建类的对象时，顺序依据代码块的先后排列，且这些代码块间可以存在其他方法。也就是说在实例化这个对象时，会从类的头到尾检索一遍来运行初始化代码块。
	 */
	{
	   Goods x1=new Goods("1","addidas运动鞋",880);
	   goods[count++]=x1;
	   Goods x2=new Goods("2","kappa网球鞋",200);
	   goods[count++]=x2;
	   Goods x3=new Goods("3","网球拍",780);
	   goods[count++]=x3;
	   Goods x4=new Goods("4","addidasT恤衫",420.78);
	   goods[count++]=x4;
	   Goods x5=new Goods("5","nice运动鞋",900);
	   goods[count++]=x5;
	   Goods x6=new Goods("6","kappa网球",45);
	   goods[count++]=x6;
	   Goods x7=new Goods("7","KappaT恤",245);
	   goods[count++]=x7;
	}
	
	public void information(){//显示所有信息；
		double alljf=0;//总积分；
		
//		int x=scanner.nextInt();
		
		System.out.println("****************************");
		System.out.println("请选择购买的商品编号：");
		System.out.println("商品编号\t\t商品名称\t\t商品价格");
		
		//应该要等他的商品信息输出完再处理吧。
		for(int i=0;i<count;i++){
			System.out.println(goods[i].getId()+"\t"+goods[i].getName()+"\t"+goods[i].getPrice());
		}	
		
		customerChooseGoods();
		
		return ;
	}
	
	/**
	 * 顾客选择商品
	 */
	public void customerChooseGoods() {

		while(true) {
			//判断输入的会员号在不在customerDate数据中
			System.out.println("*******************************");
			System.out.println("请输入会员号：");
			//这是一个全局变量，方便在showDiscounts中调用。
			x=scanner.next();
			
			boolean flag = false;
			for(int i = 0; i < customerDate.count; i ++) {
				if(customerDate.customs[i].getVip().equals(x)) {
					flag = true;
					
					break;
				}
			}
			
			if(flag) {
				int count = 0;
				
				/**
				 * 顾客选择的商品放入购物车类中
				 */
				while(true) {
					System.out.println("请输入商品编号：");
					String y=scanner.next();
					
					System.out.println("请输入商品数量：");
					
					int z=scanner.nextInt();
					
					payCar[count++] = new PayCar(y,z); 
					
					System.out.println("是否继续（y/n）");
					String choice = scanner.next();
			        if("n".equals(choice))
			        	break;
				}
				/*
				 * for(int k = 0;k < count;k ++){ if(goods[k].getName().equals(y))
				 * alljf+=goods[k].getPrice();
				 * 
				 * System.out.println("金额总计："+alljf); double jf=discount.disCount(alljf);
				 * System.out.println("实际付款"+jf); System.out.println("实际交费：");
				 * 
				 * double fee=scanner.nextDouble(); System.out.println("找钱："+(fee-jf));
				 * System.out.println("本次购物所获得的积分是："+jf/100);
				 * 
				 * }
				 */
				
				showDiscounts(count);
				
				return ;
			}else {
				System.out.println("该会员不存在!请重新输入!");
			}
		}
	}
	/**
	 * 显示消费清单
	 * 输入实际交费金额
	   计算找零以及积分
	 */
	public void showDiscounts(int count) {
		//金额总计
		double sumPrice = 0;
		//折旧
		double discountPrice = 0;
		
		System.out.println(count);
		System.out.println("******************消费清单*************************");
		System.out.println("物品\t\t单价\t\t个数\t\t金额");
		
		/**
		 * 计算出总的金额，但这个金额没有折扣
		 */
		for(int i = 0; i < count; i ++) {
			
			for(int j = 0; j < goods.length; j ++) {
				if(goods[j].getId().equals(payCar[i].id)){
					double account = goods[j].getPrice() * payCar[i].num;
					
					System.out.println(goods[j].getName() + "\t" + goods[j].getPrice() + "\t\t" + payCar[i].num + "\t\t" + account);
					
					sumPrice += account;
				
					break;
				}
			}

		}
		//得到折扣后的金额
		sumPrice = parManager.calcPrice(sumPrice);
		discountPrice = parManager.disCount(sumPrice);
		
		System.out.println("折旧" + discountPrice);
		System.out.println("金额总计" + sumPrice);
		
		double customerPay = 0;
		while(true) {
			System.out.print("实际交费:");
			customerPay += scanner.nextDouble();
			
			//给的钱数可能小于金额总计
			if(customerPay >= sumPrice) {
				System.out.println("找钱" + (customerPay - sumPrice));
				
				/**
				 * ptt4上没有积分怎么算的。。。我想想就一块钱一积分吧。
				 */
				int score = (int)sumPrice;
				System.out.println("本次购物所获的积分是:" + score);
				
				//修改会员积会
				for(int i = 0; i < customerDate.count; i ++) {
					if(customerDate.customs[i].getVip().equals(x)) {
						customerDate.customs[i].setScore(customerDate.customs[i].getScore() + score);
					}
				}
				
				while(true) {
					System.out.println("请按n返回上一级");
					
					String choice = scanner.next();
					
					if("n".equals(choice))
						return ;
					
				}
			}else {
				System.out.println("你给的钱太少了!再加点钱!");
			}
		}
	}
}