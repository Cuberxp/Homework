package ShopManagementSystem.service;

/**
 * 业务逻辑处理层。
 * 处理各种需求
 * 他是在ShopManagementSystem包下的service包下的
 * @author 零
 *
 */
public class PayManager {
	/**
	 * 返回折扣
	 * @param price
	 * @return
	 */
	public double disCount(double  price){
		/**
		 * 是除以1000 不是mod 1000，23 mod 1000不等0 == 23
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
		
		上面的判断，改写为下面
		
		只有[0-8000)内的积分有效,超过就直接0.6了
		 */
		double disCounts[] = {0.95,0.9,0.85,0.8,0.75,0.75,0.7,0.7};
		
		return price < 8000 ? disCounts[(int)(price / 1000)] : 0.6;
	}
	
	/**
	 * 返回实际交费
	 * @param price 金额总计
	 * @return
	 */
	public double calcPrice(double price) {
		return disCount(price) * price;
	}
	
}
