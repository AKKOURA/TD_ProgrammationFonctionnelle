
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
public class MainPredicate {
    
    public static void main(String[] args){

        //Q1
        Predicate<Integer> tailleTropPetite = (Integer taille )-> taille <100;
        Predicate<Integer> tailleTropGrande = (Integer taille )-> taille >200;
        Predicate<Double> poidsTropLourd = (Double poids  )-> poids >150.0;

        // taille incorrecte (par composition) 
        Predicate <Integer>  inCorrectTaille =
        (Integer taille ) -> tailleTropPetite.test(90) && tailleTropGrande.test(100); //revoie false 

        // taille correcte (par composition) 
        Predicate <Integer>  correctTaille =
        (Integer taille ) -> tailleTropPetite.test(90) && tailleTropGrande.test(300); //revoie true
 

       // poids correct (par composition)
       Predicate<Double> inCorrectPoids = 
       (Double poids) -> poidsTropLourd.test(100.0) || poidsTropLourd.test(150.0);  //revoie false 
       
        //accès autorisé (par composition)

        // test 
        Predicate <Paire<Integer,Double>>  taillepetiteAndPoidsLourd =(Paire<Integer,Double> val)-> val.fst<100   && val.snd>150.0 ;  
        System.out.println(taillepetiteAndPoidsLourd.test(new Paire(1,1.5)));
        
        List<Integer> elemIntegers = Arrays.asList(100,50,70);
        List<Predicate<Integer>> elemsPredicates =Arrays.asList(tailleTropPetite,tailleTropGrande);
        List<Integer> elemList = filtragePredicatif(elemsPredicates,elemIntegers);
        System.out.println(elemList);
 
         
    
     } 
     //Q2
     static <T> List<T> filtragePredicatif(List<Predicate<T>> predicates, List<T> elems){
        List<T> list = new ArrayList<T>() ;
        for(int i=0;i<predicates.size();i++){
            for(int j=0;j<elems.size();j++){
                if(predicates.get(i).test(elems.get(j))==true){
                    list.add(elems.get(j));
                }
            
            }
           
        }
        return list;
        
    }
   
}
