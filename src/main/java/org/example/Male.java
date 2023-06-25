package org.example;

import java.io.Serializable;
import java.util.Iterator;

public class Male extends Human implements Serializable {
    public Male ( ) {
    }

    private Female wife;

    public Male ( String name ) {
        super ( name );
    }

    public Male ( String name , Pair parents ) {
        super ( name , parents );
    }
    @Override
    public void marry ( Marryable wife ) {this.wife = (Female) wife;
    }

    public Female getWife ( ) {
        return wife;
    }

//    @Override
//    public Iterator iterator ( ) {
//        return null;
//    }
}
