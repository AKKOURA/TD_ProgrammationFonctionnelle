import java.util.function.*;
public class MainPredicate {
    
    public static void main(String[] args){
        Predicate<Integer> tailleTropPetite = (Integer taille )-> taille <100;
        Predicate<Integer> tailleTropGrande = (Integer taille )-> taille >200;
        Predicate<Double> poidsTropLourd = (Double poids  )-> poids >150.0;
        //• taille incorrecte (par composition) revoie false 

        System.out.println(tailleTropPetite.test(90)); // true
        System.out.println(tailleTropPetite.negate()); // false
        


    
     } 
    //   // Composition of a function with a predicate
    // public static <T, S> Predicate<T> compose(Function<T, S> first, Predicate<S> second) {
    //     return input -> second.test(first.apply(input));
    // }
   
}
