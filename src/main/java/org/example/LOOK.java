package org.example;

public class LOOK {
    public void calculate(int[] requests, int head) {
        int seek_count = 0;
        int distance, cur_track;
        int size = requests.length;
        int[] diff = new int[size + 1];
        int[] new_requests = new int[size + 1];
        for (int i = 0; i < size; i++) {
            new_requests[i] = requests[i];
        }
        new_requests[size] = head;
        for (int i = 0; i < size; i++) {
            cur_track = new_requests[i];
            distance = Math.abs(cur_track - new_requests[i + 1]);
            seek_count += distance;
            diff[i] = distance;
        }
        System.out.println("Total Head Movement: " + seek_count);
        System.out.println("Seek Sequence is:");
        for (int i = 0; i < size; i++) {
            System.out.println(new_requests[i]);
        }
    }
}
