package org.example;

import java.util.Arrays;

import java.util.Arrays;

public class CSCAN {
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
            if (currentTrack == 100) {
                direction = -1; // Move to the beginning of the disk
                totalHeadMovement += 100; // Move to track 0
                currentTrack = 0;
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