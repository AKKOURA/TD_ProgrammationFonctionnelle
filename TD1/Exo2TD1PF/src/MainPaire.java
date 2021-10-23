
public class MainPaire {
    public static void main(String[] args) {
     Paire <Integer,String>  p1= new Paire <>(1,"un");
     Paire <Double,String> p3=  p1.changeFst(1.0); 
     Paire <Double,Paire <Integer,String>> p4= p3.changeSnd(p1);
     
        System.out.println(p1.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
    } 
}
