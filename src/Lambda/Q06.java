package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q06 {
    
   
    
	
	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15));
		System.out.println("***************");
		
		//Fonksiyonel Programlama ile [12, 9, 13, 4, 6, 2, 4, 12, 15] listesindeki tüm tek sayıları yazdırın
		
		list.stream().filter(t->t%2==1).forEach(t->System.out.println(t+" "));
		System.out.println("***************");
		 //6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
		
		list.stream().filter(t->t<14&&t>6).sorted().map(t->t*t).forEach(t->System.out.println(t + " "));
		System.out.println("***************");
		
		 //Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
		System.out.println(list.stream().filter(t->t%2==1).map(Math::sqrt).reduce(Double::sum));
		System.out.println("***************");
	}
}
