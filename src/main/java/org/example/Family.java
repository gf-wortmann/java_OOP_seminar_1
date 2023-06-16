package org.example;

import java.util.HashSet;
import java.util.Random;

public class Family extends Pair{
    private HashSet <Human> childrenSet;
    private Random childGender;

    public Family ( Male husband , Female wife ) {
        super ( husband , wife );
        this.marry ( );
        this.childrenSet = new HashSet<> ();
        this.childGender = new Random ();
    }

    @Override
    public void marry ( ) {
        super.marry ( );
    }

    public HashSet < Human > getChildrenSet ( ) {
        return childrenSet;
    }

    public void giveBirth(){
        int nextChildGender = childGender.ints ( 0,2 ).findFirst ().getAsInt ();
        if (nextChildGender == 1)childrenSet.add ( new Male ( new Names ().getRandomMaleName () ,  this ));
        else if ( nextChildGender == 0 ) childrenSet.add ( new Female ( new Names ().getRandomFemaleName (), this  ) );
        super.getHusband ().setChildrenSet ( this.childrenSet );
        super.getWife ().setChildrenSet ( this.childrenSet );
    }

    @Override
    public String toString ( ) {
        return "Family{" +
                super.toString ()+
                " grandparents: " + super.getHusband ().getParents ().getHusband ()
                + super.getHusband ().getParents ().getWife () +" "
                + super.getWife ().getParents ().getHusband () +" "
                + super.getWife ().getParents ().getWife ()
                +
                " children=" + childrenSet +
                '}';
    }
}
