//package ShopManagementSystem;
//
//import java.util.Scanner;
//
//public class Date {
//	Custom customs[]=new Custom[10];
//	public int count=0;
//	Menu menu=new Menu();
//	
//	void f(){//显示现有的会员
//	Custom cs=new Custom("1900","08/05",2000);
//	customs[count++]=cs;
//	System.out.println("会员号                     生日                                  积分	");
//	System.out.println("-------------------------------------------");
//	System.out.println(customs[count-1].vip+"                  "+customs[count-1].birth+"                   "+customs[count-1].score+"    ");
//	Custom cs1=new Custom("1711","07/13",4000);
//	customs[count++]=cs1;
//	System.out.println(customs[count-1].vip+"                  "+customs[count-1].birth+"                  "+customs[count-1].score+"    ");
//	Custom cs2=new Custom("1623","06/26",5000);
//	customs[count++]=cs2;
//	System.out.println(cs2.vip+"                  "+customs[count-1].birth+"                  "+customs[count-1].score+"    ");
//	Custom cs3=new Custom("1545","04/08",2200);
//	customs[count++]=cs3;
//	System.out.println(customs[count-1].vip+"                  "+customs[count-1].birth+"                    "+customs[count-1].score+"    ");
//	Custom cs4=new Custom("1464","08/16",1000);
//	customs[count++]=cs4;
//	System.out.println(customs[count-1].vip+"                  "+customs[count-1].birth+"                   "+customs[count-1].score+"    ");
//}

package ShopManagementSystem;

import ShopManagementSystem.domain.Custom;
import ShopManagementSystem.view.Menu;

public class Date {
	private static Date date = new Date();;
	public int count = 0;
	public Custom[] customs = new Custom[10];

	Menu menu = new Menu();

	{
		Custom cs = new Custom("1900", "08/05", 2000);
		customs[count++] = cs;

		Custom cs1 = new Custom("1711", "07/13", 4000);
		customs[count++] = cs1;

		Custom cs2 = new Custom("1623", "06/26", 5000);
		customs[count++] = cs2;

		Custom cs3 = new Custom("1545", "04/08", 2200);
		customs[count++] = cs3;

		Custom cs4 = new Custom("1464", "08/16", 1000);
		customs[count++] = cs4;

	}

	private Date() {}

	public static Date getDate() {

		return date;
	}

	public void f() {// 显示现有的会员
		for (int i = 0; i < count; i++)
			System.out.println(customs[i].getVip() + "\t" + customs[i].getBirth()
					+ "\t" + customs[i].getScore() + "\t");
	}

}
