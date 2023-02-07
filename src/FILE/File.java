package FILE;

import java.io.*;
import java.util.ArrayList;

public class File {
    public static ArrayList<Person> list = new ArrayList<>();

    public static void add() {
        list=InputStream("C:\\module2\\Filetest\\src\\FILE\\File");
//        list.add(new Person(1, "Vũ", 25));
//        list.add(new Person(2, "Nam", 23));
    }

    public static void OutputStream(String path, ArrayList<Person> list) {

        try {
            FileOutputStream ops = new FileOutputStream(path);
            ObjectOutputStream obs = new ObjectOutputStream(ops);
            obs.writeObject(list);
            obs.close();
            ops.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> InputStream(String path) {
        ArrayList<Person> list1 = new ArrayList<>();

        try {
            FileInputStream ips = new FileInputStream(path);
            if (ips.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(ips);
                list1 = (ArrayList<Person>) ois.readObject();
                ois.close();
                ips.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list1;
    }

    public static void main(String[] args) {
        add();
        OutputStream("C:\\module2\\Filetest\\src\\FILE\\File",list);
        for (Person p:list) {
            System.out.println(p);
        }
    }
}
