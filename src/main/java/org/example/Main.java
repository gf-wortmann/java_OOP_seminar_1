package org.example;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main ( String[] args ) throws IOException, ClassNotFoundException {
        Random position = new Random (  ); //for index of being selected man's family in generation and the family's index in it's generation
        Genus genus = new Genus ();
//        Generation selectedGeneration;
//        Family selectedFamily;
        Human selectedHuman;

        genus.produceGenus ();
        selectedHuman = getHuman ( position , genus );

        DescendantsTree tree = new DescendantsTree ( selectedHuman );
        tree.findAllDescendants ( genus );
        System.out.println ( "All descendants of the selected human are:: " + tree);

        System.out.println ("test of save and restore\n" );
        System.out.println ( "genus before save = " + genus.getGenerationsCount () );

        FileHandler f = new FileHandler (  );
            f.save ( genus, "Genus.dat" );
        Genus genus2 = new Genus ();
        genus2 = f.restore ( genus2, "Genus.dat" );
        System.out.println ( "genus restored= " + genus2.getGenerationsCount () + "\n");


        selectedHuman = getHuman ( position, genus2 );
        DescendantsTree tree2 = new DescendantsTree ( selectedHuman );
        tree2.findAllDescendants ( genus2);
        System.out.println ( "All descendants of the selected human are:: " + tree2);

    }

    private static Human getHuman ( Random position , Genus genus ) {
        Generation selectedGeneration;
        Human selectedHuman;
        Family selectedFamily;
        selectedGeneration = genus.getGenus ( ).get ( position.ints ( 1, genus.getGenus ( ).size ( )-1 ).findFirst ( ).getAsInt ( ) ) ;
        selectedFamily = selectedGeneration.getGeneration ().get ( position.ints ( 0, selectedGeneration.getGenerationSize ( ) ).findFirst ( ).getAsInt ( ) );
        selectedHuman = selectedFamily.getHusband ();

        System.out.println ( "Count of people in the genus:  " + Human.getHumanCounter () );
        System.out.println ( "SelectedFamily = " + selectedFamily.getChildrenSet ().size () + " id "+ selectedFamily.getId ());
        System.out.println ( "Selected human = " + selectedHuman + "from family of " + selectedHuman.getParents ().getHusband ().getName () + " and "
                + selectedHuman.getParents ().getWife ().getName () + " born in generation  " + selectedGeneration.getId () + " from the origin. Totally " + genus.getGenus ( ).size ( ) + " generations") ;
        System.out.println ( "his children, totally "+selectedHuman.getChildrenSet ().size ()) ;

        return selectedHuman;
    }
}