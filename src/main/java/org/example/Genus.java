package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Genus {
    private static Family initialFamily;
    private static final Male progenitor = new Male ( "Adam" );
    private static final Female progenitress = new Female ( "Eva" );
    private static final int minGenerationsCount = 6;
    private static final int maxGenerationsCount = 10;

    private final ArrayList <Generation> genus;

    private final Random generationsCount;
    public Genus ( ) {
        this.genus = new ArrayList<> ();
        initialFamily = new Family ( progenitor, progenitress );
        generationsCount = new Random (  );
    }

    public ArrayList < Generation > getGenus ( ) {
        return genus;
    }

    private   void newGeneration(){
//        int ancestorsIndex = this.genus.size () -1;
        Generation generation = new Generation ();
        ArrayList < Family > ancestors =
                new ArrayList <> ( this.genus.get ( this.genus.size ( ) - 1 ).getGeneration ( ) );
        generation.initGeneration ( ancestors);
        generation.produceGeneration ();
        this.genus.add ( generation );
    }

    public  void  produceGenus(){
        initGenus ();
        for ( int i = 0 ; i < generationsCount.ints ( minGenerationsCount, maxGenerationsCount ).findFirst ().getAsInt () ; i++ ) {
            newGeneration ();
        }

    }
    private  void  initGenus(){
        if (this.genus.isEmpty ()){
            Generation generation = new Generation ();
            ArrayList <Family> ancestors = new ArrayList<> ();
            ancestors.add ( initialFamily );
            generation.initGeneration ( ancestors );
            this.genus.add ( generation );
        }

    }
    public  String generationList(){
        StringBuilder r = new StringBuilder ();
        for ( Generation g: this.genus ) {
            r.append ("Gen Id: "+ g.getId () + " Gen progenitor  "+  g.getGeneration ().get ( 0 ).getHusband () + " first family: "+ g.getGeneration ().get ( 0 ).getId ()+"\n");
        }
        return r.toString ();
    }
    public  int getGenerationsCount(){
        return  this.genus.size ();
    }
}
