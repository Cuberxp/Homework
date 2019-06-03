package ShopManagementSystem.domain;

/**
 * domain 
 * ������еļ�bean����
 * ������ShopManagementSystem���µ�domain���µ�
 *  ��Ա��
 * @author ��
 *
 */
public class Custom {
	/**
	 * Ӧ�ö����װ��Ա����
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
