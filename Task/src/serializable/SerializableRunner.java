package serializable;

import java.io.*;

public class SerializableRunner {

    public static void main(String[] args) throws IOException {

        //сериализуем
        FileOutputStream fos = new FileOutputStream("testSerializable.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SerializationExample serializationExample = new SerializationExample();
        oos.writeObject(serializationExample);
        oos.flush();
        oos.close();

        //десериализуем
        FileInputStream fis = new FileInputStream("testSerializable.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            SerializationExample test = (SerializationExample) ois.readObject();
            System.out.println("version = " +test.version);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }





    }

}
