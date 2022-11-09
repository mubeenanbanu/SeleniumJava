package javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<String>();
		names.add("mubeena");
		names.add("mahin");
		names.add("hydera");
		long a=names.stream().filter(s->s.length()>5).count();
		names.stream().filter(s->s.startsWith("m")).forEach(s->System.out.println(s));
		System.out.println(a);
	Stream.of("mubeena","dom","john","banu").filter(s->s.contains("a")).map(s->s.toUpperCase()).
	forEach(s->System.out.println(s));
		
	System.out.println("------");
	Stream.of("mubeena","dom","john","banu").filter(s->s.contains("a")).sorted().map(s->s.toUpperCase()).
	forEach(s->System.out.println(s));
	
	List<String> names2=Arrays.asList("API Automation","java selenium","c# selenium","devops");
	names2.stream().filter(w -> w.startsWith("j")).map(m->m.toLowerCase()).forEach(f->System.out.println(f));
	//conacatenate
	Stream newstream=Stream.concat(names.stream(),names2.stream());
	//newstream.forEach(s->System.out.println(s));
	boolean b=newstream.anyMatch(f->((String) f).equalsIgnoreCase("mahin"));
	System.out.println(b);
	//only print 2 values
//	names.stream().filter(s->s.contains("a")).limit(2).forEach(f->(System.out.println(f)));
//	//get any value
//	List ls=names2.collect(Collector.toList());
	
	
	}

}
