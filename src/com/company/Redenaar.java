package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Redenaar {

    private BufferedReader invoer;

    Redenaar() {
        try {
            invoer = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("dafuq?");
            System.exit(0);
        }
    }

    public void start() {
        System.out.println("Het doel van het spel is om het tussentotaal tot 100 te brengen");
        System.out.println("Veel succes, je kan toch niet winnen!");
        int totaal = move(10);
        System.out.println("Het tussentotaal is: " + totaal);
        while (totaal < 100) {
            System.out.println("Gelieve een geheel getal i (0 < i < 11) te typen:");
            int leesInvoer = leesInvoer();
            System.out.println("Je bracht het tussentotaal tot: " + (leesInvoer + totaal));
            System.out.println("Tegenstander berekent zijn antwoord ... ");
            totaal += move(leesInvoer) + leesInvoer;
            System.out.println("Het tussentotaal is: " + totaal);
        }
        System.out.println("Game ended");
        System.out.println("You lost!");
        System.exit(1);
    }

    private int move(int i) {
        return 11 - i;
    }

    private int leesInvoer() {
        int tussenTotaal;
        try {
            tussenTotaal = Integer.parseInt(invoer.readLine());
            if (tussenTotaal < 1 || tussenTotaal > 10) {
                System.err.println("Het getal moet binnen het interval [1, 10] liggen");
                tussenTotaal = leesInvoer();
            }
        } catch (IOException e) {
            // anders klaagt ze (ja het is een ze)
            tussenTotaal = 0;
            System.err.println("dafuq?");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.err.println("Gelieve een geheel getal in te geven");
            tussenTotaal = leesInvoer();
        }
        return tussenTotaal;
    }

}
