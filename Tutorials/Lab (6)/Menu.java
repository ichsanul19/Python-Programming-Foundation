package Lab06_Rabu;

public class Menu {
    
    private String name;
    private int price;

    /**
     * Membuat constructor untuk class Menu.
     * @param name nama menu.
     * @param price harga menu.
     */
    public Menu(String name,int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Mengembalikan nama menu yang dimiliki oleh suatu menu.
     * @return nama menu.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mengembalikan harga yang dimiliki oleh suatu menu.
     * @return harga menu.
     */
    public int getPrice() {
        return this.price;
    }
  
    /**
     * Membuat setter untuk attribute harga.
     * @param price harga menu
     */
  	public void setPrice(int price) {
      	this.price = price;
    }
}