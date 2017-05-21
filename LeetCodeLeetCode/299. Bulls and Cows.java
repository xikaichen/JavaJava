public class Solution {
    public String getHint(String secret, String guess) {
        String bull = "";
        int countBull = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countBull++;
            }
        }
        bull = Integer.toString(countBull) + "A";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }
        int countCow = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                countCow++;
            }
        }
        return bull + Integer.toString(countCow - countBull) + "B";
    }
}

//one iteration method
public class Solution {
    public String getHint(String secret, String guess) {
        int[] record = new int[10];
        int cow = 0;
        int bull = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (record[secret.charAt(i) - '0']++ < 0) { // ++ anyway, 先判断再+， 但是不管判断对不对都会+
                    cow++;
                }
                if (record[guess.charAt(i) - '0']-- > 0) { // -- anyway
                    cow++;
                }
            }
        }
        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }
}