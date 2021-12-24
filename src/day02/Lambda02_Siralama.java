package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02_Siralama {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 3, -60, 42, 15));
		
		
		System.out.println("Liste cift sayilarin en buyugunun karesi");
		minEleman1(list);
		minEleman2(list);
		minEleman3(list);
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
	
}
