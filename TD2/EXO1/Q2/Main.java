import java.util.List;
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
    Map<String, String>  hmap = new HashMap();
    hmap.put(1, "e1");
    hmap.put(2, "e2");
    hmap.put(3, "e3");  
	ToString<Map<String, String>> mapToString =map->map.stream().reduce("", (Map<String, String> e)->e.getKey() + " : " + e.getValue());	
    System.out.println(mapToString.convertir(hmap)); 
    

    } 
}
