package org.example;

public class SSTF {
    public void calculate(int[] requests, int head) {
        int totalHeadMovement = 0;
        int currentTrack = head;

        for (int request : requests) {
            int minDistance = Integer.MAX_VALUE;
            int nextTrack = 0;

            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == -1) {
                    continue;
                }

                int distance = Math.abs(currentTrack - requests[i]);
                if (distance < minDistance) {
                    minDistance = distance;
                    nextTrack = i;
                }
            }

            totalHeadMovement += minDistance;
            currentTrack = requests[nextTrack];
            requests[nextTrack] = -1;
        }

        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}
