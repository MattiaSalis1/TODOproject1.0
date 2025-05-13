package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Utente {
    public final String login;
    private String password;
    public ArrayList<Bacheca> BKList;
    //private final static Scanner s = new Scanner(System.in);


    //costruttore
    public Utente(String login, String password) {
        this.login = login;
        this.password = password;

        BKList = new ArrayList<>();
        Bacheca BK1 = new Bacheca("Università");
        Bacheca BK2 = new Bacheca("Lavoro");
        Bacheca BK3 = new Bacheca("Tempo Libero");
        BKList.add(BK1);
        BKList.add(BK2);
        BKList.add(BK3);
    }

    public void SeeBk() {
        System.out.println("\nLe tue Bacheche:\n");
        for (int i = 0; i < BKList.size(); i++) {
            System.out.println(i + ". " + BKList.get(i));
        }
    }


    public String toString() {
        return "Login: " + login + "\nPassword: " + password;
    }

    //public String getLogin() {return login;}
    public boolean Logincheck(String nome, String pass) {
        if( !( nome.equals(this.login) ) ){
            System.out.println("Errore, Nome Utente errato o assente");
            return true;
        } else if ( !(pass.equals(this.password))) {
            System.out.println("Errore, Password errata");
            return true;
        }else
            return false;
    }

    //operazioni BK
    public void NewBK(){
        System.out.println("Creazione nuova bachecha");
        Bacheca BK = new Bacheca("Errore");
        BK.Initialize();

        BKList.add(BK);
    }

    public void DelBK(){
        Scanner s = new Scanner(System.in);
        int i;

        System.out.println("\nInserisci l'indice della bacheca da rimuovere: ");
        i = s.nextInt();
        BKList.remove(i);
    }

    public void ModBK(){
        Scanner s = new Scanner(System.in);
        int i;

        System.out.println("\nInserisci l'indice della bacheca da modificare: ");
        i = s.nextInt();

        System.out.println("modifica bacheca");
        BKList.get(i).Initialize();

    }

    //operazioni TD
    public void AddTD( int i , ToDo TD ){
        BKList.get(i).TDList.add(TD);
    }

    public void NewTD(){
        Scanner s = new Scanner(System.in);
        System.out.println("Creazione nuovo elemento");
        int i;
        ToDo TD = new ToDo();

        TD.Initialize();

        System.out.println("Inserisci l'indice della bacheca: ");
        i = s.nextInt();
        AddTD(i, TD);
    }

    public void DelTD(int b){
        Scanner s = new Scanner(System.in);
        int i;

        System.out.println("\nInserisci l'indice dell'attività da rimuovere: ");
        i = s.nextInt();
        BKList.get(b).TDList.remove(i);
    }

    public void ModTD(int b){
        Scanner s = new Scanner(System.in);
        int i;

        System.out.println("Inserisci l'indice dell'attività da modificare: ");
        i = s.nextInt();

        System.out.println("modifica elemento");
        BKList.get(b).TDList.get(i).Initialize();
    }

    public void RelocateTD(int b1){
        Scanner s = new Scanner(System.in);
        int i,b2;

        System.out.println("Inserisci l'indice dell'attività da spostare: ");
        i = s.nextInt();
        System.out.println("Inserisci l'indice della bacheca destinataria: ");
        b2 = s.nextInt();
        BKList.get(b2).TDList.add( BKList.get(b1).TDList.get(i) );
        BKList.get(b1).TDList.remove(i);
    }

    public void Swap(int d){
        Scanner s = new Scanner(System.in);
        System.out.println("\nInserisci l'indice della prima attività da scambiare: ");
        int i = s.nextInt();
        System.out.println("Inserisci l'indice della seconda attività da scambiare: ");
        int j=s.nextInt();
        BKList.get(d).Swap(i, j);
    }

    //status update
    public void CompleteTD(int d){
        Scanner s = new Scanner(System.in);
        System.out.println("\nInserisci l'indice dell'attività da completare': ");
        int i = s.nextInt();
        FinSts(d,i);

    }

    public void FinSts(int b, int i){
        BKList.get(b).TDList.get(i).Status=check.DONE;

    }

    //scadenze



}
