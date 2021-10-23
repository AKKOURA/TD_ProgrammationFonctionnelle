
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Noeud implements Arbre {
    private List<Arbre> noeudList ; //noeud ou feuille 
    

    public Noeud(List<Arbre> noeudList) {
        this.noeudList = noeudList;
    }

    @Override
    public int taille() {
        int t = 0;
        if(noeudList.size() == 1){
         return 1;
        }else{
          t=t+1;
          taille();
                  
        }
        return t;
    }

    @Override
    public boolean contient(final Integer val) {
        for (int i = 0; i < noeudList.size(); i++) {
            if(noeudList.get(i).equals(val)){
            return true ;
         }
        
            
        }
          return false;
        
    }

    @Override
    public Set<Integer> valeurs() {
        return null;
       
    }

    @Override
    public Integer somme() {
        Integer s= 0;
        for (int i = 0; i < noeudList.size(); i++) {
            s+= noeudList.get(i);
        }
        return s;
    }

    @Override
    public Integer min() {
       Integer min= 0;
       for (int i = 0; i < noeudList.size(); i++) {
            if((Integer)noeudList.get(i)< min){
                min = noeudList.get(i);
                
            }
        }
       return min;
       
    }

    @Override
    public Integer max() {
       Integer max= 0;
       for (int i = 0; i < noeudList.size(); i++) {
            if((Integer)noeudList.get(i)> max){
                max = noeudList.get(i);
                
            }
        }
       return max;
       
        
    }

    @Override
    public boolean estTrie() {
        return false;
        
    }

    
   
}
