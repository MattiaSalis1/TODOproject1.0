import model.*;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        /*questo è un test*/
        Scanner s = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate request = LocalDate.now();

        Utente user1 = new Utente("CarloC42", "pass1234");
        boolean lock=true;
        //riempio test


        ToDo T1 = new ToDo("Finisci Progetto","Ti manca poco ",tomorrow,"google.com");

        ToDo T2 = new ToDo("Classe OBJ"," ",today," ");

        ToDo T3 = new ToDo("Ripara Sedia","si è rotta",LocalDate.of(2025,6,1)," ");
        ToDo T4 = new ToDo("Meetup","Cena galante a ristorante indiano ",today.minusDays(1),"BigIndia.it");

        user1.AddTD(0,T2);

        user1.AddTD(1,T1);

        user1.AddTD(2,T3);
        user1.AddTD(2,T4);

        //loginlock

        do{
            lock=login(user1);
        }while(lock);

        int opt=1;
        int c=0;


        System.out.println("Benvenuto " + user1.login);
        Expiration(today,user1);
        Expiration(tomorrow,user1);
        System.out.println("\n");

        //System.out.println(u);



        //c=GetIndex();

        //user1.SeeBk();

        //user1.NewBK();
        //user1.ModBK();
        //user1.DelBK();

        //user1.BKList.get(c).SeeContent();
        //user1.BKList.get(0).SeeContentFull();

        //Expiration(today,user1);
        //Expiration(tomorrow,user1);
        //ExprSearch(user1);
        //Search(user1);

        //user1.NewTD();
        //user1.ModTD(c);
        //user1.DelTD(c);
        //user1.Swap(2,0,1);
        //user1.CompleteTD(c);
        //user1.RelocateTD(c);





        do{
            ListcomBK();
            user1.SeeBk();
            opt=GetCom();
            switch(opt){
                case 1:
                    user1.NewBK();
                    break;
                case 2:
                    user1.ModBK();
                    break;
                case 3:
                    user1.DelBK();
                    break;
                case 4:
                    c=GetIndex();
                    user1.BKList.get(c).SeeContent();
                    break;
                case 5:
                    c=GetIndex();
                    user1.BKList.get(c).SeeContentFull();
                    break;
                case 6:
                    ExprSearch(user1);
                    break;
                case 7:
                    Search(user1);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("valore non valido");
                    break;
            }

            if(opt==4||opt==5){
                ListcomTD();
                opt=GetCom();
                switch(opt){
                    case 0:
                        break;
                    case 8:
                        user1.NewTD();
                        break;
                    case 9:
                        user1.ModTD(c);
                        break;
                    case 10:
                        user1.DelTD(c);
                        break;
                    case 11:
                        user1.CompleteTD(c);
                        break;
                    case 12:
                        user1.Swap(c);
                        break;
                    case 13:
                        user1.RelocateTD(c);
                        break;
                    default:
                        System.out.println("valore non valido");
                        break;
                }

            }


        }while(opt!=0);



    }

    private static boolean login(Utente utente) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci Nome Utente");
        String nome = s.nextLine();
        System.out.println("Inserisci Password");
        String pass = s.nextLine();

        return utente.Logincheck(nome,pass);
    }

    public static int GetIndex() {
        Scanner s = new Scanner(System.in);
        System.out.println("Seleziona indice bacheca da vedere: ");
        return s.nextInt();
    }

    public static int GetCom() {
        Scanner s = new Scanner(System.in);
        System.out.println("Seleziona indice operazione: ");
        return s.nextInt();
    }

    public static void ListcomBK(){
        System.out.println("inserisci un valore per eseguire l'operazione desiderata\n" +
                "0. Exit\n" +
                "1. Nuova Bacheca\n" +
                "2. Modifica Bacheca\n" +
                "3: Elimina Bacheca\n" +
                "4. Vedi contenuto bacheca\n" +
                "5. Vedi contenuti estesi Bacheca\n" +
                "6. Cerca per scadenza\n" +
                "7. Cerca per Titolo\n");
    }
    public static void ListcomTD(){
        System.out.println("inserisci un valore per eseguire l'operazione desiderata\n" +
                "0. Exit\n" +
                "8. Nuova Attività\n" +
                "9. Modifica Attività\n" +
                "10: Elimina Attività\n" +
                "11. Completa Attività\n" +
                "12. Scambia due attività\n" +
                "13. sposta Attività in un'altra bacheca\n" );
    }


    //scadenze con search
    public static void Expiration(LocalDate date, Utente user) {
        System.out.print("Le seguenti attività ");
        if( date.isEqual( LocalDate.now() ) ) {
            System.out.print("sono scadute:");
        } else if (date.isEqual( LocalDate.now().plusDays(1) )) {
            System.out.print("scadranno entro Domani:");
        } else {
            System.out.print(date + ":");
        }
        System.out.println("\n");

        ToDo Ttemp = new ToDo();

        for(int i=0; i<user.BKList.size(); i++) {
            for(int j=0; j<user.BKList.get(i).TDList.size(); j++) {
                Ttemp=user.BKList.get(i).TDList.get(j);
                if( date.isAfter( Ttemp.Scadenza ) && Ttemp.Status==check.NOT_DONE  ) {
                    System.out.println(user.BKList.get(i).Titolo + " - " + Ttemp.Line());
                }
            }
        }

    }

    public static void ExprSearch(Utente user) {
        Scanner s = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        int g,m,a;
        System.out.println("\nInserisci il giorno: ");
        g = s.nextInt();
        System.out.println("\nInserisci il mese: ");
        m = s.nextInt();
        System.out.println("\nInserisci l'anno: ");
        a = s.nextInt();
        date= LocalDate.of(a,m,g);
        Expiration(date, user);

    }
    //ricerca con titolo
    public static void Search(Utente user) {
        Scanner s = new Scanner(System.in);
        ToDo TD = new ToDo();
        System.out.println("inserisci il Titolo da cercare (sii preciso)");
        String search = s.nextLine().toLowerCase();

        for(int i=0; i<user.BKList.size(); i++) {
            for(int j=0; j<user.BKList.get(i).TDList.size(); j++) {
                TD.Titolo=user.BKList.get(i).TDList.get(j).Titolo.toLowerCase();
                if( TD.Titolo.equals(search) ) {
                    System.out.println(user.BKList.get(i).Titolo + " - " + user.BKList.get(i).TDList.get(j).Line());
                }
            }
        }


    }


}



