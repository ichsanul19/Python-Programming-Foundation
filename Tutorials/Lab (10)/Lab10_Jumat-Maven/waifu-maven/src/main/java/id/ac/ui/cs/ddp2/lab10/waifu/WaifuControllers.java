package id.ac.ui.cs.ddp2.lab10.waifu;

import id.ac.ui.cs.ddp2.lab10.waifu.model.Waifu;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WaifuControllers {
    List<Waifu> listWaifu = Waifu.getListWaifu();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tambah-waifu")
    public String addWaifu(Model model) {
        model.addAttribute("waifu", new Waifu());
        return "tambah-waifu"; // html
    }

    @PostMapping("/tambah-waifu")
    public String postWaifu(@ModelAttribute Waifu waifu) {
        listWaifu.add(waifu); //menambahkan waifu ke listWaifu setelah form tambah waifu terisi
        return "result"; // menampilkan notif setelah berhasil ditambahkan 
    }

    @GetMapping("/list-waifu")
    public String daftarDonatur(Model model) {
        model.addAttribute("listWaifu", listWaifu); // "listWaifu" terdapat pada html
        return "list-waifu"; //html 
    }

}