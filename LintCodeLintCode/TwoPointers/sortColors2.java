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
                swap(colors, l, r);
                l++;
                r--;
            }
        } 
        
        // 两种情况一种 1. left - r 是 colorFrom 到 color Mid。 l - right是colorMid + 1到 colorTo
        //2. l 和 r刚好在一个地方，这个时候还是可以按照情况1的方法排
        rainbowSort(colors, left, r, colorFrom, colorMid); //出while后l 永远在r后面一个
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
    
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}