package com.quintrix.jfs.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.quintrix.jfs.models.Cat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       List<Cat> cats = new ArrayList<>();
       
       cats.add(new Cat(1, "Callie", 12, "Callico"));
       cats.add(new Cat(2, "Einstien", 11, "Spotted"));
       cats.add(new Cat(3, "Feynman", 5, "Tuxedo"));
       cats.add(new Cat(4, "Maxwell", 12, "Spotted"));
       cats.add(new Cat(5, "Morris", 12, "Orange"));
       
       Stream olderCats = cats.stream().filter(c -> c.getAge() > 10); // intermediate
       
       Stream vegStream = Stream.of("tomoto", "Green Chilli", "Pototo"); // intermediate
       Stream sortedStream = vegStream.sorted();
       sortedStream.forEach(name -> System.out.println(name));
       
       List<Cat> oldCats = cats.stream().filter(c -> c.getAge() > 10).collect(Collectors.toList()); // terminal      
       System.out.println(oldCats);
       
       cats.stream().filter((c) -> c.getName().startsWith("E")).forEach(System.out :: println); // terminal    
           
      List<String> catNames = cats.stream().map(Cat::getName).collect(Collectors.toList());     // terminal
      catNames.forEach(System.out :: println);
      
     catNames.stream().sorted().map(String::toUpperCase) // intermediate
              .forEach(System.out::println);
       
    }
}
