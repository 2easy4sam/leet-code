package pramp;


import java.util.*;

class Solution {

    static class Data implements Comparable<Data> {
        public String word;
        public int freq;

        Data(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Data a) {
            return a.freq - this.freq;

        }

    }

    static String[][] wordCountEngine(String document) {


        // your code goes here
        String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            int c = freqMap.getOrDefault(word, 0);
            freqMap.put(word, c + 1);
        }

        ArrayList<Data> dataList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            dataList.add(new Data(entry.getKey(), entry.getValue()));
        }
        Collections.sort(dataList);
        String[][] result = new String[dataList.size()][2];
        int i = 0;
        for (Data data : dataList) {
            result[i][0] = data.word;
            result[i++][1] = "" + data.freq;
        }
        return result;
    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";

        String[][] res = wordCountEngine(document);

        for (String[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

    }

}
