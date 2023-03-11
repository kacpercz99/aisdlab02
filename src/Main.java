import lib.TStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //zad1();
        //zad2();
        zad3();
    }
    private static void zad3() {
        getFromFileAndPrintBackwards("C:\\Users\\Kacper\\Documents\\java\\aisdlab02\\src\\data\\kochanowski.txt");
        getFromFileAndPrintBackwards("C:\\Users\\Kacper\\Documents\\java\\aisdlab02\\src\\data\\morsztyn.txt");

    }

    private static void getFromFileAndPrintBackwards(String pathname) {
        File f = new File(pathname);
        Scanner sc = null;
        TStack<String> st = new TStack<>();
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku.");
            return;
        }
        while(sc.hasNext()){
            String line = sc.nextLine();
            Arrays.stream(
                    line.trim()
                    .replaceAll("[\\.,:]$", "")
                    .split(" ")
                    ).forEach(st::push);

            while (!st.isEmpty()){
                System.out.print(st.pop() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    private static void zad2() {
        TStack<String> st= new TStack<>();
        st.push("aaa");
        st.push("bbb");
        st.push("ccc");
        st.push("ddd");
        st.push("eee");
        System.out.println(st.deepLevel("fff"));
        System.out.println(st.deepLevel("aaa"));
        System.out.println(st.deepLevel("ccc"));
        System.out.println(st.deepLevel("eee"));

        System.out.println(st);
        st.delLast();
        System.out.println(st);
    }
    private static void zad1() {
        TStack<String> st= new TStack<>();
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5;i++){
            System.out.println("Podaj nazwę ksiązki:");
            st.push(sc.nextLine());
        }
        int counter = 1;
        while(!st.isEmpty()){
            System.out.printf("%d. %s\n",counter++,st.pop());
        }
    }
}