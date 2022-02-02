package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lambda02_File {

	public static void main(String[] args) throws IOException {
		 //TASK 01 --> test.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** test.txt dosyasini okuyunuz -->  ");
        Files.lines(Paths.get("src\\day05\\test.txt")).//file erisip file satirlari akis alindi
        forEach(System.out::println);
               
        //TASK 02 --> test.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** test.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src\\day05\\test.txt")).map(t->t.toUpperCase()).forEach(System.out::println);
        
       
        //TASK 03 --> test.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** test.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.lines(Paths.get("src\\day05\\test.txt")).limit(1).map(String::toLowerCase).forEach(System.out::println);     
        
        //TASK 04 --> test.txt dosyasinda "test" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** test.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(Paths.get("src\\day05\\test.txt")).filter(t->t.contains("test")).count());
        
               
        //TASK 05 --> test.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** test.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.lines(Paths.get("src\\day05\\test.txt")).map(t->t.split(" ")).//satirlari kelimeye cevirdik ve Array olustu
        		flatMap(Arrays::stream).//array elemanlarini tekrar stream e soktu
        		distinct().//elemanlari teklestirdi
        		toList());
        
        /* 
        //TASK 06 --> test.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** test.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        
        //TASK 07 --> test.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** test.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        
        //TASK 08 --> test.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** test.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        //TASK 09 --> test.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** test.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        
        //TASK 10 --> test.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** test.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        //TASK 11 --> test.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** test.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

*/
	}

}
