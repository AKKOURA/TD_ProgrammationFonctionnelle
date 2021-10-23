import java.util.List;
public class Main {

    public static void main(String[] args){
     //Lambdas sur un seul String
    ToString<Integer> IntToString=(Integer a)->"" + a ;
    System.out.println(IntToString.convertir(25));


    // //Lambdas sur une liste
    List <String> list=List.of("A9","A1","A2");
    ToString<List<String>> listToString=c->c.stream().reduce("",(String a, String b)->a+","+b);        
    System.out.println(listToString.convertir(list));   
    } 
}
