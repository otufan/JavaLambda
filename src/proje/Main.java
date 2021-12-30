package proje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	static List<Ogrenci> ogListe=new ArrayList<>();
	
	
	public static void main(String[] args) {
		
	ogrenciListesi();
	
	//Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin
	System.out.println("*************Belli not araligindaki ogrenciler*************");
	notaGoreSirala(ogListe, 80 , 90);
	
	//Öğrencileri yaşlarına göre sıralayark yazdırin
	System.out.println(" ");
	System.out.println("***********Yaslara gore yazdirma*************");
	yaslaraGoreSirala(ogListe);
	
	 //Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin
	System.out.println(" ");
	System.out.println("***********Yasa ve Cinsiyete Gore Sirali*************");
	yasCinsiyetSirali(ogListe, 99, "erkek");
	
	//Belli bir isimdekileri yazdırma
	System.out.println(" ");
	System.out.println("***********isimlerine gore*************");
	ismiBul(ogListe, "Ahmet");
	
	//Belli bir soyisimdileri yazdırma
		System.out.println(" ");
		System.out.println("***********soyisimlere gore*************");
		soyisimBul(ogListe, "Aslan");
		
	//reduce metoduyla ortalama hesaplayin
		System.out.println(" ");
		System.out.println("***********Ortalama Hesaplama*************");
		ortalamaBul(ogListe);
		
	}


	private static void ortalamaBul(List<Ogrenci> ogListe) {
		
		double toplam=ogListe.stream().mapToDouble(Ogrenci::getDiplomaNotu).reduce(0.0,Double::sum);
		System.out.println(toplam/ogListe.size());
		
		System.out.println(ogListe.stream().mapToDouble(Ogrenci::getDiplomaNotu).average().getAsDouble());
	}


	private static void soyisimBul(List<Ogrenci> ogListe, String soyisim) {
		ogListe.stream().filter(t->t.getSoyAd().equalsIgnoreCase(soyisim)).forEach(t->System.out.println( t.toString()));
		
	}


	private static void ismiBul(List<Ogrenci> ogListe, String isim) {
		ogListe.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).forEach(t->System.out.println( t.toString()));
		
	}


	private static void yasCinsiyetSirali(List<Ogrenci> ogListe, int yas, String cinsiyet) {
		
		ogListe.stream().filter(t->t.getYas()<yas&&t.getCinsiyet().contains(cinsiyet)).
		sorted(Comparator.comparing(Ogrenci::getYas)).
		forEach(t->System.out.println( t.toString()));
		
		
	}





	private static void yaslaraGoreSirala(List<Ogrenci> ogListe) {
		ogListe.stream().sorted(Comparator.comparing(Ogrenci::getYas).reversed()).forEach(t->System.out.println( t.toString()));
		
	}


	private static void notaGoreSirala(List<Ogrenci> ogListe, int alt, int ust) {
		
		ogListe.stream().sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
		filter(t->t.getDiplomaNotu()>alt&&t.getDiplomaNotu()<ust).forEach(t->System.out.println( t.toString()));
		
	}

	private static void ogrenciListesi() {
	
		ogListe.add(new Ogrenci("Ahmet", "Can", 30, 95.5 , "erkek"));
		ogListe.add(new Ogrenci("Ahmet", "Yarba", 25, 90.5 , "erkek"));
		ogListe.add(new Ogrenci("Ayse", "Can", 21, 82.5 , "kadin"));
		ogListe.add(new Ogrenci("Merve", "Aslan", 30, 98.8 , "kadin"));
		ogListe.add(new Ogrenci("Veli", "Han", 80, 35.5 , "erkek"));
		ogListe.add(new Ogrenci("Funda", "Funda", 24, 99.2 , "kadin"));
			
	}
	
}
