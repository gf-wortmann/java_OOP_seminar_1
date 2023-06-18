package org.example;

public class Male extends Human{
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
