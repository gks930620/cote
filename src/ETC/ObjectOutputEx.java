package ETC;

import java.io.*;

public class ObjectOutputEx {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("C:/workspace/temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ClassA classAOriginal = new ClassA();
        classAOriginal.field1 = 1;

        oos.writeObject(classAOriginal);

        oos.flush();
        oos.close();
        fos.close();
    }
}