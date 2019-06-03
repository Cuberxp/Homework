package ShopManagementSystem;

import java.util.Scanner;

import ShopManagementSystem.domain.Goods;
import ShopManagementSystem.service.PayManager;

//���ﳵ
class PayCar{
	//��Ʒ��ź�����
	String id;
	
	int num;
	
	PayCar(String id,int num){
		this.id = id;
		
		this.num = num;
	}
}

public class Data {
	Scanner scanner=new Scanner(System.in);
	//��Ա��
	String x;
	
	//�û���,�����л�Ա��Ϣ
	Date customerDate = Date.getDate();
	//���ﳵ��
	PayCar[] payCar = new PayCar[500];
	
	Goods []goods=new Goods[10];
	public int count=0;
	PayManager parManager = new PayManager();
	
	//��ʹ����Ʒ�����ʹ��goods�����Ļ������ڳ����ȡ��ʼ���ø÷�������Ȼ��count��ֵ��ԶΪ0����ô�����еĵ�44��for�е���䲻��ִ��
	/**
	 *��ʼ��������������Ĵ���һ��������
		��ʼ��������Ϊ��̬��ʼ������飨��һ��static���ͷǾ�̬��ʼ������飨������һ�������ࡣ
		��ʼ��������������������У�����������У����԰��������ʼ���飬���������ʵ��ʱ���ͻ�����ִ����Щ����顣���ʹ�� static ���γ�ʼ���飬�ͳ�Ϊ��̬��ʼ���顣
		��Щ��ʼ�������������Ĺ��췽�������ã����޲�ʵ����һ����Ķ���ʱ����ȫ�����ô������湹�췽����λ�á�
		�Ǿ�̬��ʼ�������������ڴ�����Ķ���ʱ��˳�����ݴ������Ⱥ����У�����Щ��������Դ�������������Ҳ����˵��ʵ�����������ʱ��������ͷ��β����һ�������г�ʼ������顣
	 */
	{
	   Goods x1=new Goods("1","addidas�˶�Ь",880);
	   goods[count++]=x1;
	   Goods x2=new Goods("2","kappa����Ь",200);
	   goods[count++]=x2;
	   Goods x3=new Goods("3","������",780);
	   goods[count++]=x3;
	   Goods x4=new Goods("4","addidasT����",420.78);
	   goods[count++]=x4;
	   Goods x5=new Goods("5","nice�˶�Ь",900);
	   goods[count++]=x5;
	   Goods x6=new Goods("6","kappa����",45);
	   goods[count++]=x6;
	   Goods x7=new Goods("7","KappaT��",245);
	   goods[count++]=x7;
	}
	
	public void information(){//��ʾ������Ϣ��
		double alljf=0;//�ܻ��֣�
		
//		int x=scanner.nextInt();
		
		System.out.println("****************************");
		System.out.println("��ѡ�������Ʒ��ţ�");
		System.out.println("��Ʒ���\t\t��Ʒ����\t\t��Ʒ�۸�");
		
		//Ӧ��Ҫ��������Ʒ��Ϣ������ٴ���ɡ�
		for(int i=0;i<count;i++){
			System.out.println(goods[i].getId()+"\t"+goods[i].getName()+"\t"+goods[i].getPrice());
		}	
		
		customerChooseGoods();
		
		return ;
	}
	
	/**
	 * �˿�ѡ����Ʒ
	 */
	public void customerChooseGoods() {

		while(true) {
			//�ж�����Ļ�Ա���ڲ���customerDate������
			System.out.println("*******************************");
			System.out.println("�������Ա�ţ�");
			//����һ��ȫ�ֱ�����������showDiscounts�е��á�
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
				 * �˿�ѡ�����Ʒ���빺�ﳵ����
				 */
				while(true) {
					System.out.println("��������Ʒ��ţ�");
					String y=scanner.next();
					
					System.out.println("��������Ʒ������");
					
					int z=scanner.nextInt();
					
					payCar[count++] = new PayCar(y,z); 
					
					System.out.println("�Ƿ������y/n��");
					String choice = scanner.next();
			        if("n".equals(choice))
			        	break;
				}
				/*
				 * for(int k = 0;k < count;k ++){ if(goods[k].getName().equals(y))
				 * alljf+=goods[k].getPrice();
				 * 
				 * System.out.println("����ܼƣ�"+alljf); double jf=discount.disCount(alljf);
				 * System.out.println("ʵ�ʸ���"+jf); System.out.println("ʵ�ʽ��ѣ�");
				 * 
				 * double fee=scanner.nextDouble(); System.out.println("��Ǯ��"+(fee-jf));
				 * System.out.println("���ι�������õĻ����ǣ�"+jf/100);
				 * 
				 * }
				 */
				
				showDiscounts(count);
				
				return ;
			}else {
				System.out.println("�û�Ա������!����������!");
			}
		}
	}
	/**
	 * ��ʾ�����嵥
	 * ����ʵ�ʽ��ѽ��
	   ���������Լ�����
	 */
	public void showDiscounts(int count) {
		//����ܼ�
		double sumPrice = 0;
		//�۾�
		double discountPrice = 0;
		
		System.out.println(count);
		System.out.println("******************�����嵥*************************");
		System.out.println("��Ʒ\t\t����\t\t����\t\t���");
		
		/**
		 * ������ܵĽ���������û���ۿ�
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
		//�õ��ۿۺ�Ľ��
		sumPrice = parManager.calcPrice(sumPrice);
		discountPrice = parManager.disCount(sumPrice);
		
		System.out.println("�۾�" + discountPrice);
		System.out.println("����ܼ�" + sumPrice);
		
		double customerPay = 0;
		while(true) {
			System.out.print("ʵ�ʽ���:");
			customerPay += scanner.nextDouble();
			
			//����Ǯ������С�ڽ���ܼ�
			if(customerPay >= sumPrice) {
				System.out.println("��Ǯ" + (customerPay - sumPrice));
				
				/**
				 * ptt4��û�л�����ô��ġ������������һ��Ǯһ���ְɡ�
				 */
				int score = (int)sumPrice;
				System.out.println("���ι�������Ļ�����:" + score);
				
				//�޸Ļ�Ա����
				for(int i = 0; i < customerDate.count; i ++) {
					if(customerDate.customs[i].getVip().equals(x)) {
						customerDate.customs[i].setScore(customerDate.customs[i].getScore() + score);
					}
				}
				
				while(true) {
					System.out.println("�밴n������һ��");
					
					String choice = scanner.next();
					
					if("n".equals(choice))
						return ;
					
				}
			}else {
				System.out.println("�����Ǯ̫����!�ټӵ�Ǯ!");
			}
		}
	}
}