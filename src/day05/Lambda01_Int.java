package day05;

import java.util.stream.IntStream;

import day01.Lambda01;
import day01.Lambda02_Filter;

public class Lambda01_Int {

	public static void main(String[] args) {
		
		System.out.println("Manuel yani structured method ile: "+topla(10));
		System.out.println("Lambda ile range: "+topla1(10));
		System.out.println("Lambda ile rangeClosed : "+topla2(10));
		System.out.println("Lambda ile cift : "+toplaCift(10));
		System.out.println("Lambda-Iterator ile cift : "+toplaCift1(10));
		System.out.println("Lambda-Iterator ile x adet cift sayinin toplami : "+toplaIlkXCift(10));
		System.out.println("Lambda-Iterator ile x adet tek sayinin toplami : "+toplaIlkXTek((10)));
		System.out.println("");
		IkininninIlkXKuvveti(7);
		System.out.println("");
		YinIlkXkuvveti(8, 2);
		System.out.println("");
		YinIlkXinciKuvveti(8, 2);
		System.out.println("");
		System.out.println("Faktoriyel");
		System.out.println(XsayisinFaktoriyeli(5));
		
	}
		//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
		//structured programming
	public static int topla(int x) {
		int toplam=0;
		for (int i = 0; i <= x; i++) {
			toplam+=i;
			
		}
		
		return toplam;
	}
	//functional programming
	public static int topla1(int x) {
		
		return IntStream.
				range(1, x+1).//1 dahil x+1 haric
				sum();
	}
	
	//functional programming
		public static int topla2(int x) {
			
			return IntStream.
					rangeClosed(1, x).//1 ve x dahil alir
					sum();
		}
	
		//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
		public static int toplaCift(int x) {
			
			return IntStream.
					rangeClosed(1, x).filter(Lambda02_Filter::ciftBul).sum();
		}
		public static int toplaCift1(int x) {
			
			return IntStream.iterate(2, t->t+2).//ciftleri bu sekilde de yapabiliriz. tavsiye edilen bu sekilde olmasi
					limit(x/2).//nerede duracagini soylememiz gerekiyor
					sum();
		}
		//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
		public static int toplaIlkXCift(int x) {
			
			return IntStream.iterate(2, t->t+2).//ciftleri bu sekilde de yapabiliriz. tavsiye edilen bu sekilde olmasi
					limit(x).//nerede duracagini soylememiz gerekiyor
					sum();
		}
		
		//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
		public static int toplaIlkXTek(int x) {
			
			return IntStream.iterate(1, t->t+2).
					limit(x).
					sum();
		}
		
		//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
		public static void IkininninIlkXKuvveti(int x) {
			
		IntStream.iterate(1, t->t*2).
					limit(x).forEach(t->System.out.print(t + " "));
		}
		//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
		public static void YinIlkXkuvveti(int x, int y) {
			
			IntStream.iterate(1, t->t*y).
						limit(x).forEach(t->System.out.print(t + " "));
			}
		
		//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
		public static int XsayisinFaktoriyeli(int x) {
			
			return IntStream.rangeClosed(1, x).reduce(1,(t,u)->t*u);
					//reduce(Math::multiplyExact).getAsInt();
			}
		
		//TASK 08 --> Istenilen bir sayinin ilk x. kuvvetini ekrana yazdiran programi yaziniz
				public static void YinIlkXinciKuvveti(int x, int y) {
					
					IntStream.iterate(1, t->t*y).
								limit(x).skip(x-1).forEach(t->System.out.print(t + " "));
					}
}
