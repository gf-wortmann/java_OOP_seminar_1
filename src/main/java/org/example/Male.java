package org.example;

import java.io.Serializable;

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
}
