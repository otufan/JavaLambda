package Lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q08 {
    // 7 ile bolunebilen ilk 10 tamsayinin toplamini ekrana yazdiriniz.
	
	public static void main(String[] args) {
		
		 int flag=0;
		 int num=1;
		 List<Integer> list=new ArrayList<>();
		 
		 
		 while (flag!=7) {
			
			 if(num%7==0) {
				 list.add(num);
				 flag++;
			 
		}
			 num++;
							
	}
		 System.out.println(list);
		 
		 int result=list.stream().reduce(Integer::sum).get().intValue();
		 
		 System.out.println(result);
}
}
