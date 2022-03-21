import java.util.Arrays;


/**
 * A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. Social distancing
 * guidelines require that every diner be seated such that K seats to their left and K seats to their right (or all
 * the remaining seats to that side if there are fewer than K) remain empty.
 *
 * There are currently M diners seated at the table, the (i)th of whom is in seat S[i].
 * No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 *
 * Determine the maximum number of additional diners who can potentially sit at the table without social distancing
 * guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the
 * additional diners will cooperate to maximize how many of them can sit down.
 *
 * 1 <= N <= 10^15
 * 1 <= M <= 500,000
 * 1 <= K <= N
 * M <= N
 */
public class Cafeteria {
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long result = 0;
        long start = 1;
        long end;

        for (int i = 0; i < M; ++i) {
            end = S[i] - K - 1;
            result += getCount(start, end, K);
            start = S[i] + K + 1;
        }
        result += getCount(start, N, K);
        return result;
    }

    private long getCount(long start, long end, long K) {
        return (start > end) ? 0 : (end - start) / (K + 1) + 1;
    }

}
