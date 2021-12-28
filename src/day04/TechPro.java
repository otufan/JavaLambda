package day04;

public class TechPro {
	
	private String batch;
	private String batchName;
	private int betchOrt;
	private int ogrSayisi;
	
	
	
	public TechPro() {
		
	}
	
	public TechPro(String batch, String batchName, int betchOrt, int ogrSayisi) {
		super();
		this.batch = batch;
		this.batchName = batchName;
		this.betchOrt = betchOrt;
		this.ogrSayisi = ogrSayisi;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getBetchOrt() {
		return betchOrt;
	}
	public void setBetchOrt(int betchOrt) {
		this.betchOrt = betchOrt;
	}
	public int getOgrSayisi() {
		return ogrSayisi;
	}
	public void setOgrSayisi(int ogrSayisi) {
		this.ogrSayisi = ogrSayisi;
	}
	@Override
	public String toString() {
		return "TechPro [batch=" + batch + ", batchName=" + batchName + ", betchOrt=" + betchOrt + ", ogrSayisi="
				+ ogrSayisi + "]"; 
	}
	
	
	
	
	
	

}
