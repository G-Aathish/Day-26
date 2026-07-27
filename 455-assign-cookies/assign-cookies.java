class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Thread t1 = new Thread(() -> { Arrays.sort(g); });
        Thread t2 = new Thread(() -> { Arrays.sort(s); });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        int result = 0, cookieIdx = 0;
        while (result < g.length && cookieIdx < s.length) {
            if (g[result] <= s[cookieIdx]) result++;
            cookieIdx++;
        }
        return result;
    }
}