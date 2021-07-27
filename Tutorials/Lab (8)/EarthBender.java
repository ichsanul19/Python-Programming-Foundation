
public class EarthBender implements Bender {
    
	int damage;
	String bender;

    public EarthBender(String bender, int damage){
        this.bender = bender;
        this.damage = damage;
    }
    
    public String getBender() {
    	return bender;
    }
    public void setBender(String bender) {
    	this.bender = bender;
    }
    public int getdamage() {
    	return damage;
    	
    }
    public void setdamage(int damage) {
    	this.damage = damage;
    }
    
}