package org.example;

import java.io.Serializable;
import java.util.Iterator;

public class Female extends Human implements Serializable {
    private Male husband;

    public Female ( String name ) {
        super ( name );
    }

    public Female ( String name , Pair parents ) {
        super ( name , parents );
    }

    public Female ( ) {
    }

    public void marry ( Marryable husband ) {this.husband = (Male) husband;
    }
    public Male getHusband ( ) {
        return husband;
    }

//    @Override
//    public int compareTo ( Object o ) {
//        Human hh = (Human) o;
//        return Integer.compare ( this.getId (), hh.getId() );
//    }

//    @Override
//    public Iterator iterator ( ) {
//        return null;
//    }
}
