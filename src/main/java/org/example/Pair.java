package org.example;

public abstract class Pair {
    private static int pairCounter = 0;
    private int id;
    private Male husband;
    private Female wife;

    public void marry ( ){
        husband.merry ( wife );
        wife.merry ( husband );
    }

    private void init (){
        this.id = pairCounter++;
//        System.out.println ( "Pair Id = " + this.id );
    }
    public Pair (  ) {
        init ();
    }

    public Pair ( Male husband , Female wife ) {
        init ();
        this.husband = husband;
        this.wife = wife;
//        System.out.println ( "husband = " + this.husband + " wife = "+ this.wife);
    }

    public Male getHusband ( ) {
        return husband;
    }

    public Female getWife ( ) {
        return wife;
    }

    public int getId ( ) {
        return id;
    }

    @Override
    public String toString ( ) {
        return "Pair{" +
                "husband=" + husband +
                ", wife=" + wife +
                '}';
    }

}
