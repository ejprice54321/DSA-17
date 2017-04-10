public class FirstFailingVersion {

    private static long fbvRecurse(long low, long high, IsFailingVersion isBadVersion){
        long n = (high+low)/2;
        boolean result = isBadVersion.isFailingVersion(n);
        boolean forwardNeighbor = isBadVersion.isFailingVersion(n+1);
        boolean backwardNeighbor = isBadVersion.isFailingVersion(n-1);

        if (high>low){
            if (result){
                if (!backwardNeighbor) return n;
                return fbvRecurse(low, n, isBadVersion);
            } else{
                if (forwardNeighbor) return n+1;
                return fbvRecurse(n, high, isBadVersion);
            }
        }
        return -1;
    }

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        return fbvRecurse(0, n, isBadVersion);
    }
}
