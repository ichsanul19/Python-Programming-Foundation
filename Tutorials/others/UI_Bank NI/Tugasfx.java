package tugas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tugasfx extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
		
//		/* Stage Utama */
		
        GridPane gp = new GridPane(); //Membuat Pane
        gp.setAlignment(Pos.CENTER); 
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        
        // membuat node text rekening 
        Text rekening = new Text();
        rekening.setFont(new Font("tahoma", 14));
        rekening.setText("Nomor Rekening");
        
        // text input di bawah judul
        TextField nomorRekening = new TextField();
        
        //membuat button
        Button btn = new Button("Lanjut");
          
        //menambahkan nodes ke gridpane
        gp.add(rekening, 0, 0);
        gp.add(nomorRekening, 0, 1); // baris 1 kolom 1
        gp.add(btn, 0,10);
        
        // menampung GridPane ke Scene
        Scene ebanking = new Scene(gp, 350, 380); // setSize windows lebar, tinggi 
        primaryStage.setTitle("E-Banking app"); 
        primaryStage.setScene(ebanking);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
//      /* Stage kedua */
        Stage stage2 = new Stage();
        
        GridPane gp2 = new GridPane(); //Membuat Pane
        gp2.setAlignment(Pos.CENTER); 
        gp2.setVgap(10);
        gp2.setHgap(10);
        gp2.setPadding(new Insets(25, 25, 25, 25));
        
        
        // text rekeningku
        Text rekeningku = new Text();
        rekeningku.setFont(new Font("tahoma", 14));
        rekeningku.setText("Rekeningku");
        
        // nomor rekening dan field
        Text nomorRekening2 = new Text();
        //Text nomorRekening2 = new Text();
        nomorRekening2.setFont(new Font("tahoma", 14));
        nomorRekening2.setText("Nomor Rekening");
        
        TextField angka = new TextField();
        angka.setFont(new Font("tahoma", 14));
        angka.setText("0123456789");
        
        // kriteria
        Text kriteria = new Text();
        kriteria.setFont(new Font("tahoma", 14));
        kriteria.setText("Kriteria Pencarian Transaksi");
      
        // TabPane untuk waktu dan periode
        TabPane tp = new TabPane();
       
        // jangka waktu
        Tab tab1 = new Tab("Jangka Waktu");
        tab1.setClosable(false);
        
        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        
        TextField dari = new TextField("waktu awal");
        Text sampaiDengan = new Text("Sampai Dengan");
        TextField sampai = new TextField("waktu akhir");
        vbox1.getChildren().addAll(dari, sampaiDengan, sampai);
        
        tab1.setContent(vbox1);
        
        // periode
        Tab tab2 = new Tab("Periode");
        tab2.setClosable(false);
        
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        
        TextField bulan = new TextField("1 Bulan Terakhir");
        TextField minggu = new TextField("1 Minggu Terakhir");
        TextField hari = new TextField("Hari ini");
        vbox2.getChildren().addAll(bulan, minggu, hari);
        
        tab2.setContent(vbox2);
        
        // merge 2 tab
        tp.getTabs().addAll(tab1, tab2);
        
        //menambahkan nodes ke gridpane 
        gp2.add(rekeningku, 0, 0, 1, 1);
        
        gp2.add(nomorRekening2, 0, 1); 
        gp2.add(angka, 1, 1);
        
        gp2.add(kriteria, 0, 3);
       
        gp2.add(tp, 0, 5);
        
        // menampung GridPane ke Scene
        Scene ebanking2 = new Scene(gp2, 350, 380); // setSize windows lebar, tinggi 
        stage2.setTitle("E-Banking app"); 
        stage2.setScene(ebanking2);
        stage2.setResizable(false);
        stage2.show();
    }

    // run aplikasi
    public static void main(String[] args) {
        launch(args);
    }
}

	
	

