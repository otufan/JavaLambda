package day03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import day01.Lambda01;
import day01.Lambda02_Filter;

public class Lambda02_String {

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>(Arrays.asList("mehmet", "emre", "nilgun", "yildiz", "kader", "emine", "islam", "islam", "emre"));
		
		siraBykTkrsiz(list);
		System.out.println(" ");
		tersSiraTekrarsizKrkter(list);
		System.out.println(" ");
		krktrSayisinagoreMinMax(list);
		System.out.println(" ");
		sonHarfTers(list);
		System.out.println(" ");
		ciftKareTekrarsizMintoMax(list);
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
	
}
