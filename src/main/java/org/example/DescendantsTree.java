package org.example;

import org.example.*;

import java.util.ArrayList;
import java.util.HashSet;

public class DescendantsTree  extends Tree {
    public DescendantsTree ( Integer id ) {
    }

    public DescendantsTree ( Human human ) {
        super ( human );
    }

    public  void addDescendantsFromFamily ( Family family, Human human ){
        HashSet< Human > descendants = new HashSet <> ();
        for ( Human h: family.getChildrenSet ()  ) {
            if ( h.getParents ().getHusband ().getId () == human.getId ()  ||
                    h.getParents ().getWife ().getId () ==  human.getId ()){
                descendants.add ( h );
            }

        }
        super.addAll ( descendants );
//        System.out.println ( "descendants = " + descendants.size () );
//        descendants.clear ();;
    }

    public void addDescendantsFromGeneration( Generation generation, Human human ){
        for ( Family f: generation.getGeneration () ) {
            addDescendantsFromFamily ( f, human );
        }
    }

    public void addDescendantsFromGenus( Genus genus, Human human ){
        for ( Generation g: genus.getGenus ( ) ) {
            addDescendantsFromGeneration ( g, human );
        }
    }

    public  void findAllDescendants(Genus genus){
        addDescendantsFromGenus ( genus , super.getHuman ());
        HashSet <Human> descendants = new HashSet<> ();
        descendants.addAll ( super.getHuman ().getChildrenSet ());
        for ( int i = 0 ; i < genus.getGenerationsCount () ; i++ ) {
            for ( Human h: descendants  ) {
                addDescendantsFromGenus ( genus, h );
            }
            descendants.clear ();
            descendants.addAll (  super.getTree ());
        }
    }


    @Override
    public String toString ( ) {
        return "Totally  "+ super.getTree ().size () + " descendants: \n" ;//+ super.getTree () ;
    }
}
