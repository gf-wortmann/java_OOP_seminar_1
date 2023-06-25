package org.example;

import java.util.*;

public abstract class Tree implements Iterator, Comparable <Human> {
    private  int index = 0;
    private Human human;
    private HashSet <Human> tree;

    private void init(){
        tree = new HashSet <> (  ) ;
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

    @Override
    public boolean hasNext ( ) {
        if (++index < this.tree.size ()){
            return true;
        }else return false;
    }

    @Override
    public Object next ( ) {
        return this.tree.iterator ().next ();
    }

//    @Override
//    public int compare ( Object o1 , Object o2 ) {
//        return 0;
//    }


    @Override
    public int compareTo ( Human human ) {
        return Integer.compare ( this.human.getId (),  human .getId ());
    }
    public  List <Human> getTreeAsList (){
        return new ArrayList<> (this.tree);
    }

    public  List<Human> treeSortedById(){
        List <Human> res =  getTreeAsList ();
        res.sort ( new HumanComparatorById () );
        return res;
    }   public  List<Human> treeSortedByName(){
        List <Human> res =  getTreeAsList ();
        res.sort ( new HumanComparatorByName () );
        return res;
    }

}


