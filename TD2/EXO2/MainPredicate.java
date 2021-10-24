
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
        Predicate <Integer>  inCorrectTaille =tailleTropPetite.or(tailleTropGrande);

        // taille correcte (par composition) 
        Predicate <Integer>  correctTaille =inCorrectTaille.negate();

       // poids correct (par composition)
       Predicate<Double> correctPoids = poidsTropLourd.negate();
       
        //accès autorisé (par composition)
        Predicate <Paire<Integer,Double>> predicateCorrect =(Paire<Integer,Double> val)-> val.fst>100 && val.fst>200 && val.snd<150.0 ;
        System.out.println(predicateCorrect.test(new Paire(150,140.5)));
        


        // test 
        // Predicate <Paire<Integer,Double>>  predicateCorrect =(Paire<Integer,Double> val)-> val.fst<100   && val.snd>150.0 ;  
        // System.out.println(predicateCorrect.test(new Paire(1,1.5)));
        
        List<Integer> elemIntegers = Arrays.asList(100,50,300);
        List<Predicate<Integer>> elemsPredicates =Arrays.asList(tailleTropGrande,tailleTropPetite);
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
