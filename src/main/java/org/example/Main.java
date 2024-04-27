/*
04/26/2024
Austin Stephens
COP3230C
Professor Amitava Karmaker


*Overview:
Operating systems manage the read and write processes to the storage devices. There are a number of algorithms that operating systems may implement for this process.



Instructions:
Consider a 100-track disk (0-99) and the read/write head is currently in location 90 after servicing location 75.

For the read/write requests in the disk queue listed below, calculate Total Head Movement (THM) and Seek Time:

39, 84, 70, 42, 11, 55, 68, 23

First Come First Serve (FCFS)
Shortest Seek Time First (SSTF)
SCAN algorithm
C-SCAN algorithm
LOOK algorithm
C-LOOK algorithm


* */

package org.example;

public class Main {
    public static void main(String[] args) {
        // Request array
        int[] requests = {39, 84, 70, 42, 11, 55, 68, 23};
        // Head position
        int head = 90;

        // Create objects of the algorithms
        FCFS fcfs = new FCFS();
        SSTF sstf = new SSTF();
        SCAN scan = new SCAN();
        CSCAN cscan = new CSCAN();
        LOOK look = new LOOK();
        CLOOK clook = new CLOOK();


        // Calculate the total head movement and seek time for each algorithm
        System.out.println("First Come First Serve (FCFS)");
        fcfs.calculate(requests, head);

        // Calculate the total head movement and seek time for each algorithm
        System.out.println("Shortest Seek Time First (SSTF)");
        sstf.calculate(requests, head);

        // Calculate the total head movement and seek time for each algorithm
        System.out.println("C-LOOK algorithm");
        clook.calculate(requests, head);

        // Calculate the total head movement and seek time for each algorithm
        System.out.println("LOOK algorithm");
        look.calculate(requests, head);

        // Calculate the total head movement and seek time for each algorithm
        System.out.println("C-SCAN algorithm");
        cscan.calculate(requests, head);

        // Calculate the total head movement and seek time for each algorithm
       System.out.println("SCAN algorithm");
       scan.calculate(requests, head);
    }
}