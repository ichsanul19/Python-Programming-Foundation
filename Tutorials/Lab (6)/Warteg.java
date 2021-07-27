package Lab06_Rabu;

public class Warteg extends Place { // TODO: Lengkapi baris ini
      
    /**
     * Membuat constructor untuk class Warteg.
     * @param name nama warteg.
     */
    public Warteg(String name){
        super(name);
    }

    /**
     * Menambahkan suatu menu ke warteg. Bila sudah ada, menu diupdate.
     * @param menu menu yang ingin ditambahkan.
     */
    @Override
    public void addMenu(Menu menu) {
        if (contains(menu)) {
            System.out.println(String.format("Menu dengan nama %s sudah ada", menu.getName()));
        }
        else {
            this.listMenu.add(menu);
            setMaxMin2();
            System.out.println(String.format("Menu dengan nama %s sudah ditambahkan di %s", menu.getName(), this.getName()));
        }
    }
        /** 
        for(Menu eachMenu : listMenu){
            if (eachMenu.getName().equals(menu.getName())) {
                listMenu.remove(eachMenu);
                listMenu.add(menu);
                setMinMaxPrice(menu.getPrice());
                System.out.println(String.format("Menu dengan nama %s sudah diupdate di %s", menu.getName(), this.getName()));
            } else {
                this.listMenu.add(menu);
                setMinMaxPrice(menu.getPrice());
                System.out.println(String.format("Menu dengan nama %s sudah ditambahkan di %s", menu.getName(), this.getName()));
            }
        }
        
    }
    */
}