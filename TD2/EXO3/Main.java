import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);
        afficheSi("**TOUS LES ETUDIANTS ", a->true, a1);

        Predicate<Etudiant> aNoteEliminatoire = (etud)->{
            for (Double note : etud.notes().values()) {
                if(note<6)
                return true;        
            }
            return false;
        };
      afficheSi("**ETUDIANTS AVEC NOTE ELIMINATOIRE ", aNoteEliminatoire, a1);
           
     //Q2
     Predicate<Etudiant> aDEF  = (etud)->{
        for (UE ue : etud.annee().ues()) {
            for(Map.Entry<Matiere,Integer> ects:ue.ects().entrySet()){
                 //l'etudiant qui n'a pas de note pour une matiere ou plus
                 if(!etud.notes().containsKey(ects.getKey())){
                    return true;
                }
            }
        }        
        return false;
     };
     afficheSi("**LES ETUDIANT DEFAILLANTS", aDEF, a1);
     System.out.println(" la moyenne de l'étudiant " +e1.nom() + "est" + e1.moyenneEtudiant(e1, aDEF ,));

    }
    public static void afficheSi(String enTete, Predicate<Etudiant> predSudent, Annee annee) {
        System.out.println(enTete);
        for (Etudiant elem : annee.etudiants()) {
            if (predSudent.test(elem)) {
                System.out.println(elem.toString());
            }
        }
    }

    
        
       
    
}
