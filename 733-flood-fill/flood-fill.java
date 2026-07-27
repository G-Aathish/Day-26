class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int s=image[sr][sc];
        if(s==color) return image;
        dfs(image,sr,sc,s,color);
        return image;
    }
    public void dfs(int[][] image,int r,int c,int s,int color){
        if(r<0||c<0||r>=image.length||c>=image[0].length||image[r][c]!=s) return;
        image[r][c]=color;
        dfs(image,r-1,c,s,color);
        dfs(image,r+1,c,s,color);
        dfs(image,r,c-1,s,color);
        dfs(image,r,c+1,s,color);
    }
}