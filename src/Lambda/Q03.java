package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q03 {
    //String isimlerden olusan bir list olusturun
   





	public static void main(String[] args) {
		
		List <String> list=new ArrayList<>();
		
		list.add("Omer");
		list.add("Sueda");
		list.add("Muammer");
		list.add("Muammer");
		list.add("Ada");
		list.add("Mehmetemin");
		
		 //Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
		list.stream().distinct().forEach(t->System.out.print(t +"' nin uzunlugu : " + t.length()+" "));
		System.out.println(" ");
		//Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
		list.stream().distinct().sorted(Comparator.comparing(String::length)).forEach(t->System.out.print(t +"' nin uzunlugu : " + t.length()+" "));
		//Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
		System.out.println(" ");
		list.stream().distinct().sorted(Comparator.comparing(t->t.toString().
				substring(t.toString().length()-1))).forEach(t->System.out.print(t + " "));
		//Konsoldaki farklı öğeleri ters sırada yazdırın.
		System.out.println(" ");
		list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t->System.out.print(t + " "));
		//Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
		System.out.println(" ");
		list.stream().filter(t->t.length()<7).sorted(Comparator.reverseOrder()).map(String::toUpperCase).forEach(t->System.out.print(t + " "));
		
	}


}
