package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import day01.Lambda02_Filter;

public class Lambda01_Sorted {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		
		
		ciftlerinKarelerininMinMaxSiralama(list);
		System.out.println(" ");
		teklerinKarelerininMaxMinSiralama(list);

	}
	//list in cift elemanlarinin karelerini kucukten buyuge yazdiriniz
	
		public static void ciftlerinKarelerininMinMaxSiralama(List<Integer> list) {
			list.stream().filter(Lambda02_Filter::ciftBul).map(t->t*t).sorted().//akisa giren elemanlar naturel order siralanir
																		forEach(day01.Lambda01::printEl);
			
		}
		//list in tek elemanlarinin karelerini buyukten kucuge yazdiriniz
		public static void teklerinKarelerininMaxMinSiralama(List<Integer> list) {
			list.stream().filter(t->t%2!=0).map(t->t*t).sorted(Comparator.reverseOrder()).//akisa giren elemanlar reverseOrder a gore ters 
															forEach(day01.Lambda01::printEl);
			
		}
}
