package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03_Map {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));

		System.out.println("Functional method ile 20 den buyuk veya tek sayilar");
		ciftSayilarinKareleri(list);
		System.out.println("");
		System.out.println("Functional method ile 20 den buyuk veya tek sayilar");
		
	}
	
	//functional Programming ile list elemanlarinin cift olanlarinin karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
		public static void ciftSayilarinKareleri(List<Integer> list) {
			list.stream().filter(Lambda02_Filter::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
			
		}
		
}
