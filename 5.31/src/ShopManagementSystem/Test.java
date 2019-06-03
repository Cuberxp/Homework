package ShopManagementSystem;

import java.util.Scanner;

public class Test {
	public static Scanner sr = new Scanner(System.in);
	
	public static Menu menu = new Menu();
	
	public Date date = Date.getDate();
	
	//方便在main方法调用loginSystem方法
	public static Test test = new Test();
	
	public static CustomerManger customerManager = new CustomerManger();
	
	/**
	 * 如果还有要 添加的类啊功能啊。 可以在这些方法的基础上新建新的方法。。。。
	 * 
	 * @param args
	 */
	
	/**
	 * 0主界面
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
                    System.out.println("输入错误！请重新输入!");
            }
        }
	}
	

    /**
     * 1.1子界面:登陆
     */
    public  void loginSystem() {
    	int count = 0;
    	
        while(true){
        	//当从他下一层 (2子界面：主要业务操作)选4.注销,退回到这个1.1子界面来时，应该到0子界面，而不应该是1.1这个方法上来，
        	//所以他要返回到上一层。选择退出系统还是什么。
        	
        	if(count++ != 0) {
        		return ;
        	}
        	
            boolean flag = false;

            for(int i = 0; i <  3; i ++){
                System.out.println("请输入用户名：");
                String username = sr.next();

                System.out.println("请输入密码：");
                String password = sr.next();

                if("manger".equals(username) && "0000".equals(password)){
                    flag = true;

                    break;
                }
                
                System.out.println("账户或密码错误，请重新输入！");
            
           }

            //登陆成功,进入2子界面：主要业务操作
            if(flag){
            	test.MainMenu();
            }else{
                System.out.println("您的密码已经输错三次,请明天再试");
                System.exit(0);
            }
        }
    }

    /**
     * 1.2子界面：修改账户密码
     * 进度：未完成
     */
    public void updateAccoutnPassword() {
        while(true){
            System.out.println("当前功能未完成，请等待更新! 输入n返回上一级!");

            String choice = sr.next();

            if("n".equals(choice))
                return ;
        }
    }

    /**
     * 2.1子界面：主要业务操作
     */
    public void MainMenu() {
        while(true){
            menu.showMainMenu();

            int choice = sr.next().charAt(0);

            switch (choice - 48){
                case 1: customerManager(); break;
                //下面功能未实现，跳转到未实现功能界面
                case 2: updateAccoutnPassword(); break;
                case 3: updateAccoutnPassword(); break;
                case 4: return ;//注销系统
                default:
                    System.out.println("输入错误！请重新输入!");
            }
        }

    }

    /**
     * 3.1子界面:客户信息管理
     */
    public void customerManager() {
        while(true){
            menu.showCustMMenu();

            int choice = sr.next().charAt(0);

            //返回上一级
            if(choice == 'n')
                return ;

            switch (choice - 48){
                case 1: showCustomers(); break;
                case 2: addCustomer(); break;
                case 3: updateCustomer(); break;
                case 4: findCustomer(); break;

                default:
                    System.out.println("输入错误!重新输入!");
            }
        }
    }

    /**
     * 4.1子界面：显示所有客户信息
     */
    public void showCustomers() {
        menu.showCustomFind();
        date.f();

        if(choiceN())
            return ;
    }

    /**
     * 4.2子界面：添加客户信息
     */
    public void addCustomer() {
        //把增加逻辑交给service层处理
        customerManager.addCustomer();
        
        if(choiceN())
            return ;
    }

    /**
     * 4.3子界面：修改客户信息
     */
    public void updateCustomer() {

        while(true){
           customerManager.reviseCustomer();
           
           break;
        }
        
        if(choiceN())
            return ;
    }
    /**
     * 4.4子界面：查询客户信息
     */
    public void findCustomer() {
        while(true){
            System.out.println("请输入会员号:");
            String vip = sr.next();
            
            Custom customer = customerManager.findCustomer(vip);

            if(customer != null){
                menu.showCustomFind();
                System.out.println(customer.getVip() + "\t" + customer.getBirth() + "\t" + customer.getScore());
                System.out.println("要继续查询吗?（y/n）");

                String choice = sr.next();
                if("n".equals(choice)){
                    System.out.println("返回上一级");

                    return ;
                }
            }else {
                System.out.println("输入错误！没有该用户");
            }
        }
    }

    /**
     * 抽取重复代码 方法功能按n返回到上一级
     */
    public boolean choiceN(){
        while(true){
            System.out.println("请选择，输入数字或按n返回上一级菜单：");

            String choice = sr.next();

            //返回上一级
            if("n".equals(choice))
                return true;
        }
    }
}
