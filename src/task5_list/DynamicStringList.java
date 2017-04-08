package task5_list;
import java.util.Scanner;

interface SimpleList{
    void add(String s);
    String get();
    String get(int id);
    String remove();
    String remove(int id);
    boolean delete();
}

public class DynamicStringList implements SimpleList {
    private String[] str;
    private int size_of_str = 0;
    private int count = 0;

    DynamicStringList(int size_of_str) {
        this.size_of_str = size_of_str;
        str = new String[size_of_str];
    }

    DynamicStringList() {
    }

    @Override
    public void add(String s) {
        String[] new_str;
        if (count == size_of_str)
        {
            size_of_str++;
            new_str = new String[size_of_str];
            if (size_of_str > 1) {
                System.arraycopy(str, 0, new_str, 0, count);
                new_str[count] = s;
                str=new_str;
                count++;
            }
            else{
                new_str[count] = s;
                str = new_str;
                count++;
            }
        }
        else {
            str[count] = s;
            count++;
        }
    }
    @Override
    public String get() {
        if (count != 0)
            return str[count - 1];
        else
            return "There are not stings!";
    }

    @Override
    public String get(int id) {
        if(id<=count)
            return str[id-1];
        else
            return "There is not the string which you want to get !";
    }

    @Override
    public String remove(){
        String s;
        if(count!=0) {
            s = str[count - 1];
            str[count - 1] = null;
            count--;
        }
        else
            s="There are not stings!";
        return s;
    }

    public String  remove(int id) {
        String s;
        String []mas;
        if(id<=count)
        {  s = str[id-1];
            mas=new String [count-1];
            System.arraycopy (str, 0, mas, 0, id-1);
            System.arraycopy (str, id, mas, id-1, count-id);
            count--;
            str=mas;
        }
        else  s="There is not the string which you demand to remove !";
        return s;
    }

    @Override
    public boolean delete() {
        str=null;
        return (str==null ? true:false);
    }

    @Override
    public String toString() {
        for(int i=0; i<count; i++)
            System.out.println(str[i]);
        return null;
    }

    public static void main(String [] args) {
        Scanner in=new Scanner(System.in);
        int num;
        DynamicStringList ob1 = new DynamicStringList(3);
        ob1.add("Good morning world!");
        ob1.add("Good day world!");
        ob1.add("Good evening world!");
        ob1.add("Hello world!");

        System.out.println("Your strings:");
        ob1.toString();
        System.out.println("Your last string: " + ob1.get());
        System.out.print("Write number of string:");
        num=in.nextInt();
        System.out.println("Your "+num+" string: "+ob1.get(num));
        System.out.print("Write number of string, which you want to remove:");
        num=in.nextInt();
        ob1.remove(num);
        System.out.println("Your strings:");
        ob1.toString();
        System.out.println("Removing of your last string...");
        ob1.remove();
        System.out.println("Your strings:");
        ob1.toString();
        System.out.print("Result of removing all strings: "+ob1.delete());

    }
}