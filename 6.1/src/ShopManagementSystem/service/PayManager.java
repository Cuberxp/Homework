package ShopManagementSystem.service;

/**
 * ҵ���߼�����㡣
 * �����������
 * ������ShopManagementSystem���µ�service���µ�
 * @author ��
 *
 */
public class PayManager {
	/**
	 * �����ۿ�
	 * @param price
	 * @return
	 */
	public double disCount(double  price){
		/**
		 * �ǳ���1000 ����mod 1000��23 mod 1000����0 == 23
		 *		switch((int)(price / 1000)){
			case 0:discount=0.95;break;
			case 1: discount=0.9;break;
			case 2: discount=0.85;break;
			case 3:case 4: discount=0.8;break;
			case 5: discount=0.75;break;
			case 6:
			case 7: discount=0.7;break;
				default:discount=0.6;
		}
		
		������жϣ���дΪ����
		
		ֻ��[0-8000)�ڵĻ�����Ч,������ֱ��0.6��
		 */
		double disCounts[] = {0.95,0.9,0.85,0.8,0.75,0.75,0.7,0.7};
		
		return price < 8000 ? disCounts[(int)(price / 1000)] : 0.6;
	}
	
	/**
	 * ����ʵ�ʽ���
	 * @param price ����ܼ�
	 * @return
	 */
	public double calcPrice(double price) {
		return disCount(price) * price;
	}
	
}
