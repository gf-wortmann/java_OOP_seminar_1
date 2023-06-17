package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Names {
    private final ArrayList <String> maleNames = new ArrayList<> ( Arrays.asList (
            "Alexander","Allen","Angelo","Arjun","Basilius","Bert","Brandon","Charles","Daniil","Dylan"
            ,"Edward","Isaac","Messiah","Misael","Nikolaus","Rogelio","Roland","Santos","Turner","Yehudi"
                                                                                 ));
    private final ArrayList<String> femaleNames = new ArrayList <> ( Arrays.asList (
            "Aisha","Alexandra","Alessia","Alexa","Allie"
            ,"Cassandra","Celina","Davina","Emilia","Faith","Inessa","Katherine"
            ,"Natalie","Paris","Rosalia","Ruth","Silvia","Serena","Stella","Vanessa"
                                                                                   ) );

    public Names ( ) {
    }

    public String getRandomMaleName(){
        int index = new Random (  ).ints ( 0, maleNames.size ( ) ).findFirst ().getAsInt ();
        return maleNames.get ( index );
    }
    public String getRandomFemaleName(){
        int index = new Random (  ).ints ( 0, maleNames.size ( ) ).findFirst ().getAsInt ();
        return femaleNames.get ( index );
    }
}
