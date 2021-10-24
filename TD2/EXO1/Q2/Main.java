import java.util.HashMap;
import java.util.List;
import java.util.stream.*;
import java.util.Map;
public class Main {

    public static void main(String[] args){
     //Lambdas sur un seul String
    ToString<Integer> IntToString=(Integer a)->"" + a ;
    System.out.println(IntToString.convertir(25));


    // //Lambdas sur une liste
    List <String> listt=List.of("A9","A1","A2");
    //autre mé
    // ToString<List<String>> listToString=c->c.stream().reduce("",(String a, String b)->a+","+b);  
    ToString<List<String>> listToString =(List<String> list)->{for(int i =0 ;i<list.size();i++) System.out.print(list.get(i) +","); return "" ;  };
    System.out.println(listToString.convertir(listt));   
 
    Map<Integer, String> map = new HashMap<Integer, String>();
    map.put(1, "foo");
    map.put(2, "bar");
    map.put(3, "baz");

    ToString<Map<Integer, String>> mapToString =(Map<Integer, String> mapp)->
    {  mapp.forEach((k, v) -> System.out.print( k + " : " + v+ " , ")); return "" ;   };
    System.out.println(mapToString .convertir(map)); 
    

    } 
}
