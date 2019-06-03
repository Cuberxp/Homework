package ShopManagementSystem;

public class Custom {
	String vip;
	String birth;
	int score;

	Custom() {

	}

	Custom(String vip, String birth, int score) {
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

}
