import java.util.ArrayList;
import java.util.Collections;

public class AvatarKingdom {
    private ArrayList<Avatar> listAvatar;

    public AvatarKingdom() {
        listAvatar = new ArrayList<>();
    }

    public void addAvatar(Avatar avatar) {
        listAvatar.add(avatar);
    }

    public void war() {
        for (Avatar x : listAvatar) {
            for (Avatar y : listAvatar)
                try {
                    x.fight(y);
                } 
                catch (CanNotAttackException e) {
                }
                catch (SuccessAttackException e) {
                }
                
            System.out.println();
        }
    }

    public void printWinners(){
        Collections.sort(listAvatar);
        for (int i = 0; i < listAvatar.size(); i++) {
            System.out.println((i+1)+". "+listAvatar.get(i).getName()+" dari temple "+listAvatar.get(i).getTemple()+", dengan sisa nyawa "+listAvatar.get(i).getHealth());
        }
        System.out.println();
    }

    public void printDeckAvatar(){
        for (int i = 0; i < listAvatar.size(); i++) {
            System.out.println("Avatar "+listAvatar.get(i).getName()+" dari temple "+listAvatar.get(i).getTemple()+", dengan nyawa "+listAvatar.get(i).getHealth()+", dan dengan total damage "+listAvatar.get(i).getdamage()+", siap bertarung!");
        }
        System.out.println();
    }
}