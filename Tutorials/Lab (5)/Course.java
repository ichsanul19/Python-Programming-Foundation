public class Course {
	private String name;
	private int sks;
	private int difficulty;

	public Course(String name, int sks, int difficulty) {
		this.name = name;
		this.sks = sks;
		this.difficulty = difficulty;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSks() {
		return this.sks;
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}
	/**
		TO DO
		Lengkapi dengan constructor,
		dan method setter getter apabila diperlukan.
	*/
}