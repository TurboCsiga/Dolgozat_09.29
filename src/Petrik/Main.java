package Petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static List<Bejegyzes> bejegyzesLista = new ArrayList<>();

    public static void main(String[] args)
    {
        Bejegyzes b1 = new Bejegyzes("asd", "asd");
        bejegyzesLista.add(b1);
        Bejegyzes b2 = new Bejegyzes("wasd", "wasd");
        bejegyzesLista.add(b2);


        BejegyzesBekeres();
        Beolvasas();
        RandomLikeok();
        BejegyzesModositas();
        BejegyzesekKiirasa();
        LegnepszerubbBejegyzes();
        VaneTobbLike();
        System.out.printf("Kevesebb mint 15 like: %d", KevesebbLike());
        Rendezes();
        BejegyzesekKiirasa();
    }

    static void BejegyzesBekeres()
    {
        System.out.print("Mennyi bejegyzést szeretne: ");
        int valasz = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < valasz; i++)
        {
            System.out.print("Ki az író: ");
            String szerzo = sc.nextLine();
            System.out.print("Mi az iromány: ");
            String tartalom = sc.nextLine();
            bejegyzesLista.add(new Bejegyzes(szerzo, tartalom));
        }
    }

    static void Beolvasas()
    {
        try
        {
            FileReader fr = new FileReader("bejegyzesek.txt");
            BufferedReader br = new BufferedReader(fr);
            String[] data;
            String line = br.readLine();
            while (!line.equals(""))
            {
                data = line.split(";");
                bejegyzesLista.add(new Bejegyzes(data[0], data[1]));
                line = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    static void RandomLikeok()
    {
        Random rnd = new Random();
        for (int i = 0; i < bejegyzesLista.size() * 20; i++)
        {
            bejegyzesLista.get(rnd.nextInt(bejegyzesLista.size())).like();
        }
    }

    static void BejegyzesModositas()
    {
        System.out.print("Melyik bejegyzést szeretné módosítani? ");
        int valasz = Integer.parseInt(sc.nextLine());
        System.out.printf("\n%s\n", bejegyzesLista.get(valasz));
        System.out.println("Mire szeretné szerkeszteni? ");
        String szerkesztettTartalom = sc.nextLine();
        bejegyzesLista.get(valasz).setTartalom(szerkesztettTartalom);
        System.out.printf("\n%s\n", bejegyzesLista.get(valasz));
    }

    static void BejegyzesekKiirasa()
    {
        for (Bejegyzes a: bejegyzesLista)
        {
            System.out.printf("\n%s\n", a);
        }
    }

    static void LegnepszerubbBejegyzes() {
        int index = 0;
        for (int i = 1; i < bejegyzesLista.size(); i++) {
            if (bejegyzesLista.get(i).getLikeok() > bejegyzesLista.get(index).getLikeok()) index = i;
        }
        System.out.printf("\nA legnépszerübb bejegyzésen a likeok alapján: %s\n", bejegyzesLista.get(index).getLikeok());
    }

    static void VaneTobbLike()
    {
        boolean vanAnnyiLike = false;
        int i = 0;
        while (!vanAnnyiLike && i < bejegyzesLista.size())
        {
            if (bejegyzesLista.get(i).getLikeok() > 35) vanAnnyiLike = true;
            i++;
        }
        if (vanAnnyiLike)
        {
            System.out.printf("Van olyan bejegyzés amin több mint %d like van", 35);
        }
        else System.out.printf("Nincs olyan bejegyzés amin több mint %d like van\n", 35);
    }

    static int KevesebbLike()
    {
        int db = 0;
        for (Bejegyzes a : bejegyzesLista)
        {
            if (a.getLikeok() < 15)
            {
                db++;
            }
        }
        return db;
    }

    static void Rendezes()
    {
        Bejegyzes legnagyobb;
        Bejegyzes help;
        int jHelp;
        for (int i = 0; i < bejegyzesLista.size(); i++)
        {
            legnagyobb = bejegyzesLista.get(i);
            jHelp = i;
            for (int j = i; j < bejegyzesLista.size(); j++)
            {
                if (bejegyzesLista.get(j).getLikeok() >= legnagyobb.getLikeok())
                {
                    legnagyobb = bejegyzesLista.get(j);
                    jHelp = j;
                }
            }
            help = bejegyzesLista.get(i);
            bejegyzesLista.set(i, legnagyobb);
            bejegyzesLista.set(jHelp, help);
        }
    }

}