
public class Paire <A,B> {
    private A x;
    private B y;
    
     public Paire(A x, B y) {
        this.x = x;
        this.y = y;
    }


    public A fst() {
        return x;
    }

    public B snd() {
        return y;
    }

    public <C> Paire<C,B> changeFst(C x1) {
        return  new Paire(x1 ,this.y);
    }

    public <C> Paire <A,C> changeSnd(C y1) {
        
        return new Paire(this.x ,y1);
    }
    
    
    @Override
    public String toString(){   
       return "(" +this.x + ", " + this.y + ") :: Paire[" + this.x.getClass().getSimpleName() +" , "+this.y.getClass().getSimpleName() + "]";
    }

   
}
