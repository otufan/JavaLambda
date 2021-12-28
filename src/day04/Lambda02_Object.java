package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda02_Object {

	private static List<TechPro> sonuc;

	public static void main(String[] args) {
		
		TechPro trGunduz=new TechPro("yaz", "TR gunduz", 97, 124);
		TechPro engGunduz=new TechPro("kis", "ENG gunduz", 95, 131);
		TechPro trGece=new TechPro("bahar", "TR gece", 98, 143);
		TechPro engGece=new TechPro("sonbahar", "ENG gece", 93, 151);
		
		List<TechPro> list=new ArrayList<>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));
		
	
	//bu class da agirlikli return type calisacagiz	
		
		System.out.println(batchDoksanikiBuyuk(list));
		ogr110Kontrol(list);
		baharKontrol(list);
		System.out.println(ogrnSayiMaxMin(list));
		System.out.println(batchOrtIlkUcMaxMin(list));
		minIkinciOgrnSayisi(list);
		System.out.println(ortOgr95denBuyukOgrTopl(list));
		System.out.println(ortOgr95denBuyukOgrTopl1(list));
		System.out.println(ogr130FazlaBatchlerinOrt(list));
	}

	
	//task 01-- batch ort larinin 92 den buyuk old kontrol eden bir prg create ediniz
	
	
	public static boolean batchDoksanikiBuyuk(List<TechPro>  list) {
		
		return list.stream().allMatch(t->t.getBetchOrt()>92);
			
	}
	
	//ogrenci sayilarinin hicbirinin 110 dan az olmadigini kontrol eden bir methpod yaziniz
	
	public static void ogr110Kontrol(List<TechPro>  list) {
		
		boolean kontrol=list.stream().allMatch(t->t.getOgrSayisi()>=110);
		System.out.println(kontrol?"butun batch ogrenci sayisi 100 dan FAZLA" : "butun batch ogrenci sayisi 100 dan AZ");
	}
	
	//batch lerde herhangi birinde bahar olup olmadigini kontrol ediniz
	
	public static void baharKontrol(List<TechPro>  list) {
		
		boolean kontrol=list.stream().anyMatch(t->t.getBatch().equalsIgnoreCase("bahar"));
				//contains("bahar"));
		System.out.println(kontrol?"bahar batch VAR" : "bahar batch i YOK");
	}
	
	//bstch leri ogrenci sayilarina gore buyukten kucuge siralayiniz
	public static List<TechPro> ogrnSayiMaxMin(List<TechPro>  list) {
		return
		list.stream().sorted(Comparator.comparing(TechPro::getOgrSayisi).reversed()).
				collect(Collectors.toList());//akisdaki elemanlari istenen sarta gore toplar
					//Bu parametre ile topla dedik
	
	}
	
	//batch leri batch ortalamalarina gore max min ilk 3 yazdiriniz
	public static List<TechPro> batchOrtIlkUcMaxMin(List<TechPro>  list) {
		return
		list.stream().sorted(Comparator.comparing(TechPro::getBetchOrt).reversed()).limit(3).
				collect(Collectors.toList());
			
	}
	//ogrenci sayisi en az olan 2.batch i yazdiriniz
	public static void minIkinciOgrnSayisi(List<TechPro>  list) {
		
		System.out.println(list.stream().sorted(Comparator.comparing(TechPro::getOgrSayisi)).
				limit(2).skip(1).collect(Collectors.toList()));
		
	}
	
	//batch ortalamalari 95 den buyuk olan batch lerin ogr sayilarini toplamini yazdiriniz
	
	public static int ortOgr95denBuyukOgrTopl(List<TechPro>  list) {
		return list.stream().filter(t->t.getBetchOrt()>95).map(t->t.getOgrSayisi()).reduce(0, Integer::sum);
																						//reduce(0,(w,t)->w+t);
		
	}
	
	public static int ortOgr95denBuyukOgrTopl1(List<TechPro>  list) {
		return list.stream().filter(t->t.getBetchOrt()>95).
mapToInt(t->t.getOgrSayisi()).//bu method ile akisa gelen elemanlari int ceviriyor ve sonrasinda matematiksel islemler yapilabiliyor
			sum(); 				//burada kod kisaldi ve direkt toplamayi cagirdik		
	}
	
	//Ogrenci sayisi 130'dan buyuk olan Batch'lerin batchOrt'larinin ortalamasini bulunuz.
	public static double ogr130FazlaBatchlerinOrt(List<TechPro>  list) {
		return list.stream().filter(t->t.getOgrSayisi()>130).mapToDouble(t->t.getBetchOrt()).
				average().//Burada kodu biraksak return type OptionalDouble olmasi gerekiyor
			getAsDouble();//sonrasinda getAsDouble diyerek double data tipine cevirdik
		
	
	}
}