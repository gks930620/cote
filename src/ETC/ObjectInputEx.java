package ETC;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputEx {

    public static void main(String[] args)  throws  Exception{

        FileInputStream fis= new FileInputStream("C:/workspace/temp.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        ClassA classAFromFile=(ClassA) ois.readObject();
        System.out.println("classAFromFile.field = " + classAFromFile.field1);

    }
}
