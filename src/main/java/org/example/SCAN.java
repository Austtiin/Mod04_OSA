package org.example;

public class SCAN {
    public void calculate(int[] requests, int head) {
        int totalHeadMovement = 0;
        int currentTrack = head;
        int direction = 1;

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
                break;
            }

            totalHeadMovement++;
            currentTrack += direction;

            if (currentTrack == 100) {
                direction = -1;
                totalHeadMovement++;
                currentTrack = 99;
            } else if (currentTrack == -1) {
                direction = 1;
                totalHeadMovement++;
                currentTrack = 0;
            }
        }

        System.out.println("Total Head Movement: " + totalHeadMovement);
        System.out.println("Seek Time: " + totalHeadMovement);
    }
}
