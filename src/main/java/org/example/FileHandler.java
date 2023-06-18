package org.example;

import java.io.*    ;

public class FileHandler implements Serializable {
    public FileHandler ( ) {
    }

//    public FileHandler ( String filename ) {
//    }

    public void save (Genus genus, String fileName)throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream(fileName));
        objectOutputStream.writeObject(genus);
        objectOutputStream.close();
    }

    public Genus  restore (Genus genus, String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName));
        genus = (Genus) objectInputStream.readObject();
        objectInputStream.close();
        return genus;
    }

}
