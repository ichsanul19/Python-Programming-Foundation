package tugas;

import javafx.beans.property.SimpleStringProperty;

public class DataTransaksi {
	final SimpleStringProperty noRekening;
	final SimpleStringProperty namaTipe;
	final SimpleStringProperty tanggal;
	final SimpleStringProperty tipe;
	final SimpleStringProperty nominal;
	final SimpleStringProperty saldoAkhir;
	
	public DataTransaksi(String a, String b, String c,
			String d, String e, String f) {
		noRekening = new SimpleStringProperty(a);
		namaTipe = new SimpleStringProperty(b);
		tanggal = new SimpleStringProperty(c);
		tipe = new SimpleStringProperty(d);
		nominal = new SimpleStringProperty(e);
		saldoAkhir = new SimpleStringProperty(f);
	}
	
	public String getNoRekening() {
		return noRekening.get();
	}
	
	public String getNamaTipe() {
		return namaTipe.get();
	}
	
	public String getTanggal() {
		return namaTipe.get() +"\n" +tanggal.get();
	}
	
	public String getTipe() {
		return tipe.get();
	}
	
	public String getNominal() {
		return nominal.get();
	}
	
	
	public String getSaldoAkhir() {
		return saldoAkhir.get();
	}
	
	
}