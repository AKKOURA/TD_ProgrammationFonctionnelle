
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
        taillepetiteAndPoidsLourd.toString();
         
        


    
     } 
   
}
