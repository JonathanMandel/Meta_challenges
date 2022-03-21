public class Photographer {
    /**
     * Solution to Meta coding challenge "Director of Photography 2".
     *
     * A photography set consists of N cells in a row, numbered from 1 to N in order. It is
     * represented by a string C. Each character of the string represents one cell:
     *   P = photographer
     *   A = actor
     *   B = background
     *   . = must be left empty
     * A photograph consists of a photographer, an actor and a backdrop, such that the actor is
     * between the photographer and the backdrop. A photograph is considered "artistic" if the
     * distance between the photographer and the actor is between X and Y (inclusive), and the
     * distance between the actor and the backdrop is also between X and Y (inclusive). The
     * distance between cells i and j is |i - j|.
     * @param N number of cells
     * @param C string representing the photography set
     * @param X minimum distance for an artistic picture
     * @param Y maximum distance for an artistic picture
     * @return The number of different artistic photographs that can be taken on this set. Different
     * means they involve a different photographer, actor and/or backdrop.
     */
    public long getArtisticPhotographCount(int N, String C, int X, int Y) {
        // N = number of cells. 1 <= N <= 300,000
        // X and Y are inclusive bounds of distance between P and A and B for an "artistic" picture
        if (N < 3) return 0;
        long count = 0;

        // Create a partial sum array for P and B. This will allow us to count the number of each in
        // the vicinity of every A.
        int sumOfP[] = new int[N+1];
        int sumOfB[] = new int[N+1];
        sumOfB[0] = 0;
        sumOfP[0] = 0;
        for (int i=1; i<=N; i++) {
            int prev = i-1;
            char ch = C.charAt(prev);
            sumOfB[i] = sumOfB[prev] + ((ch == 'B') ? 1 : 0);
            sumOfP[i] = sumOfP[prev] + ((ch == 'P') ? 1 : 0);
        }

        // Now find each A and count the number of arrangements of P and B in its vicinity that
        // are within X and Y of A.
        for (int i=1; i<N; i++) {
            if (C.charAt(i) == 'A') {
                int rStart = Math.min(N, i + X);
                int rEnd   = Math.min(N, i + Y + 1);
                int lStart = Math.max(0, i - Y);
                int lEnd   = Math.max(0, i - X + 1);

                count += (long) (sumOfP[lEnd] - sumOfP[lStart]) * (sumOfB[rEnd] - sumOfB[rStart]);
                count += (long) (sumOfP[rEnd] - sumOfP[rStart]) * (sumOfB[lEnd] - sumOfB[lStart]);
            }
        }
        return count;
    }
}
