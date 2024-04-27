package org.example;

public class CLOOK {
    public void calculate(int[] requests, int head) {
        int seek_count = 0;
        int distance, cur_track;
        int size = requests.length;
        int[] seek_sequence = new int[size + 1];

        // Copy the requests array to seek_sequence array
        for (int i = 0; i < size; i++) {
            seek_sequence[i] = requests[i];
        }

        // Run the while loop two times
        // to move in both directions
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
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

        System.out.println("Total Seek Time: " + seek_count);
        System.out.println("Seek Sequence: ");
        for (int i = 0; i < size + 1; i++) {
            System.out.print(seek_sequence[i] + " ");
        }
        System.out.println();
    }
}
