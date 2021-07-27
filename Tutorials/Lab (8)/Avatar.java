import java.util.ArrayList;

public class Avatar implements Comparable<Avatar>{
    private String name;
    private String temple;
    private int health;
    private int totalDamage;
    private ArrayList<Bender> listBender;
    
    public Avatar(String name, String temple, int health){
       this.name = name;
       this.temple = temple;
       this.health = health;
       listBender = new ArrayList<>();
    }

    public void fight(Avatar otherAvatar) throws CanNotAttackException, SuccessAttackException{
        if(this.health <= 0) {
            System.out.println("Nyawa dari Avatar " + this.getName() + " sudah habis, tidak bisa melakukan pertarungan!");
            throw new CanNotAttackException();
        } else {
            otherAvatar.health -= this.totalDamage;
            if (otherAvatar.health <= 0) {
                System.out.println("Nyawa dari Avatar " + otherAvatar.getName() + " sudah habis, tidak bisa melakukan pertarungan!");
				otherAvatar.health = 0;
                throw new CanNotAttackException();
            }
            else {
                System.out.println("Avatar " + this.name + " berhasil menyerang " + otherAvatar.name);
                throw new SuccessAttackException();
                
            }
        }
        
                //TODO: masukkan kondisi-kondisi yang mungkin dan throw exception yang sesuai
    }

    public void addBender(String bender, int damage){
        try {
            checkBenderTypeWithException(bender);
            //TODO: jalankan method yang akan menimbulkan error sehingga dapat ke catch ke exception yang diinginkan
        } 
        catch (AirBenderException ex) { 
            Bender airBender = new AirBender(bender, damage);
            listBender.add(airBender);
        } 
        catch (WaterBenderException ex) { 
            Bender waterBender = new WaterBender(bender, damage);
            listBender.add(waterBender);
        }
        catch (EarthBenderException ex) { 
            Bender earthBender = new EarthBender(bender, damage);
            listBender.add(earthBender);
        }
        finally {
            addTotalDamage(damage);
            System.out.println("Avatar " + this.getName() + " menguasai bender " + bender);
        }
        //TODO: catch..
    }

    public void checkBenderTypeWithException(String bender) throws AirBenderException,WaterBenderException,EarthBenderException{
        if(bender.equals("Air")) {
            throw new AirBenderException();
        } else if(bender.equals("Water")) {
            throw new WaterBenderException();
        } else if(bender.equals("Earth")) {
            throw new EarthBenderException();
        }
    }
     
    public void addTotalDamage(int amountAdded){
        totalDamage += amountAdded;
        
    }
    
    public int compareTo(Avatar other){
        return other.health - this.health;
    }

    //TODO: tambahkan setter getter jika dibutuhkan
    
    public String getName() {
        return this.name;
    }

    public String getTemple() {
        return this.temple;
    }

    public int getHealth() {
        return this.health;
    }

    public int getdamage() {
        return this.totalDamage;
    }
}
class AirBenderException extends Exception {
    AirBenderException() {
        super();
    }
}

class WaterBenderException extends Exception {
    WaterBenderException() {
        super();
    }
    //TODO
}

class EarthBenderException extends Exception {
    EarthBenderException() {
        super();
    }
}

