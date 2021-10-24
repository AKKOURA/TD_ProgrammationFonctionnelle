import java.util.List;
import java.util.stream.*;
import java.util.Map;
public class Main {

    public static void main(String[] args){
     //Lambdas sur un seul String
    ToString<Integer> IntToString=(Integer a)->"" + a ;
    System.out.println(IntToString.convertir(25));


    // //Lambdas sur une liste
    List <String> list=List.of("A9","A1","A2");
    ToString<List<String>> listToString=c->c.stream().reduce("",(String a, String b)->a+","+b);        
    System.out.println(listToString.convertir(list));   
    // //Lambdas  pour une map
    // Map hmap = new HashMap();
    // hmap.put("1", "e1");
    // hmap.put("2", "e2");
    // hmap.put("3", "e3");  
	// ToString<Map<String, String>> mapToString =map->map.stream().reduce("", (Map<String, String> e)->e.getKey() + " : " + e.getValue());
    // ToString<Map<String,String>> mapToString =hmap.forEach((Map.Entry<String, String> entry)-> entry.getKey() + " : " + entry.getValue() );
    // hmap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    Map<Integer, String> map = new HashMap<Integer, String>();
    map.put(1, "foo");
    map.put(2, "bar");
    map.put(3, "baz");
    ToString<Map<Integer, String>> result = map.entrySet()
        .stream()
        .reduce("", (Map.Entry<Integer,String> e)->e.getKey() + " : " + e.getValue());
   

    System.out.println(result.convertir(map)); 
    

    } 
}
