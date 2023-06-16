package org.example;

public class Male extends Human{
    private Female wife;

    public Male ( String name ) {
        super ( name );
    }

    public Male ( String name , Pair parents ) {
        super ( name , parents );
    }

    public void merry (Female wife) {
        this.wife = wife;
    }

    public Female getWife ( ) {
        return wife;
    }
}
