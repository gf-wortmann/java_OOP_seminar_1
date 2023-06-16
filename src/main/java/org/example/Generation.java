package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Generation {
    private static int generationCount = 0;
    private final int id;
    private final Random childrenCount;
    private ArrayList <Family> generation;

    public  void initGeneration(ArrayList generation){
//        if (this.generation.size () == 0){
            this.generation=generation ;
//        }
    }
    public Generation ( ) {
        this.generation = new ArrayList <> ();
        this.id = generationCount++;
        this.childrenCount = new Random (  );
    }

    public static int getGenerationCount ( ) {
        return generationCount;
    }

    @Override
    public String toString ( ) {
        return "Generation{" +
                "id=" + id +
                ", generation=" + generation +
                '}';
    }

    public ArrayList < Family > getGeneration ( ) {
        return generation;
    }

    public int getGenerationSize(){
        return this.generation.size ();
    }
    public void addFamily(Family family){
        this.generation.add ( family );
    }
    public void produceGeneration(){
        if(this.generation.size ()>0){
            for ( Family family : this.generation ){
                int maxChildrenCount = 8;
                int minChiulrenCount = 5;
                for ( int i = 0 ; i < childrenCount.ints ( minChiulrenCount , maxChildrenCount ).findFirst ( ).getAsInt ( ) ; i++ ) {
                    family.giveBirth ();
                }
            }
        }
        this.marryPairs ();
    }
    private void marryPairs (){
        ArrayList <Male> grooms = new ArrayList<> ();
        ArrayList <Female> brides = new ArrayList<> ();
        ArrayList<Family> ancestors  = new ArrayList<> ();

        for ( Family family :this.generation  ) {
            ancestors.add ( family );
            for ( Human human: family.getChildrenSet () ) {
                if(human.getClass () == Male.class ) grooms.add ( (Male) human );
                else if (human.getClass () == Female.class ) brides.add ( (Female) human);
                }
            }
        while ( !grooms.isEmpty () && !brides.isEmpty ()) {
            Human groom = grooms.iterator ( ).next ( );
            Human bride = brides.iterator ( ).next ( );
            this.addFamily ( new Family ( (Male) groom , (Female) bride ) );
            grooms.remove ( groom );
            brides.remove ( bride );
        }
        generation.removeAll ( ancestors );
    }
    Family getFamilyById ( int id){
//        Family result = new Family (  );
        for ( Family family : this.generation ) {
            if (family.getId () == id) return family;
        }
        return null;
    }
    public boolean familyByIdPresent(int id){
        for ( Family family: this.generation ) {
            if (family.getId () == id) return true;
        }
        return false;
    }

    public int getId ( ) {
        return id;
    }
}
