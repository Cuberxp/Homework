package ShopManagementSystem.domain;

/**
 * domain 
 * 存放所有的简单bean对象
 * 他是在ShopManagementSystem包下的domain包下的
 *  会员类
 * @author 零
 *
 */
public class Custom {
	/**
	 * 应该对其封装成员变量
	 */
	private String vip;
	private String birth;
	private int score;

	public Custom() {}

	public Custom(String vip, String birth, int score) {
		this.vip = vip;
		this.birth = birth;
		this.score = score;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Custom [vip=" + vip + ", birth=" + birth + ", score=" + score + "]";
	}
	
}
