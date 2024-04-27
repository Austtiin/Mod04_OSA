package org.example;

public class FCFS {
    public void calculate(int[] requests, int head) {
        int totalHeadMovement = 0;
        int currentTrack = head;

        for (int request : requests) {
            totalHeadMovement += Math.abs(currentTrack - request);
            currentTrack = request;
        }

        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}
