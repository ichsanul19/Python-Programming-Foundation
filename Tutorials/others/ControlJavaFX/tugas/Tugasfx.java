package tugas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Tugasfx<TabelView> extends Application {
	String namaFile = "dataset.txt"; // kalo ga berhasil munculin full directorinya
	List<String> inputText;
	
	Stage stage2 = new Stage();
	ArrayList<DataTransaksi> akunSesiIni = new ArrayList<>();
	Text angkaRekening = new Text();
	
	Popup popup = new Popup();
	
	//private TableView table;
    //private ObservableList data;
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		// Read text
		try {
			inputText = Files.readAllLines(Paths.get(namaFile));
		} catch(IOException ex) {
			System.out.println("Coba masukin full direktorinya");
		}
    	
    	for (String baris:inputText) {
    		String[] text = baris.split(",");
    		DataTransaksi data = new DataTransaksi(text[0], text[1], text[2],
    				text[3], text[4], text[5]);
    		akunSesiIni.add(data);
    	}
    	
        // menampung GridPane ke Scene
		GridPane gp = menuDaftar();
        Scene ebanking = new Scene(gp, 350, 380); // setSize windows lebar, tinggi 
        primaryStage.setTitle("E-Banking app"); 
        primaryStage.setScene(ebanking);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
//      /* Stage menuPencarian */ 
        BorderPane cari = menuPencarian();
        Scene ebanking2 = new Scene(cari, 370, 380); // setSize windows lebar, tinggi 
        stage2.setTitle("E-Banking app"); 
        stage2.setScene(ebanking2);
        stage2.setResizable(false);
    }
	
	public GridPane menuDaftar() {
        GridPane gp = new GridPane(); //Membuat Pane
        gp.setAlignment(Pos.CENTER); 
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        
        // membuat node text rekening 
        Text rekening = new Text();
        rekening.setFont(new Font("tahoma", 14));
        rekening.setText("Nomor Rekening");
        gp.add(rekening, 0, 0);
        
        // text input di bawah judul
        TextField nomorRekening = new TextField();
        gp.add(nomorRekening, 0, 1); 
        
        //membuat button
        Button btn = new Button("Lanjut");
        gp.add(btn, 0,10);
        
        Text unRegistered = new Text("");
        gp.add(unRegistered, 0, 15);
        
        btn.setOnAction(e -> {
        	String nomor = nomorRekening.getText();
        	Boolean next = true;
        	for (DataTransaksi data:akunSesiIni) {
        		if (nomor.equals(data.getNoRekening())) {
        			unRegistered.setText("Sedang login");
        			unRegistered.setFill(Color.GREEN);
        			stage2.show();
        			angkaRekening.setText(nomor);
        			next = false;
        			break;
        		}
        	}
        	if(next) {
        		unRegistered.setText("User belum terdaftar");
        		unRegistered.setFill(Color.FIREBRICK);
        	}
        	
        	
        	
        });
        return gp;
	}
	
	public BorderPane menuPencarian() {    
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));
        
        GridPane gp2 = new GridPane(); //Membuat Pane
        bp.setTop(gp2); // menambahkan gp ke atas bp
        gp2.setAlignment(Pos.CENTER); 
        gp2.setVgap(10);
        gp2.setHgap(10);
        
        // text rekeningku
        Text rekeningku = new Text();
        rekeningku.setFont(new Font("tahoma", 14));
        rekeningku.setText("Rekeningku");
        gp2.addColumn(0, rekeningku);
        GridPane.setHalignment(rekeningku, HPos.RIGHT);
        
        // nomor rekening dan field
        Text nomorRekening2 = new Text();
        nomorRekening2.setFont(new Font("tahoma", 14));
        nomorRekening2.setText("Nomor Rekening");
        gp2.add(nomorRekening2, 0, 1);
        
        angkaRekening.setFont(new Font("tahoma", 14));
        angkaRekening.setText("0123456789");
        gp2.add(angkaRekening, 1, 1);
        
        // kriteria
        Text kriteria = new Text();
        kriteria.setFont(new Font("tahoma", 14));
        kriteria.setText("Kriteria Pencarian Transaksi");
        gp2.add(kriteria, 0, 3);
        GridPane.setHalignment(kriteria, HPos.RIGHT);
      
        // Button lanjut
        Button btn = new Button("Lanjut");
        btn.setMinWidth(150);
        bp.setBottom(btn);
        BorderPane.setAlignment(btn, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(btn, new Insets(25, 25, 25, 25));
        
        // TabPane untuk waktu dan periode
        TabPane tp = new TabPane();
        tp.setMaxWidth(200);
        bp.setCenter(tp); // menambahkan tp ke bo
       
        // jangka waktu
        Tab tab1 = new Tab("Jangka Waktu");
        tab1.setClosable(false);
        
        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        
        TextField dari = new TextField("waktu awal");
        dari.setAlignment(Pos.CENTER);
        Text sampaiDengan = new Text("Sampai Dengan");
        TextField sampai = new TextField("waktu akhir");
        sampai.setAlignment(Pos.CENTER);
        
        vbox1.getChildren().addAll(dari, sampaiDengan, sampai);
        tab1.setContent(vbox1);
        tab1.setOnSelectionChanged(e -> {
        });
        
        // periode
        Tab tab2 = new Tab("Periode");
        tab2.setClosable(false);
        
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        
        Button bulan = new Button("1 Bulan Terakhir");
        bulan.setMinWidth(200);
        Button minggu = new Button("1 Minggu Terakhir");
        minggu.setMinWidth(200);
        Button hari = new Button("Hari ini");
        hari.setMinWidth(200);
        
        vbox2.getChildren().addAll(bulan, minggu, hari); 
        tab2.setContent(vbox2);
        
        // tambahkan 2 tab
        tp.getTabs().addAll(tab1, tab2);
        
        bulan.setOnAction(e -> {
        	bulan.setTextFill(Color.GREEN);
        	btn.setOnAction(e2 -> {
        		kriteria.setText("Mutasi Rekening");
        		bp.getChildren().remove(tp);
        		btn.setText("Kembali");
        		
        		TableView tabel = new TableView();
        		ArrayList<DataTransaksi> rekapTransaksi = new ArrayList<>();
        		
        		for(DataTransaksi d:akunSesiIni) {
        			if(angkaRekening.getText().equals(d.noRekening.get())) {
        				rekapTransaksi.add(d);
        			}
        		}
        		
        		ObservableList<DataTransaksi> data = FXCollections.observableList(rekapTransaksi);
                
        		TableColumn column1 = new TableColumn ("Uraian");
        		column1.setCellValueFactory(new PropertyValueFactory<DataTransaksi, String>("tanggal"));
        		TableColumn column2 = new TableColumn<>("Tipe");
        		column2.setCellValueFactory(new PropertyValueFactory<DataTransaksi, String>("tipe"));
        		TableColumn column3 = new TableColumn<>("Nominal");
        		column3.setCellValueFactory(new PropertyValueFactory<DataTransaksi, String>("nominal"));
        		TableColumn column4 = new TableColumn<>("Saldo Akhir");
        		column4.setCellValueFactory(new PropertyValueFactory<DataTransaksi, String>("saldoAkhir"));
        		
        		tabel.getItems().add(new DataTransaksi("sf","", "", "", "", ""));
        		tabel.getColumns().addAll(column1, column2, column3, column4);
        		tabel.setItems(data);
        		
        		bp.setCenter(tabel);
        		
        		btn.setOnAction(e3 -> {
        			bp.getChildren().remove(tabel);
        			bp.setCenter(tp);
        			btn.setText("Lanjut");
        		});
        	});
        });
        return bp;
	}

    // run aplikasi
    public static void main(String[] args) {
        launch(args);
    }
}

	
	


