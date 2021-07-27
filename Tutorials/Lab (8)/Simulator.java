import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        System.out.println("========= Avatar Kingdom =========\n");
        ArrayList<Avatar> listAvatar = readAvatarRequirement("E:/pipit/java/tes/avatarReq.txt");
        AvatarKingdom avaKindom = new AvatarKingdom();
        
        for (Avatar avatar : listAvatar) {
            avaKindom.addAvatar(avatar);
        }
        
        System.out.println();
        System.out.println("Deck Avatar Avatar Kindom 1: ");
        avaKindom.printDeckAvatar();
        avaKindom.war();

        System.out.println("Klasemen Avatar Kindom 1: ");
        avaKindom.printWinners();
    }

    public static ArrayList<Avatar> readAvatarRequirement(String avatarReqFile){

        ArrayList<Avatar> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(avatarReqFile))) {
            String line;
            for (int i = 0; i < 15; i++) {
                line = br.readLine();
                String[] avatar = line.split(";");
                int health = Integer.parseInt(avatar[2]);
                Avatar ava = new Avatar(avatar[0], avatar[1], health);
                res.add(ava);
                
                //TODO: baca baris untuk membuat objek avatar dan dimasukkan kedalam ArrList
            }
            line = br.readLine();
            while (line != null) {
                String[] fileBender = line.split(";");
                
                int index = Integer.parseInt(fileBender[0]) -1;
                String bender = fileBender[1];
                int damage = Integer.parseInt(fileBender[2]);
                res.get(index).addBender(bender, damage);
                line = br.readLine();
            }
        }
        catch(IOException e){
        }
        return res;
    }
    
}