public class MainQ1
 {
    public static void main(String[] args){
        Somme<Integer> sommeInteger = ( Integer x,Integer y)->{return x+y;};
        System.out.println(sommeInteger.sommer(5,1));
   

        Somme<String> sommeString = ( String x,String y)->{return x+y;};
        System.out.println(sommeString.sommer("5","1"));
   

        Somme<Double> sommeDouble = ( Double x,Double y)->{return x+y;};
        System.out.println(sommeDouble.sommer(5.0,1.6));

        
        Somme<Long> sommeLong = ( Long x,Long y)->{return x+y;};
        System.out.println(sommeLong.sommer( 0l, 0l));
   
   

    }
    
}
