package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import day01.Lambda01;
import day01.Lambda02_Filter;

public class Lambda02_Siralama {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		
		
		System.out.println("Liste cift sayilarin en buyugunun karesi");
		minEleman1(list);
		minEleman2(list);
		minEleman3(list);
		onbesbuyukMinTek(list);
		ciftlerinKarelerininMinMaxSiralama(list);
		System.out.println(" ");
		teklerinKarelerininMaxMinSiralama(list);
	}

	//List teki elemanlardan en kucugunu 3 farkli yontem ile yazdir
	
	public static void minEleman1(List<Integer> list) {
	Optional<Integer> min = list.stream().reduce(Integer::min);//math class dan da min alinabilirdi
	System.out.println("Tamamen functional yazarak" + min);
		
	}
	
	public static int minBul(int x, int y) {
		
		return x<y?x:y;//ternary
		
	}
	
	public static void minEleman2(List<Integer> list) {
	Optional<Integer> min = list.stream().reduce(Lambda02_Siralama::minBul);
	System.out.println("create edilen methodu cagirarak"+min);
	
	}
	
	public static void minEleman3(List<Integer> list) {
	Integer min = list.stream().reduce(Integer.MAX_VALUE,(x,y) ->x<y?x:y);
	System.out.println("kendimiz expression yazarak"+min);
		
		}
	
	//List teki 15 den buyuk en kucuk tek sayiyi yazdiriniz
	
	public static void onbesbuyukMinTek(List<Integer> list) {
		System.out.println("Listteki 15 den kucuk tek minimum sayi : ");
		System.out.println(list.stream().filter(t -> t%2 == 1).filter(t->t>15).reduce(Integer::min));//Optional[65]
		//list.stream().filter(t -> t%2 == 1&t>15).reduce(Integer::min);
		
	}
	
	//list in cift elemanlarinin karelerini kucukten buyuge yazdiriniz
	
	public static void ciftlerinKarelerininMinMaxSiralama(List<Integer> list) {
		list.stream().filter(Lambda02_Filter::ciftBul).map(t->t*t).sorted().//akisa giren elemanlar naturel order siralanir
																	forEach(Lambda01::printEl);
		
	}
	//list in tek elemanlarinin karelerini buyukten kucuge yazdiriniz
	public static void teklerinKarelerininMaxMinSiralama(List<Integer> list) {
		list.stream().filter(t->t%2==1).map(t->t*t).sorted(Comparator.reverseOrder()).//akisa giren elemanlar reverseOrder a gore ters 
														forEach(Lambda01::printEl);
		
	}
	
	
	
}
