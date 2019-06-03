package ShopManagementSystem.view;

/**
 * view 是视图。。。
 * 代表这个层是视图层
 * 他是在ShopManagementSystem包下的view包下的
 * @author 零
 *
 */
public class Menu {
	/**
	 * 显示用户数据界面
	 */
	public void showCustomFind() {
        System.out.println("会员号\t\t生日\t\t积分");

        for(int i = 0; i < 24; i ++){
            if(i % 8 == 0 && i != 0)
                System.out.print("|");
            else
                System.out.print("-");
        }
        System.out.println();
    }
	public void showLoginMenu() {
		System.out.println("          欢迎使用我行我素购物管理系统1.0版          ");
		System.out.println("·········································");
		System.out.println("          1.登录系统          ");
		System.out.println("          2.更改管理员密码          ");
		System.out.println("          3.退出          ");
		System.out.println("·········································");
		System.out.println("请选择，输入数字：");
	}

	public void showMainMenu() {
		System.out.println("          欢迎使用我行我素购物管理系统1.0版          ");
		System.out.println("·········································");
		System.out.println("          1.客户信息管理          ");
		System.out.println("          2.购物结算         ");
		System.out.println("          3.真情回馈          ");
		System.out.println("          4.注销          ");
		System.out.println("·········································");
		System.out.println("请选择，输入数字：");

	}

	public void showCustMMenu() {

		System.out.println("·········································");
		System.out.println("          1.显示所有客户信息          ");
		System.out.println("          2.添加客户信息          ");
		System.out.println("          3.修改客户信息          ");
		System.out.println("          4.查询客户信息          ");
		System.out.println("·········································");
		System.out.println("请选择，输入数字或按o返回上一级菜单：");

	}

	public void showSendGMenu() {
		System.out.println("          我行我素购物管理系统>真情回馈          ");
		System.out.println("·········································");
		System.out.println("          1.幸运大放送          ");
		System.out.println("          2.幸运抽奖          ");
		System.out.println("          3.生日问候          ");

		System.out.println("·········································");
		System.out.println("请选择，输入数字或按‘n’返回上一级菜单：");
	}

}
