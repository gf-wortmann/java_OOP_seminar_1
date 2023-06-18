package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Generation implements Serializable {
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
                int minChildrenCount = 5;
                for ( int i = 0 ; i < childrenCount.ints ( minChildrenCount , maxChildrenCount ).findFirst ( ).getAsInt ( ) ; i++ ) {
                    family.giveBirth ();
                }
            }
        }
        this.marryPairs ();
    }
    private void marryPairs (){
        ArrayList<Family> ancestors  = new ArrayList<> ();
        ArrayList<Marryable> grooms = new ArrayList<> ();
        ArrayList<Marryable> brides = new ArrayList<> ();
//        System.out.println ( "!generation = " + generation.size () );
        for ( Family family :this.generation  ) {
            ancestors.add ( family );
            }
        for ( Family family: this.generation  ) {
            for ( Marryable mm:  family.getChildrenSet ()   ) {
                if ( mm.getClass () == Male.class )  grooms.add  ((Male) mm );
                if ( mm.getClass () == Female.class )  brides.add ( (Female) mm);
            }
        }
//        System.out.println ( "grooms = " + grooms.size () );
//        System.out.println ( "brides = " + brides.size () );
        while ( !grooms.isEmpty () && !brides.isEmpty ()) {
            Marryable groom = grooms.iterator ( ).next ( );
            Marryable bride = brides.iterator ( ).next ( );
            this.addFamily ( new Family ( (Male) groom , (Female) bride ) );
            grooms.remove ( groom );
            brides.remove ( bride );
        }
        generation.removeAll ( ancestors );
//        System.out.println ( ">generation = " + generation.size () );
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
