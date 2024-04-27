// Java program to implement SCAN Disk Scheduling algorithm
//https://www.geeksforgeeks.org/scan-elevator-disk-scheduling-algorithms/


package org.example;

import java.util.Arrays;

public class SCAN {
    public void calculate(int[] requests, int head) {
        // Total head movement
        int totalHeadMovement = 0;
        int currentTrack = head;
        int direction = 1;



        // Sort requests in ascending order
        Arrays.sort(requests);

        // Handle boundary cases
        while (true) {
            // Check if the current track is in the requests
            boolean found = false;

            // Check if the current track is in the requests
            for (int i = 0; i < requests.length; i++) {
                // If the request has been served, skip it
                if (requests[i] == -1) {
                    // Skip the request
                    continue;
                }

                // If the request has been served, skip it
                if (requests[i] == currentTrack) {

                    found = true; // Request found
                    requests[i] = -1; // Mark the request as served
                    break; // Exit the loop
                }
            }


            // If the request has been served, skip it
            if (found) {
                // Skip the request
                continue;
            }

            // Move to the next track
            totalHeadMovement++;
            currentTrack += direction;

            // Handle boundary cases
            if (currentTrack == 100 || currentTrack == -1) {
                direction = -direction; // Reverse direction
                totalHeadMovement++; // Move to the next track
            }

            // Handle boundary cases
            if (currentTrack == 100) {
                currentTrack = 99; // Move to the last track
            } else if (currentTrack == -1) {
                currentTrack = 0; // Move to the first track
            }

            // Check if all requests have been served
            boolean allRequestsServed = true;
            // Check if all requests have been served
            for (int request : requests) {
                // Check if all requests have been served
                if (request != -1) {
                    // Check if all requests have been served
                    allRequestsServed = false;
                    break;
                }
            }
            if (allRequestsServed) {
                break; // Exit the loop if all requests have been served
            }
        }

        // Print the total head movement and seek time
        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}