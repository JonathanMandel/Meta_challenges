import static java.util.Arrays.sort;

/**
 * A family of frogs is located on a row of lily pads, max 1 frog per pad. There are F frogs and N
 * lily pads, numbered 1 to N. Pad N is right next to the shore, and no frog is currently on pad N.
 *
 * Each second, one frog may hop. It moves to the nearest empty lily pad, hopping over other frogs on
 * the way. If it reaches pad N, it immediately exits onto the shore.
 *
 * Determine the minimum number of seconds for all frogs to reach the shore.
 *
 * https://www.facebookrecruiting.com/portal/coding_puzzles/?puzzle=977526253003069
 */
public class Hops {
    public long getSecondsRequired(long N, int F, long[] P) {
        long time = 0L;

        // How many hops to close up the gaps?
        sort(P);
        for (int i=1; i<F; i++) {
            time += P[i] - P[i-1] - 1;
        }

        // Add hops to get from last frog to shore
        time += N - P[F-1] - 1;

        // Add 1 hop per frog, to get to shore
        time += F;

        return time;
    }

}
