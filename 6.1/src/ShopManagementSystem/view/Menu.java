package ShopManagementSystem.view;

/**
 * view ����ͼ������
 * �������������ͼ��
 * ������ShopManagementSystem���µ�view���µ�
 * @author ��
 *
 */
public class Menu {
	/**
	 * ��ʾ�û����ݽ���
	 */
	public void showCustomFind() {
        System.out.println("��Ա��\t\t����\t\t����");

        for(int i = 0; i < 24; i ++){
            if(i % 8 == 0 && i != 0)
                System.out.print("|");
            else
                System.out.print("-");
        }
        System.out.println();
    }
	public void showLoginMenu() {
		System.out.println("          ��ӭʹ���������ع������ϵͳ1.0��          ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("          1.��¼ϵͳ          ");
		System.out.println("          2.���Ĺ���Ա����          ");
		System.out.println("          3.�˳�          ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("��ѡ���������֣�");
	}

	public void showMainMenu() {
		System.out.println("          ��ӭʹ���������ع������ϵͳ1.0��          ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("          1.�ͻ���Ϣ����          ");
		System.out.println("          2.�������         ");
		System.out.println("          3.�������          ");
		System.out.println("          4.ע��          ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("��ѡ���������֣�");

	}

	public void showCustMMenu() {

		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("          1.��ʾ���пͻ���Ϣ          ");
		System.out.println("          2.��ӿͻ���Ϣ          ");
		System.out.println("          3.�޸Ŀͻ���Ϣ          ");
		System.out.println("          4.��ѯ�ͻ���Ϣ          ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("��ѡ���������ֻ�o������һ���˵���");

	}

	public void showSendGMenu() {
		System.out.println("          �������ع������ϵͳ>�������          ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("          1.���˴����          ");
		System.out.println("          2.���˳齱          ");
		System.out.println("          3.�����ʺ�          ");

		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("��ѡ���������ֻ򰴡�n��������һ���˵���");
	}

}
