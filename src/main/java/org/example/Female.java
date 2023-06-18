package org.example;

import java.io.Serializable;

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

}
