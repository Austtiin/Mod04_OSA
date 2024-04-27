// Java class for SSTF (Shortest Seek Time First) algorithm
//https://www.geeksforgeeks.org/sstf-full-form/


package org.example;

public class SSTF {
    public void calculate(int[] requests, int head) {
        // Copy the requests array to avoid modifying the original array
        int totalHeadMovement = 0;
        int currentTrack = head;


        // Copy the requests array to avoid modifying the original array
        for (int request : requests) {
            // Calculate the total head movement
            int minDistance = Integer.MAX_VALUE;
            int nextTrack = 0;


            // Find the request with the shortest seek time
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == -1) {
                    continue;
                }

                // Calculate the distance between the current track and the request
                int distance = Math.abs(currentTrack - requests[i]);
                if (distance < minDistance) {
                    // Update the minimum distance and the next track to move to
                    minDistance = distance;
                    nextTrack = i;
                }
            }

            // Update the total head movement and move to the next track
            totalHeadMovement += minDistance; // Add the seek time
            currentTrack = requests[nextTrack]; // Move to the next track
            requests[nextTrack] = -1; // Mark the request as served
        }

        // Print the total head movement and seek time
        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}
