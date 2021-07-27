package Lab06_Rabu;

public class Warkop extends Place { 
    
    /**
     * Membuat constructor untuk class Warkop.
     * @param name nama warkop.
     */
    public Warkop(String name){
        super(name);
    }

    /**
     * Menambahkan suatu menu ke warkop. Bila sudah ada, menu diupdate.
     * @param menu menu yang ingin ditambahkan.
     */
    @Override
    public void addMenu(Menu menu) {
        for(Menu tiapMenu: listMenu) {
            if(tiapMenu.getName().equals(menu.getName())) {
                this.listMenu.remove(tiapMenu);
                this.listMenu.add(menu);
                System.out.println(String.format("Menu dengan nama %s sudah diupdate di %s", menu.getName(), this.getName()));
                break;
            }
        }
        
        if (contains(menu)) {
            System.out.println();
        } else {
            this.listMenu.add(menu);
            System.out.println(String.format("Menu dengan nama %s sudah ditambahkan di %s", menu.getName(), this.getName()));
        }
        
        setMaxMin2();
    }

}