package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda03_Map {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));

		System.out.println("Functional method ile 20 den buyuk veya tek sayilar");
		ciftSayilarinKareleri(list);
		System.out.println("");
		System.out.println("Functional method ile tek sayilarin kuplerinin 1 fazlasi");
		tekSayilarinKuplerininBirEksigi(list);
		System.out.println("");
		System.out.println("Functional method ile cift sayilarin kareleri");
		ciftlerinKarekokleri(list);
		System.out.println("");
		System.out.println("Functional method listenin en buyuk elemani");
		maxEleman(list);
	}
	
	//functional Programming ile list elemanlarinin cift olanlarinin karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
		public static void ciftSayilarinKareleri(List<Integer> list) {
			list.stream().filter(Lambda02_Filter::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
			
		//map() bir ara islemde kullanilir. elemanlari istenen isleme gore degistirmek update etmek icin kullanilir
		}
		
		//functional Programming ile list elemanlarinin tek olanlarinin kuplerinin 1 fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
		
		public static void tekSayilarinKuplerininBirEksigi(List<Integer> list) {
			list.stream().filter(t->t%2==1).map(t->t*t*t+1).forEach(Lambda01::printEl);
		
		}
		
		//functional Programming ile list elemanlarinin cift olanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
		
		public static void ciftlerinKarekokleri(List<Integer> list) {
			list.stream().filter(Lambda02_Filter::ciftBul).map(Math::sqrt).forEach(t->System.out.print(t + " "));
		
		}
		
		//List in en buyuk elemanini yazdiriniz
		
		public static void maxEleman(List<Integer> list) {
			
		Optional<Integer> maxEl=list.stream().reduce(Math::max);
		System.out.println(maxEl);
		}
		
		
}
