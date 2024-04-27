// Java class for First-Come-First-Serve (FCFS) disk scheduling algorithm
//https://www.geeksforgeeks.org/program-for-fcfs-cpu-scheduling-set-1/

package org.example;

public class FCFS {
    public void calculate(int[] requests, int head) {
        // Total head movement
        int totalHeadMovement = 0;
        int currentTrack = head;

        // Calculate total head movement
        for (int request : requests) {  // Loop through the requests
            // Add the absolute difference between the current track and the request
            totalHeadMovement += Math.abs(currentTrack - request); // Calculate the total head movement
            currentTrack = request; // Set the current track to the request
        }

        // Print the total head movement
        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);

    }
}
