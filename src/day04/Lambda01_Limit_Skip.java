package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Lambda01_Limit_Skip {

	public static void main(String[] args) {
	List<String> list=new ArrayList<>(Arrays.asList("kokorec","mehmet", "emre", 
				"nilgun", "yildiz", "kader", "emine", "islam", "islam", "emre"));

	karakterUcMax(list);
	System.out.println(" ");
	sonHarfIlkElmnHrc(list);
	}

	//karakter sayisi en buyuk 3 elemani yazdiriniz
		public static void karakterUcMax(List<String> list) {
								
		Stream<String> max = list.stream().sorted(Comparator.comparing(String::length).reversed()).limit(3);
			
		//System.out.println(max.toList());
		System.out.println(Arrays.toString(max.toArray()));//	Array e bu sekilde atanabiliyor
				
	}
		
	//List elemanlarini son harflerine gore siralayip, ilk eleman haric kalan elemanlarini yazdiriniz
	
		public static void sonHarfIlkElmnHrc(List<String> list) {
			
		list.stream().sorted().sorted(Comparator.comparing(t->t.toString().substring(t.toString().length()-1))).
		skip(1).//ilk elemani  atlamak icin kullandik
		forEach(t->System.out.print(t+" "));
		
		
		
		}
}
			
