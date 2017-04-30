public class 3sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    res.add(new ArrayList(Arrays.asList(numbers[i], numbers[left], numbers[right])));
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}