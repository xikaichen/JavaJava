public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //算overlap
        // key point: right 和 top之所以要这样算是为了防止没有overlap的情况
    	// 如果没有overlap 例如A C E G 但是没有overlap事实上 C < E的
        // 此时left = E, Math.min(C, G)就会等于C 这个时候在和left比较 得到right = E 这样overlap就是0了
        // 同时也处理了有一个area 面积为0的情况
        int left = Math.max(A,E);
        int right = Math.max(Math.min(C,G), left);
        int bottom = Math.max(B,F);
        int top = Math.max(Math.min(D,H), bottom);
        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}