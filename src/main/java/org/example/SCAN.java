package org.example;

import java.util.Arrays;

public class SCAN {
    public void calculate(int[] requests, int head) {
        int totalHeadMovement = 0;
        int currentTrack = head;
        int direction = 1;

        // Sort requests in ascending order
        Arrays.sort(requests);

        while (true) {
            boolean found = false;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == -1) {
                    continue;
                }

                if (requests[i] == currentTrack) {
                    found = true;
                    requests[i] = -1;
                    break;
                }
            }

            if (found) {
                continue;
            }

            totalHeadMovement++;
            currentTrack += direction;

            // Handle boundary cases
            if (currentTrack == 100 || currentTrack == -1) {
                direction = -direction; // Reverse direction
                totalHeadMovement++; // Move to the next track
            }

            if (currentTrack == 100) {
                currentTrack = 99; // Move to the last track
            } else if (currentTrack == -1) {
                currentTrack = 0; // Move to the first track
            }

            // Check if all requests have been served
            boolean allRequestsServed = true;
            for (int request : requests) {
                if (request != -1) {
                    allRequestsServed = false;
                    break;
                }
            }
            if (allRequestsServed) {
                break; // Exit the loop if all requests have been served
            }
        }

        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}