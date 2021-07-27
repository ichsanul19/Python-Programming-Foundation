import java.util.*;

public class Student {
	private ArrayList<Course> courses = new ArrayList<>();
	private String name;
	private int strength;
	private static int totalStudyTime = 0;
	private static int numOfStudents = 0;

	public Student(String name, int strength) {
		this.name = name;
		this.strength = strength;
		numOfStudents ++; //Menambah jumlah student saat Class Student(constructor) dimulai
		
	}
	
	//Menambah Course ke list courses  
	public void addCourse(Course course) {
		//Setiap student addCourse, totalStudyTime bertambah sesuai rumus
		totalStudyTime += this.strength * course.getSks() + course.getDifficulty();
		this.courses.add(course);
	}
	
	//Print introduction tiap Student
	public void printIntroduction() {
		System.out.println(this.name + " memiliki kekuatan sebesar " + this.strength);
	}
	
	
	public void printCourses() {
		System.out.println("Matkul yang di ambil oleh " + this.name + " adalah:");
		for (int i=0; i < courses.size(); i++) {
			System.out.println((i+1) + ". " +courses.get(i).getName() + 
					" -- " + courses.get(i).getSks() + " sks" +
					" -- " + courses.get(i).getDifficulty() + " -- ");
		}
		// Print data course yang diambil mahasiswa sesuai format
	}
	
	public void printStudyTime() {
		System.out.println("Total waktu belajar " + this.name +
				" adalah " + this.calculateStudyTime() + " jam");
		// Print total waktu belajar sesuai format
	}

	public int calculateStudyTime() {
		int totalJam = 0;
		for (int i = 0; i < this.courses.size(); i++) {
			totalJam += this.strength * courses.get(i).getSks() + courses.get(i).getDifficulty();
		}
		return totalJam;
		//Return totalJam tiap siswa
		//(Kekuatan belajar)*(Banyak SKS)+(Tingkat kesulitan matkul)
	}

	public static int getTotalStudyTime() {
		return totalStudyTime;
		// Method akan mengembalikan total waktu belajar seluruh mahasiswa
	}

	public static int getNumOfStudents() {
		return numOfStudents;
		// Method akan mengembalikan banyaknya mahasiswa
	}

	public static double calculateAverageStudyTime() {
		return (double)getTotalStudyTime() / getNumOfStudents();
		// Method akan mengembalikan rata-rata waktu belajar seluruh mahasiswa
	}
}