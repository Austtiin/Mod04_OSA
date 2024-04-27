// Java program to implement CSCAN disk scheduling algorithm
//         System.out.println("Scan algorithm");
package org.example;

import java.util.Arrays;

import java.util.Arrays;

public class CSCAN {
    public void calculate(int[] requests, int head) {
        // Implement the CSCAN disk scheduling algorithm
        int totalHeadMovement = 0;
        int currentTrack = head;
        int direction = 1;

        // Sort requests in ascending order
        Arrays.sort(requests);

        // Find the index of the current track
        while (true) {
            boolean found = false;
            for (int i = 0; i < requests.length; i++) {
                // Check if the request has already been served
                if (requests[i] == -1) {
                    continue;
                }

                if (requests[i] == currentTrack) {
                    // Request found
                    found = true;
                    requests[i] = -1;
                    break;
                }
            }

            if (found) {
                // Move to the next track
                continue;
            }

            totalHeadMovement++;
            // Move to the next track
            currentTrack += direction;

            // Handle boundary cases
            if (currentTrack == 100) {
                // Move to the beginning of the disk
                direction = -1; // Move to the beginning of the disk
                totalHeadMovement += 100; // Move to track 0
                currentTrack = 0; // Move to track 0
            }

            // Check if all requests have been served
            boolean allRequestsServed = true; // Assume all requests have been served
            for (int request : requests) { // Check if there are any pending requests
                if (request != -1) {// There are pending requests
                    allRequestsServed = false; // Set the flag to false
                    break; // Exit the loop
                }
            }
            if (allRequestsServed) {
                break; // Exit the loop if all requests have been served
            }
        }

        // Display the total head movement and seek time
        // Print the total head movement
        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}