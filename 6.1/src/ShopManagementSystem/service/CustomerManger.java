package ShopManagementSystem.service;

import java.util.Scanner;

import ShopManagementSystem.Date;
import ShopManagementSystem.domain.Custom;
import ShopManagementSystem.view.Menu;

/**
 * 业务逻辑处理层。
 * 处理各种需求
 * 像add
 * update啊
 * @author 零
 *他是在ShopManagementSystem包下的service包下的
 */
public class CustomerManger {
	Menu menu = new Menu();
	Custom custom = new Custom();
	Date date=Date.getDate();

	public void customerManger() {
		System.out.println("我行我素购物管理系统》客户信息管理》显示客户信息");
		System.out
				.println("会员号                             生日                                      积分");
		System.out.println("-----------------------------------------------");
		date.f();
		/*4子界面：修改客户信息 中写了返加上一级所以可以不写了。
		 * System.out.println("请按‘n’返回上一级菜单："); Scanner scanner = new
		 * Scanner(System.in); String n = scanner.next(); if (n.equals(n))
		 * menu.showCustMMenu();
		 */
	}

	public void addCustomer() {// 增加用户
		Scanner s = new Scanner(System.in);
		System.out.println("我行我素购物管理系统》客户信息管理》添加客户信息");
		System.out.println("请输入会员号（4位整数）：");
		String number = s.next();
		System.out.println("请输入会员生日（月/日<用两位数表示>）");
		String data = s.next();
		System.out.println("请输入积分：");
		int score = s.nextInt();
		Custom cs = new Custom(number, data, score);
		date.customs[date.count++] = cs;
		System.out.println(cs);

		if (date.count < date.customs.length)
			System.out.println("用户添加成功！！！");
		System.out.println(date);
		/*4子界面：添加客户信息 中写了返加上一级所以可以不写了。
		 * System.out.println("请选择，输入数字或按‘n’返回上一级菜单："); String m = s.next(); if
		 * (m.equals("n")) { menu.showCustMMenu(); System.out.println(date); }
		 */
	}

	public void reviseCustomer() {// revise代表修改；
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入会员号");
		String vip = scanner.next();
		System.out.println("会员号                             生日                                      积分");
		System.out.println("-----------------------------------------------");
		int i;
		for (i = 0; i < date.count; i++)
			if (vip.equals(date.customs[i].getVip())) {
				System.out.println(date.customs[i].getVip() + "\t"
						+ date.customs[i].getBirth() + "\t"
						+ date.customs[i].getScore() + "\t");
				break;
			}
		/**
		 * 如果没有该会员号，后面的修改功能应该不能值行了。
		 */
		if (i == date.count) {
			System.out.println("没有此会员号，请先添加");
			
			return ;
		}
		
		System.out.println("**********************************");
		System.out.println("                            1.修改会员生日");
		System.out.println("                            2.修改会员积分");
		System.out.println("**********************************");
		System.out.println("请选择，输入数字：");
		int number = scanner.nextInt();
		if (number == 1) {
			System.out.println("请输入修改后的生日：");
			String birth = scanner.next();
			int j = 0;
			for (j = 0; j < date.count; j++)
				if (vip.equals(date.customs[j].getVip())) {
					date.customs[j].setBirth(birth);
					break;
				}
			if (j <date.count)
				System.out.println("生日信息已修改成功！！");
			/*4子界面：修改客户信息  中写了返加上一级所以可以不写了。
			 * System.out.println("请按”n“ 返回上一级菜单"); String m = scanner.next(); if
			 * (m.equals("n")) menu.showCustMMenu();
			 */
		} else if (number == 2) {
//		System.out.println("请选择，输入数字：");
//			int score = scanner.nextInt();
			
				System.out.println("请输入修改后的积分：");
				int jf = scanner.nextInt();// 积分；
				int j = 0;
				for (j = 0; j < date.count; j++)
					if (vip.equals(date.customs[j].getVip())) {
						date.customs[j].setScore(jf);
						break;
					}
				if (j < date.count)
					System.out.println("积分信息已修改成功！！！");
				/*4子界面：修改客户信息  中写了返加上一级所以可以不写了。
				 * System.out.println("请按”n“ 返回上一级菜单"); String m = scanner.next(); if
				 * (m.equals("n")) menu.showCustMMenu();
				 */

			
		}
	}
	
	/**
	 * 查询单个用户的信息。。。
	 * @param vip
	 * @return Custom类。。。
	 */
	public Custom findCustomer(String vip) {
		for(int i = 0; i < date.count; i ++) {
			if(date.customs[i].getVip().equals(vip)) {
				return date.customs[i];
			}
		}
		
		return null;
	}
}
