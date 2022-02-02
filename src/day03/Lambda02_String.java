package day03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import day01.Lambda01;
import day01.Lambda02_Filter;

public class Lambda02_String {

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>(Arrays.asList("kokorec","mehmet", "emre", "nilgun", "yildiz", "kader", "emine", "islam", "islam", "emre"));
		
		siraBykTkrsiz(list);
		System.out.println(" ");
		tersSiraTekrarsizKrkter(list);
		System.out.println(" ");
		krktrSayisinagoreMinMax(list);
		System.out.println(" ");
		sonHarfTers(list);
		System.out.println(" ");
		ciftKareTekrarsizMintoMax(list);
		System.out.println(" ");
		yediKrkterKontrol(list);
		System.out.println(" ");
		wIleBaslama(list);
		System.out.println(" ");
		xIleBiten(list);
		System.out.println(" ");
		karakterMax(list);
	}
	
	//list elemanlarini alfabetik buyuk harf ve tekrarsiz yazdiriniz
	
	public static void siraBykTkrsiz(List<String> list) {
		list.stream().map(t->t.toUpperCase()).sorted().distinct().//tekrarsiz yapildi... cok onemli !
														forEach(t->System.out.print(t + " "));
	}

	//list elemanlari karakter sayisini ters sirali olarak tekrarsiz yazdiriniz
	public static void tersSiraTekrarsizKrkter(List<String> list) {
		//list.stream().map(t->t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::printEl);
		list.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::printEl);
	}
	
	
	//list elemanlarini karakter sayisina gore kucukten buyuge gore
	
	public static void krktrSayisinagoreMinMax(List<String> list) {
		
		list.stream().sorted().sorted(Comparator.comparing(String::length)).forEach(t->System.out.print(t + " "));
	}
	
	//list elemanlarinin son harfine gore ters sirali yazdiriniz
	public static void sonHarfTers(List<String> list) {
		
		list.stream().sorted().sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).
				reversed()).
				forEach(t->System.out.print(t + " "));
				
	}
	
	//Karakter sayisi Cift elemanlarin karelerini hesaplayan, tekrarli olanlari sadece bir kere buyukten kucuge dogru
	//yazdiran bir program yaziniz.
	public static void ciftKareTekrarsizMintoMax(List<String> list) {
		
		list.stream().map(String::length).map(t->t*t).filter(Lambda02_Filter::ciftBul).distinct().
		sorted(Comparator.reverseOrder()).forEach(Lambda01::printEl);
				
	}
	//List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
	public static void yediKrkterKontrol(List<String> list) {
		
		boolean kontrol = list.stream().map(String::length).allMatch(t->t<=7);
		System.out.println(kontrol?"List elemanlari 7 den buyuk degil" : " List elemanlarindan 7 den buyuk var");
		
		//System.out.println(list.stream().map(t->t.length()>7 ? "List elemanlari 7 den buyuk degil" : "List elemanlarindan 7 den buyuk var"));
	}
	
	//List elemanlarinin "W" ile baslamasini kontrol ediniz
	
	public static void wIleBaslama(List<String> list) {
		
	boolean kontrol = list.stream().noneMatch(t->t.toLowerCase().startsWith("w"));
		
		System.out.println(kontrol?"Elemanlardan W ile baslayan yok" : "Elemanlardan  W ile baslayan var" );
	}
	
	//List elemanlarinin "x" ile biten en az bir elemani kontrol ediniz
	
		public static void xIleBiten(List<String> list) {
			
		boolean kontrol = list.stream().anyMatch(t->t.toLowerCase().endsWith("x"));
			
			System.out.println(kontrol?"Elemanlardan x ile biten var" : "Elemanlardan x ile biten yok" );
		}
		
		//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
		
		
		//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
		
		
		//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder
		
		//karakter sayisi en buyuk elemani yazdiriniz
		public static void karakterMax(List<String> list) {
			
			Optional<String> max = list.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst();
			System.out.println(max);
			
			
		}
		
		
		
		
}
