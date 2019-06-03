package ShopManagementSystem.service;

import java.util.Scanner;

import ShopManagementSystem.Date;
import ShopManagementSystem.domain.Custom;
import ShopManagementSystem.view.Menu;

/**
 * ҵ���߼�����㡣
 * �����������
 * ��add
 * update��
 * @author ��
 *������ShopManagementSystem���µ�service���µ�
 */
public class CustomerManger {
	Menu menu = new Menu();
	Custom custom = new Custom();
	Date date=Date.getDate();

	public void customerManger() {
		System.out.println("�������ع������ϵͳ���ͻ���Ϣ������ʾ�ͻ���Ϣ");
		System.out
				.println("��Ա��                             ����                                      ����");
		System.out.println("-----------------------------------------------");
		date.f();
		/*4�ӽ��棺�޸Ŀͻ���Ϣ ��д�˷�����һ�����Կ��Բ�д�ˡ�
		 * System.out.println("�밴��n��������һ���˵���"); Scanner scanner = new
		 * Scanner(System.in); String n = scanner.next(); if (n.equals(n))
		 * menu.showCustMMenu();
		 */
	}

	public void addCustomer() {// �����û�
		Scanner s = new Scanner(System.in);
		System.out.println("�������ع������ϵͳ���ͻ���Ϣ������ӿͻ���Ϣ");
		System.out.println("�������Ա�ţ�4λ��������");
		String number = s.next();
		System.out.println("�������Ա���գ���/��<����λ����ʾ>��");
		String data = s.next();
		System.out.println("��������֣�");
		int score = s.nextInt();
		Custom cs = new Custom(number, data, score);
		date.customs[date.count++] = cs;
		System.out.println(cs);

		if (date.count < date.customs.length)
			System.out.println("�û���ӳɹ�������");
		System.out.println(date);
		/*4�ӽ��棺��ӿͻ���Ϣ ��д�˷�����һ�����Կ��Բ�д�ˡ�
		 * System.out.println("��ѡ���������ֻ򰴡�n��������һ���˵���"); String m = s.next(); if
		 * (m.equals("n")) { menu.showCustMMenu(); System.out.println(date); }
		 */
	}

	public void reviseCustomer() {// revise�����޸ģ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������Ա��");
		String vip = scanner.next();
		System.out.println("��Ա��                             ����                                      ����");
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
		 * ���û�иû�Ա�ţ�������޸Ĺ���Ӧ�ò���ֵ���ˡ�
		 */
		if (i == date.count) {
			System.out.println("û�д˻�Ա�ţ��������");
			
			return ;
		}
		
		System.out.println("**********************************");
		System.out.println("                            1.�޸Ļ�Ա����");
		System.out.println("                            2.�޸Ļ�Ա����");
		System.out.println("**********************************");
		System.out.println("��ѡ���������֣�");
		int number = scanner.nextInt();
		if (number == 1) {
			System.out.println("�������޸ĺ�����գ�");
			String birth = scanner.next();
			int j = 0;
			for (j = 0; j < date.count; j++)
				if (vip.equals(date.customs[j].getVip())) {
					date.customs[j].setBirth(birth);
					break;
				}
			if (j <date.count)
				System.out.println("������Ϣ���޸ĳɹ�����");
			/*4�ӽ��棺�޸Ŀͻ���Ϣ  ��д�˷�����һ�����Կ��Բ�д�ˡ�
			 * System.out.println("�밴��n�� ������һ���˵�"); String m = scanner.next(); if
			 * (m.equals("n")) menu.showCustMMenu();
			 */
		} else if (number == 2) {
//		System.out.println("��ѡ���������֣�");
//			int score = scanner.nextInt();
			
				System.out.println("�������޸ĺ�Ļ��֣�");
				int jf = scanner.nextInt();// ���֣�
				int j = 0;
				for (j = 0; j < date.count; j++)
					if (vip.equals(date.customs[j].getVip())) {
						date.customs[j].setScore(jf);
						break;
					}
				if (j < date.count)
					System.out.println("������Ϣ���޸ĳɹ�������");
				/*4�ӽ��棺�޸Ŀͻ���Ϣ  ��д�˷�����һ�����Կ��Բ�д�ˡ�
				 * System.out.println("�밴��n�� ������һ���˵�"); String m = scanner.next(); if
				 * (m.equals("n")) menu.showCustMMenu();
				 */

			
		}
	}
	
	/**
	 * ��ѯ�����û�����Ϣ������
	 * @param vip
	 * @return Custom�ࡣ����
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
