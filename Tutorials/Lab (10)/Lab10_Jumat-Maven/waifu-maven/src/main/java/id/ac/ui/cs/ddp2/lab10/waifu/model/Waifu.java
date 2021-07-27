package id.ac.ui.cs.ddp2.lab10.waifu.model;

import java.util.ArrayList;
import java.util.List;

public class Waifu {
    private static List<Waifu> listWaifu = new ArrayList<Waifu>();
    private String name;
    private String umur;
    private String deskripsi;

    public String getName() {
        return name;
    }
    
    public String getUmur() {
        return umur;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public static List<Waifu> getListWaifu() {
        return listWaifu;
    }

    public String toString() {
        return name + " | " + umur + "\n" + deskripsi;
    }
}