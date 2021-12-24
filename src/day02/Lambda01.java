package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import day01.Lambda02_Filter;

public class Lambda01 {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		System.out.println("Liste cift sayilarin en buyugunun karesi");
		ciftKareMax(list);
		System.out.println("Liste tum elemanlarin toplami-Expresion");
		tumElemanlarinToplami1(list);
		System.out.println("Liste tum elemanlarin toplami-Method");
		tumElemanlarinToplami2(list);
		System.out.println("Liste Cift elemanlarin carpimi-Expresion");
		ciftElemanCarpimList(list);
	}
	
	//List in cift elemanlarin karelerini aliniz ve en buyugunu yaazdiriniz
	
	public static void ciftKareMax(List<Integer> list) {
	Optional<Integer>	maxEl=list.stream().filter(Lambda02_Filter::ciftBul).map(t->t*t).reduce(Integer::max); 
	//Math classindan da alabilirdik ama Int class daha dar ve hizli oldugu icin 
	
	//reduce () return edilen eleman null yada int dabuyuk olur ihtimali icin java guvenlik olarak handle ederek optional class				 																					
	System.out.println(maxEl);
	
	}
	
	//List teki tum elemanlarin toplamini yazdiriniz
	//Lambda expression...
	
	public static void tumElemanlarinToplami1(List<Integer> list) {
	int	toplam=list.stream().reduce(0, (x, y)->x+y);
	//x her zaman ilk degerini atanan degerden (0) alir
	//y her zaman degerini list.stream() den alir (akis) 
	//x ilk degerden sonraki degerlerini islemden alir
		System.out.println(toplam);
	}
	
	//List teki tum elemanlarin toplamini yazdiriniz
	//Method reference...
	public static void tumElemanlarinToplami2(List<Integer> list) {
		Optional<Integer>	toplam1=list.stream().reduce(Integer::sum);
		Optional<Integer>	toplam2=list.stream().reduce(Math::addExact);
		System.out.println(toplam2);
	}
	
	//List teki cift elemanlarin carpimini yazdiriniz
	//Method reference...
	public static void ciftElemanCarpimList(List<Integer> list) {
		Optional<Integer> deger = list.stream().filter(Lambda02_Filter::ciftBul).reduce(Math::multiplyExact);
		
		System.out.println(deger);
		
	}
}
