package org.example;

public class Female extends Human{
    private Male husband;

    public Female ( String name ) {
        super ( name );
    }

    public Female ( String name , Pair parents ) {
        super ( name , parents );
    }

    public void merry (Male husband) {
        this.husband = husband;
    }
    public Male getHusband ( ) {
        return husband;
    }

}
