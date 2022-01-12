package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q05 {
    //         {"A", "B", "D", "C", "B", "A", "A", "B", "B"} gibi bir array oluşturun;
//         Tekrarlanan öğeleri konsolda yazdırın
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>(Arrays.asList("A", "B", "D", "C", "B", "A", "A", "B", "B"));
		System.out.println(list);
		
		list.stream()
        .filter(t -> Collections.frequency(list, t) > 1)
        .collect(Collectors.toSet())
        .forEach(t -> System.out.println(t));
		
	}
}
