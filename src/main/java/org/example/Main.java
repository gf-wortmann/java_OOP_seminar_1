package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main ( String[] args ) {
        Random position = new Random (  ); //for index of being selected man's family in generation and the family's index in it's generation
        Genus genus = new Genus ();
        Generation selectedGeneration;
        Family selectedFamily;
        Human selectedHuman;

        genus.produceGenus ();
        selectedGeneration = genus.getGenus ().get (position.ints ( 1,genus.getGenus ().size ()-1 ).findFirst ().getAsInt ()) ;
        selectedFamily = selectedGeneration.getGeneration ().get (position.ints ( 0, selectedGeneration.getGenerationSize () ).findFirst ().getAsInt ());
        System.out.println ( "selectedFamily = " + selectedFamily.getChildrenSet ().size () + " id "+ selectedFamily.getId ());
        selectedHuman = selectedFamily.getHusband ();

        System.out.println ( " Count of people in the genus:  " + Human.getHumanCounter () );
        System.out.println ( "Selected human = " + selectedHuman + "from family of " + selectedHuman.getParents ().getHusband ().getName () + " and "
                + selectedHuman.getParents ().getWife ().getName () + " born in generation  " + selectedGeneration.getId () + " from the origin. Totally " + genus.getGenus ().size ()) ;
        System.out.println ( "his children, totally "+selectedHuman.getChildrenSet ().size ()) ;

        DescendantsTree tree = new DescendantsTree ( selectedHuman );
        tree.findAllDescendants ( genus );
        System.out.println ( "All descendants of the selected human are:: " + tree);
    }
}