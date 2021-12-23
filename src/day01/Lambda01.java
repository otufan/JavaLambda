package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

	public static void main(String[] args) {
		/*
		   1) Lambda "Functional Programming"
		      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
		   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
		   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
		   ve hatasiz code yazma acilarindan cok faydalidir.
		   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
		      Lambda kullanmak hatasız code kullanmaktır.
		*/
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		
		printElStructured(list);//12 13 65 3 7 34 22 60 42 55 
		System.out.println("");
		System.out.println(" Functional method ile");
		printElFunctional1(list);//12 13 65 3 7 34 22 60 42 55 
		System.out.println("");
		System.out.println(" Method referans ile Functional calisildi");
		printElFunctional2(list);
		System.out.println("");
		System.out.println(" Functional method ile cift sayilar");
		printCiftElStructured(list);
		System.out.println("");
		System.out.println(" Functional method ile cift sayilar");
		printCiftElFunctional1(list);
		
		
		
		
		
		
		
		
		
		
	}
	//structured programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz
	
	public static void printElStructured(List<Integer> list) {
		for (Integer each : list) {
			System.out.print(each + " ");
		}
	
		
	}
	//functional programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz

	public static void printElFunctional1(List<Integer> list) {
		list.stream().forEach(t->System.out.print(t + " "));//Lambda Expression : Lambda ifadesi
		//stream() : datalari yukaridan asagiya akis sekline getirir
		//forEach(): datanin parametresine gore her bir elemani isler
		//t-> : lambda operatoru
		//Lambda Expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
		
	}
		//Method Reference --> kendi create ettigimiz veya Java dan aldigimiz method ile
		//Classname:: Methodname --> EZBERLENECEK
	
	public static void printEl(int t) {//refere edilecek method create edildi
		System.out.print(t + " ");
	}
	
	public static void printElFunctional2(List<Integer> list) {
		list.stream().forEach(Lambda01::printEl);//iste lambda budur
	}
	
	//structured Programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printCiftElStructured(List<Integer> list) {
		
		for (Integer w : list) {
			
			if (w%2==0) {
				System.out.print(w + " ");
			}
		}
		
	}
	
	//functional Programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printCiftElFunctional1(List<Integer> list) {
		list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
		//filter() ais icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}
	
	
}
