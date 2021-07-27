import java.util.*;

public class Simulator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Masukkan passing grade academy anda: ");
		int passingGrade = scanner.nextInt();

		scanner.close();

		Course ddp2 = new Course("DDP 2",4,3);
		Course psd = new Course("PSD",4,3);
		Course ppsi = new Course("PPSI",3,3);
		Course matdas1 = new Course("Matdas 1",3,2);
		Course matdis2 = new Course("Matdis 2",3,4);
		Course mpkta = new Course("MPKT A",6,1);

		Student dekDepe = new Student("Dek Depe",4);

		dekDepe.addCourse(ddp2);
		dekDepe.addCourse(ppsi);
		dekDepe.addCourse(matdis2);

		dekDepe.printIntroduction();
		dekDepe.printCourses();
		dekDepe.printStudyTime();

		Student pakEsde = new Student("Pak Esde",2);

		pakEsde.addCourse(psd);
		pakEsde.addCourse(mpkta);
		pakEsde.addCourse(matdas1);

		pakEsde.printIntroduction();
		pakEsde.printCourses();
		pakEsde.printStudyTime();

		Student kakPewe = new Student("Kak Pewe",5);

		kakPewe.addCourse(ddp2);
		kakPewe.addCourse(ppsi);
		kakPewe.addCourse(matdis2);
		kakPewe.addCourse(psd);
		kakPewe.addCourse(mpkta);
		kakPewe.addCourse(matdas1);

		kakPewe.printIntroduction();
		kakPewe.printCourses();
		kakPewe.printStudyTime();

		Student pakOka = new Student("Pak Oka", 3);

		pakOka.addCourse(psd);
		pakOka.addCourse(mpkta);
		pakOka.addCourse(ppsi);

		pakOka.printIntroduction();
		pakOka.printCourses();
		pakOka.printStudyTime();

		System.out.println("Total waktu belajar Gang 0000 (jam):");
		System.out.println(Student.getTotalStudyTime());
		//total waktu belajar seluruh anggota Gang 0000

		System.out.println("Rata-rata waktu belajar Gang 0000 (jam):");
		System.out.println(Student.calculateAverageStudyTime());
		//rata-rata waktu belajar seluruh anggota Gang 0000
		
		if (Student.calculateAverageStudyTime() >= passingGrade) {
			System.out.println("Gang 0000 berhasil masuk ke academy anda!");
		}
		else {
			System.out.println("Gang 0000 gagal masuk academy anda :'(");
		}
		//Cek apakah Gang 0000 berhasil masuk ke academy
		
	}
}