package Lab07_Jumat;

public class BikiniBottomTruckSimulator {

	public static void main(String args[]) {
		System.out.println("Simulator Truk ke Kota Bikini Bottom");

		SmallTruck s1 = new SmallTruck("SS-BikiniBottom-01", 100, 10);
		s1.loadDonut(30);
		s1.loadDonut(75);
		s1.loadDonut(70);
		s1.arrive();
		s1.depart(1001);
		s1.depart(1000);
		s1.playMusic();
		s1.doLaugh();
		s1.doHorn();
		s1.unloadDonut();
		s1.arrive();
		s1.unloadDonut();

		System.out.println("-------------------------------------------");

		MediumTruck m1 = new MediumTruck("SS-BikiniBottom-02", 150, 10);
		m1.loadDonut(30);
		m1.loadDonut(75);
		m1.depart(749);
		m1.depart(500);
		m1.doTelolet();
		m1.doLaugh();
		m1.doHorn();
		m1.arrive();
		m1.unloadDonut();

		System.out.println("-------------------------------------------");

        BigTruck b1 = new BigTruck("SS-BikiniBottom-03", 400, 10);
        b1.loadDonut(1);
        b1.depart(500);
        b1.watchTV();
        b1.doLaugh();
        b1.doHorn();
        b1.arrive();
        b1.unloadDonut();
	}
}