package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda04_Math_Reduce_Optional {

	public static void main(String[] args) {

		List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));

		System.out.println("Functional method listenin en buyuk elemani");
		maxEleman(list);
	}

	//List in en buyuk elemanini yazdiriniz
	
			public static void maxEleman(List<Integer> list) {
				
			Optional<Integer> maxEl=list.stream().reduce(Math::max);
			System.out.println(maxEl);
			}
			//reduce() azaltmak.. bir cok datayi tek bir dataya cevirmek icin kullanilir
			//max, min, carp, top vs islemlerde kullaniriz
			
			
}
