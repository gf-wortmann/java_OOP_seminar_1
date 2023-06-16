package org.example;

public class Main {
    public static void main ( String[] args ) {
        Genus genus = new Genus ();
        genus.produceGenus ();
        Human human = genus.getGenus ().get (  genus.getGenus ().size ()-4 ).getGeneration ().get ( 1 ).getHusband ();
        System.out.println ( " Count of people in the genus:  " + Human.getHumanCounter () );
        System.out.println ( "Selected human = " + human );
        System.out.println ( "his children, totally "+human.getChildrenSet ().size ()+ " people, are: \n"  + human .getChildrenSet ());
        DescendantsTree tree = new DescendantsTree ( human );
        tree.findAllDescendants ( genus );
        System.out.println ( "All descendants of the selected human are:: " + tree);
    }
}