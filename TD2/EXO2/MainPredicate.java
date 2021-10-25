
import java.util.ArrayList;
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

        List<Predicate<Paire<Integer,Double>>> listpredicats = new ArrayList<>();
        // listpredicats.add(tailleTropGrande);
        listpredicats.add(tailleTropPetite);
        listpredicats.add(poidsTropLourd );

        Paire<Integer,Double> p1 = new Paire<>(50,200.0);
        Paire<Integer,Double> p2 = new Paire<>(144,0.0);
        Paire<Integer,Double> p3 = new Paire<>(220,50.0);

        List<Paire<Integer,Double>> listtaille = new ArrayList<>();
        listtaille.add(p1);
        listtaille.add(p2);
        listtaille.add(p3);

        System.out.println(filtragePredicatif(listpredicats, listtaille));
     } 
     //Q2
     static <T> List<T> filtragePredicatif(List<Predicate<T>> predicates, List<T> elems){
        List<T> list = new ArrayList<T>() ;
        for(T i :elems){
            for(Predicate<T> j : predicates){
                if (j.test(i)==true){
                    if(!list.contains(i)){
                        list.add(i);
                    }
                    
                }   
            }     
        }
        return list;
        
    }
   
}
