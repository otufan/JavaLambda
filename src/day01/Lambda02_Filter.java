package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda02_Filter {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		
		System.out.println(" Functional method ile cift sayilar");
		printCiftElFunctional1(list);
		System.out.println("");
		System.out.println(" Functional method ve filter ici method ile cift sayilar");
		printCiftElFunctional2(list);
		System.out.println("");
		System.out.println(" Functional method ile 60 dan kucuk ve cift sayilar");
		printCiftAltmisKucuk(list);
		System.out.println("");
		System.out.println(" Functional method ile 20 den buyuk veya tek sayilar");
		printTekveyaYirmidenBuyuk(list);
		System.out.println("");
		System.out.println(" Functional method ile 20 den buyuk veya tek sayilar");
		ciftSayilarinKareleri(list);
		
	}
	
	public static void printCiftElFunctional1(List<Integer> list) {
		list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
		//filter() ais icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}
	
	public static boolean ciftBul(int i) {//refere edilecek tohum method create edildi
		
		return i%2==0;
	}
	
	public static void printCiftElFunctional2(List<Integer> list) {
		list.stream().filter(Lambda02_Filter::ciftBul).forEach(Lambda01::printEl);
		//filter() ais icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}
	
	//functional Programming ile list elemanlarinin cift olanlarinin 60 dan kucuk olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printCiftAltmisKucuk(List<Integer> list) {
		list.stream().filter(t->t%2==0&t<60).forEach(Lambda01::printEl);
	
	}
	
	//functional Programming ile list elemanlarinin tek olanlarini veya 20 den buyuk olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printTekveyaYirmidenBuyuk(List<Integer> list) {
		list.stream().filter(t->t>20||t%2==1).forEach(Lambda01::printEl);
		
	}
	
	//functional Programming ile list elemanlarinin cift olanlarinin karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void ciftSayilarinKareleri(List<Integer> list) {
		list.stream().filter(Lambda02_Filter::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
		
	}
	
}
