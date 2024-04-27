// Java program to demonstrate CLOOK Disk Scheduling
// Algorithm
// https://www.geeksforgeeks.org/c-look-disk-scheduling-algorithm/

package org.example;

public class CLOOK {
    public void calculate(int[] req, int head) {
        int seek_count = 0;
        int distance, cur_track;
        int size = req.length;
        // int[] diff = new int[size + 1];
        int[] seek_sequence = new int[size + 1];

        // Copy the req array to seek_sequence array
        for (int i = 0; i < size; i++) {
            seek_sequence[i] = req[i];
        }

        // Run the while loop two times
        // to move in both directions
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                // First loop in the left direction
                seek_sequence[size] = 0;
                for (int j = 0; j < size; j++) {
                    cur_track = seek_sequence[j];

                    // Calculate absolute distance
                    distance = Math.abs(cur_track - head);

                    // Increase the total count
                    seek_count += distance;

                    
                    // Accessed track is now the new head
                    head = cur_track;
                }
            } else {
                seek_sequence[size] = 199;
                for (int j = 0; j < size; j++) {
                    cur_track = seek_sequence[j];

                    // Calculate absolute distance
                    distance = Math.abs(cur_track - head);

                    // Increase the total count
                    seek_count += distance;

                    // Accessed track is now new head
                    head = cur_track;
                }
            }
        }

        // Seek sequence
        System.out.println("Total Head Movement: " + seek_count);
        System.out.println("Total Seek Time: " + seek_count);
        System.out.println("Seek Sequence: ");
        // Print the sequence
        for (int i = 0; i < size + 1; i++) {
            System.out.print(seek_sequence[i] + " ");
        }
        System.out.println();
    }
}
