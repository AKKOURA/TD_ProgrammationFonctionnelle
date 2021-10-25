
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
public class MainPredicate {
    
    public static void main(String[] args){

        //Q1
        Predicate<Paire<Integer,Double>> tailleTropPetite = (Paire<Integer,Double> taille )-> taille.fst <100;
        Predicate<Paire<Integer,Double>> tailleTropGrande = (Paire<Integer,Double> taille )-> taille.fst >200;
        Predicate<Paire<Integer,Double>> poidsTropLourd = (Paire<Integer,Double> poids  )-> poids.snd >150.0;

        // taille incorrecte (par composition) 
        Predicate <Paire<Integer,Double>>  inCorrectTaille =tailleTropPetite.or(tailleTropGrande);

        // taille correcte (par composition) 
        Predicate <Paire<Integer,Double>>  correctTaille =inCorrectTaille.negate();

       // poids correct (par composition)
       Predicate<Paire<Integer,Double>> correctPoids = poidsTropLourd.negate();
       
        //accès autorisé (par composition)
        Predicate <Paire<Integer,Double>> predicateCorrect =correctPoids.and(correctTaille);
        
        List<Integer> elemIntegers = Arrays.asList(100,50,300);
        List<Predicate<Paire<Integer,Double>>> elemsPredicates =Arrays.asList(tailleTropGrande,tailleTropPetite);
        List<Integer> elemList = filtragePredicatif(elemsPredicates,elemIntegers);
        System.out.println(elemList);   
     } 
     //Q2
     static <T,S,V> List<T> filtragePredicatif(List<Predicate<Paire<S,V>>> predicates, List<T> elems){
        List<T> list = new ArrayList<T>() ;
        for(Predicate i :predicates){
            for(int j=0;j<elems.size();j++){
                if(i.test(elems.get(j))==true){
                    list.add(elems.get(j));
                }   
            }
           
        }
        return list;
        
    }
   
}
