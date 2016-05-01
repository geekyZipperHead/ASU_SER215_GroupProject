package ConnectFourProject;


public class Player {
	
	String name = "";
	String color = "";
	int score = 0;
	
	Player(String name, String color) {
		super();
		this.name = name;
		this.color = color;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
