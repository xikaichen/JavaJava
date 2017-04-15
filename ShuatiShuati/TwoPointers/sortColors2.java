class sortColors2 {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    public void rainbowSort(int[] colors,
                            int left,
                            int right,
                            int colorFrom,
                            int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }

        int colorMid = (colorFrom + colorTo) / 2;
        int l = left, r = right;
        while (l < r) {
            while (l < r && colors[l] <= colorMid) {
                l++;
            }
            while (l < r && colors[r] > colorMid) {
                r--;
            }
            if (l < r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }
        }
        
        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
}