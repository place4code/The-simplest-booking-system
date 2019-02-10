package com.company;


import java.util.*;

public class Theatre {
    public String getTheatreName() {
        return theatreName;
    }

    private final String theatreName;
    private List<Seat> seats = new ArrayList();

    static final Comparator<Seat> WHERE;

    public List<Seat> getSeats() {
        return seats;
    }

    static {
        WHERE = new Comparator<Seat>() {
            @Override
            public int compare(Seat o1, Seat o2) {

                return o1.getSeatNumber().compareToIgnoreCase(o2.getSeatNumber());

            }
        };
    }

    public Theatre(String theatreName, int numRows, int seatPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1); // 65 = 'A'
        for (char row = 'A'; row <= lastRow; row++) {
            //System.out.println(row);
            for (int i = 1; i <= seatPerRow; i++) {
                Seat seat = new Seat(row + String.format("%02d", i));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {


        Seat requestedSeat = new Seat(seatNumber);

        int found = Collections.binarySearch(seats, requestedSeat, null);

        if (found >= 0) {
            return seats.get(found).reserve();
        } else {
            System.out.println("Es gibt kein Platz " + seatNumber);
            return false;
        }



//        int low = 0;
//        int high = seats.size()-1;
//
//        while (low <= high) {
//            System.out.print(".");
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//
//
//
//        }
//
//        System.out.println("Es gibt kein Platz " + seatNumber);
//        return false;







//        Seat requestedSeat = null;
//
//        int counter = 0;
//        for (Seat seat : seats){
//            System.out.print(++counter + ".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("Es gibt kein Platz " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();

    }

    public void getSets() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNumber.compareToIgnoreCase(o.getSeatNumber());
        }

        public boolean reserve() {
            if (!reserved) {
                System.out.println("Der Platz: " + seatNumber + " wurde reserviert");
                reserved = true;
                return true;
            } else {
                System.out.println("Der Platz: " + seatNumber + " ist leider bereits reserviert");
                return false;
            }
        }


        public boolean cancel() {
            if (reserved) {
                reserved = false;
                System.out.println("Die Reservation vom Platz: " + seatNumber + " wurde abgesagt");
                return true;
            } else {
                return false;
            }
        }


    }
}
