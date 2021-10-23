
import java.util.Set;





public  class Feuille implements Arbre {
    private Integer f;

    public Feuille(Integer f) {
        this.f = f;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    @Override
    public boolean contient(Integer val) {
        if(f.equals(val)){
            return true;
        }
        return false;
    }

    @Override
    public int taille() {
       return 1;
    
    }

    @Override
    public Set<Integer> valeurs() {
        return Set.of(this.f);
       
    }

    @Override
    public Integer somme() {
      return this.f ;
    }

    @Override
    public Integer min() {
       return this.f ;
    }

    @Override
    public Integer max() {
       return this.f ;
    }

    @Override
    public boolean estTrie() {
       return true;
    }

  

    
  
    

}
