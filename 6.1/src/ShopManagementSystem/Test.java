package ShopManagementSystem;

import java.util.Scanner;

import ShopManagementSystem.domain.Custom;
import ShopManagementSystem.service.CustomerManger;
import ShopManagementSystem.view.Menu;

public class Test {
	public static Scanner sr = new Scanner(System.in);
	
	public static Menu menu = new Menu();
	
	public Date date = Date.getDate();
	
	//��Ҫnew һ�������ֹ��ָ��
	public Data data = new Data();
	
	//������main��������loginSystem����
	public static Test test = new Test();
	
	public static CustomerManger customerManager = new CustomerManger();
	
	/**
	 * �������Ҫ ��ӵ��డ���ܰ��� ��������Щ�����Ļ������½��µķ�����������
	 * 
	 */
	
	/**
	 * 0������
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
            menu.showLoginMenu();

            int number = sr.nextInt();

            switch(number){
                case 1: test.loginSystem();break;
                case 2: test.updateAccoutnPassword(); break;
                case 3: System.exit(0);
                default:
                    System.out.println("�����������������!");
            }
        }
	}
	

    /**
     * 1.1�ӽ���:��½
     */
    public  void loginSystem() {
    	int count = 0;
    	
        while(true){
        	//��������һ�� (2�ӽ��棺��Ҫҵ�����)ѡ4.ע��,�˻ص����1.1�ӽ�����ʱ��Ӧ�õ�0�ӽ��棬����Ӧ����1.1�������������
        	//������Ҫ���ص���һ�㡣ѡ���˳�ϵͳ����ʲô��
        	
        	if(count++ != 0) {
        		return ;
        	}
        	
            boolean flag = false;

            for(int i = 0; i <  3; i ++){
                System.out.println("�������û�����");
                String username = sr.next();

                System.out.println("���������룺");
                String password = sr.next();

                if("manger".equals(username) && "0000".equals(password)){
                    flag = true;

                    break;
                }
                
                System.out.println("�˻�������������������룡");
            
           }

            //��½�ɹ�,����2�ӽ��棺��Ҫҵ�����
            if(flag){
            	test.MainMenu();
            }else{
                System.out.println("���������Ѿ��������,����������");
                System.exit(0);
            }
        }
    }

    /**
     * 1.2�ӽ��棺�޸��˻�����
         * ���ȣ�δ���
     */
    public void updateAccoutnPassword() {
        while(true){
            System.out.println("��ǰ����δ��ɣ���ȴ�����! ����n������һ��!");

            String choice = sr.next();

            if("n".equals(choice))
                return ;
        }
    }

    /**
     * 2.1�ӽ��棺��Ҫҵ�����
     */
    public void MainMenu(){
        while(true){
            menu.showMainMenu();
//            System.out.println("��ѡ���������֣�");
//            String x=sr.next();
//            if(x.equals("1")) customerManager();
//              else if(x.equals("2")) data.information();
//            	else if(x.equals("3")) ;
//            	else if(x.equals("4")) ;
			String choices = sr.next();
            int choice = choices.charAt(0);
				
            if(choices.length() == 1)
	            switch (choice - 48){
	                case 1: customerManager(); break;
	                case 2: data.information(); break;
	                //���湦��δʵ�֣���ת��δʵ�ֹ��ܽ���
	                case 3: updateAccoutnPassword(); break;
	                case 4: return ;//ע��ϵͳ
	                default:
	                    System.out.println("�����������������!");
	            }
            else	System.out.println("�����������������!");
        }

}

    /**
     * 3.1�ӽ���:�ͻ���Ϣ����
     */
    public void customerManager() {
        while(true){
            menu.showCustMMenu();

           String choices = sr.next();
           int choice = choices.charAt(0);
           
           if(choices.length() == 1) {
               //������һ��
               if(choice == 'n')
                   return ;

               switch (choice - 48){
                   case 1: showCustomers(); break;
                   case 2: addCustomer(); break;
                   case 3: updateCustomer(); break;
                   case 4: findCustomer(); break;

                   default:
                       System.out.println("�������!��������!");
               }
           }else
        	   System.out.println("�������!��������!");
        }
    }

    /**
     * 4.1�ӽ��棺��ʾ���пͻ���Ϣ
     */
    public void showCustomers() {
        menu.showCustomFind();
        date.f();

        choiceN();
        
        return ;
    }

    /**
     * 4.2�ӽ��棺��ӿͻ���Ϣ
     */
    public void addCustomer() {
        //�������߼�����service�㴦��
        customerManager.addCustomer();
        
        choiceN();
        
        return ;
    }

    /**
     * 4.3�ӽ��棺�޸Ŀͻ���Ϣ
     */
    public void updateCustomer() {

        while(true){
           customerManager.reviseCustomer();
           
           break;
        }
        
        choiceN();
        
        return ;
    }
    /**
     * 4.4�ӽ��棺��ѯ�ͻ���Ϣ
     */
    public void findCustomer() {
        while(true){
            System.out.println("�������Ա��:");
            
            String vip = sr.next();
            
            Custom customer = customerManager.findCustomer(vip);
            
            if(customer != null){
                menu.showCustomFind();
                System.out.println(customer.getVip() + "\t" + customer.getBirth() + "\t" + customer.getScore());
                System.out.println("Ҫ������ѯ��?��y/n��");

                String choice = sr.next();
                if("n".equals(choice)){
                    System.out.println("������һ��");
                    return ;
                }
            }else {
                System.out.println("�������û�и��û�");
            }
        }
    }

    /**
     * ��ȡ�ظ����� �������ܰ�n���ص���һ��
     */
    public boolean choiceN(){
        while(true){
            System.out.println("��ѡ���������ֻ�n������һ���˵���");

            String choice = sr.next();

            //������һ��
            if("n".equals(choice))
                return true;
        }
    }
}
