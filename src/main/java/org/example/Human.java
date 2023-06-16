package org.example;

import java.util.HashSet;

public abstract class Human {
    public static int getHumanCounter ( ) {
        return humanCounter;
    }

    private static int humanCounter = 0;
    private int id;
    private String name;
    private Pair parents;
    private HashSet <Human> childrenSet;
    public Human ( ) {
    }

    public Human ( String name ) {
        this.init ( name );
    }

    public Human ( String name, Pair parents ) {
        this.parents = parents;
        this.init (name );
    }

    public int getId ( ) {
        return id;
    }

    public String getName ( ) {
        return name;
    }

    public Pair getParents ( ) {
        return parents;
    }


    public HashSet < Human > getChildrenSet ( ) {
        return childrenSet;
    }

    public void setChildrenSet ( HashSet < Human > childrenSet ) {
        this.childrenSet = childrenSet;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    private void init ( String name ){
        this.name = name;
        this.childrenSet = new HashSet<> ();
        this.id = humanCounter++;
    }
    public void addChild (Human child){
        childrenSet.add ( child );
    }

    @Override
    public String toString ( ) {
        return "Human{" +
                "id=" + id +
                ", name='" + name +
                "}" + "\n";
    }

    public void setParents ( Pair parents ) {
        this.parents = parents;
    }
}
