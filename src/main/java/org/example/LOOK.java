// Java class for LOOK Disk Scheduling algorithm
//https://www.geeksforgeeks.org/look-disk-scheduling-algorithm/

package org.example;

public class LOOK {
    public void calculate(int[] requests, int head) {
        // Variable to keep track of total head movement
        int seek_count = 0;
        int distance, cur_track;
        int size = requests.length;
        int[] diff = new int[size + 1];
        int[] new_requests = new int[size + 1];

        // Copy the requests into new_requests array
        for (int i = 0; i < size; i++) {
            new_requests[i] = requests[i];

            // Calculate the difference between the current track and the next track
        }

        // Add the head into the new_requests array
        new_requests[size] = head;

        // Sort the new_requests array
        for (int i = 0; i < size; i++) {
            // Find the current track
            cur_track = new_requests[i];// Find the difference between the current track and the next track
            distance = Math.abs(cur_track - new_requests[i + 1]);   // Add the distance to the seek_count
            seek_count += distance; // Store the distance in the diff array
            diff[i] = distance; // Print the current track
        }

        // Print the total head movement
        System.out.println("Total Head Movement: " + seek_count);
        System.out.println("Seek Sequence is:");

        // Print the seek sequence
        for (int i = 0; i < size; i++) {
            System.out.println(new_requests[i]);
        }
    }
}
