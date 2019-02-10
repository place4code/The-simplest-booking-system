package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Theatre test = new Theatre("test", 6, 6);
        test.getSets();
        test.reserveSeat("F16");
        test.reserveSeat("B02");


        List<Theatre.Seat> sortowanie = new ArrayList<>(test.getSeats());
        printList(sortowanie);
        Collections.shuffle(sortowanie);
        printList(sortowanie);

        Collections.sort(sortowanie, Theatre.WHERE);
        printList(sortowanie);

//        List<Theatre.Seat> copySeats = new ArrayList<>(test.seats);
//        printList(copySeats);
//
//        Collections.swap(copySeats, 0, 4);
//        printList(copySeats);
//
//        List<Theatre.Seat> forCopy = new ArrayList<>(test.seats.size());
//        Collections.copy(forCopy, test.seats);
//
//        Theatre.Seat s = Collections.min(copySeats);
//
//        System.out.println(s.getSeatNumber());


    }

    private static void printList(List<Theatre.Seat> copySeats) {
        for (Theatre.Seat seat :
                copySeats) {
            System.out.println(seat.getSeatNumber());
        }
    }
}
