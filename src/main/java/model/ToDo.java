package model;
import java.time.LocalDate;
import java.util.Scanner;


public class ToDo {

    public String Titolo;
    public String Des_td;
    public LocalDate Scadenza;

    public String URL;
    //Img
    //Color
    public check Status;

    /*da applicare successivamente
    * User UserOwner
    * User UserList
    */

    //costruttore di Default
    public ToDo(){
        Titolo = "Titolo";
        Des_td = "  ";
        Scadenza = LocalDate.now();
        URL = " ";
        Status=check.NOT_DONE;
    }

    //costruttore
    public ToDo(String Titolo,String Des_td,LocalDate Scadenza,String URL) {
        this.Titolo=Titolo;
        this.Des_td=Des_td;
        this.Scadenza=Scadenza;
        this.URL=URL;
        this.Status=check.NOT_DONE;
    }

    public String toString(){
        return "Titolo: " + Titolo + "\n" + "Descrizione: " + Des_td + "\n" + "Scadenza: " + Scadenza + "\n" + "URL: " + URL + "\n" + "Status: " + Status ;
    }

    public String Line(){return Titolo + " "+ Scadenza;}

    public String SrtString(){
        return Titolo + "\n" + Scadenza + "\n" + "Status: " + Status ;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public void Initialize(){
        Scanner s = new Scanner(System.in);
        int g,m,a;
        System.out.println("inserisci il Titolo \n");
        this.Titolo   = s.nextLine();
        System.out.println("inserisci una descrizione \n");
        this.Des_td  = s.nextLine();
        System.out.println("inserisci un Link \n");
        this.URL  = s.nextLine();

        System.out.println("\nInserisci il giorno di scadenza: ");
        g = s.nextInt();
        System.out.println("\nInserisci il mese di scadenza: ");
        m = s.nextInt();
        System.out.println("\nInserisci l'anno di scadenza: ");
        a = s.nextInt();
        this.Scadenza= LocalDate.of(a,m,g);

    }


}
