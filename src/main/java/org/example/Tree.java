package org.example;

import org.example.Human;

import java.util.HashSet;

public abstract class Tree {
    private Human human;
    private HashSet <Human> tree;

    private void init(){
        tree = new HashSet <> ();
    }
    public Tree ( ) {
        init ();
    }

    public Tree ( Human human ) {
        this.human = human;
        init ();
    }

    public Human getHuman ( ) {
        return human;
    }

    public HashSet < Human > getTree ( ) {
        return tree;
    }

    public void setHuman ( Human human ) {
        this.human = human;
    }
    public void addInTree(Human human){
        this.tree.add ( human );
    }
    public  void  addAll(HashSet<Human> descendants){
        this.tree.addAll ( descendants );
    }

}


