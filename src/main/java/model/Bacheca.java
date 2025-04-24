package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Bacheca {
    public String Titolo;
    public String Des_bk;
    public ArrayList<ToDo> TDList;

    //costruttore di Default
    public Bacheca(String Titolo) {
        this.Titolo = Titolo;
        Des_bk = "-bacheca generica";

        TDList = new ArrayList<>();
        //ToDo t1=new ToDo();
        //TDList.add(t1);

    }

    //costruttore
    public Bacheca(String Titolo, String Des_bk) {
        this.Titolo = Titolo;
        this.Des_bk = Des_bk;
    }

    public String toString() {
        return Titolo + "\n" + Des_bk + "\n";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void SeeContent (){
        System.out.println("-" + Titolo + "\n");
        for(int i=0; i<TDList.size(); i++){
            System.out.println(i + ". " + TDList.get(i).SrtString() + "\n");
        }
    }
    public void SeeContentFull (){
        System.out.println("-" + Titolo + "\n");
        for(int i=0; i<TDList.size(); i++){
            System.out.println(i + ". " + TDList.get(i) + "\n");
        }
    }

    public void Initialize(){
        Scanner s = new Scanner(System.in);
        System.out.println("inserisci il Titolo \n");
        this.Titolo   = s.nextLine();
        System.out.println("inserisci una descrizione \n");
        this.Des_bk  = s.nextLine();
    }


    public void Swap(int i, int j){
        ToDo Ttemp0 = new ToDo();
        ToDo Ttemp1 = new ToDo();
        Ttemp0=TDList.get(i);
        Ttemp1=TDList.get(j);
        TDList.set(i, Ttemp1);
        TDList.set(j, Ttemp0);
    }
}
