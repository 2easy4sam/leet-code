package com.leetcode.playground;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final char BATTLESHIP_PART = 'X';
    private static final char EMPTY_CELL = '.';
    private static final char[] EMPTY_STRING_REPLACEMENT = new char[]{'%', '2', '0'};

    static class TreeNode {
        int val;
        TreeNode left, right;


        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(9);
        set.add(8);

        System.out.println(set.ceiling(9));
        System.out.println(set.toString());
    }

    private static int test(int num) {
        if (num == 1) return 1;
        return num + test(num - 1);
    }

    private static int factorial(int num) {
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }

    private static void increment(int[] arr) {
        arr[0]++;
    }

    private static int randomInt(int lowerBound, int upperBound) {
        Random random = new Random(System.nanoTime());

        if (lowerBound > upperBound) {
            int temp = lowerBound;
            lowerBound = upperBound;
            upperBound = temp;
        }

        int diff = upperBound - lowerBound;

        return random.nextInt(diff + 1) + lowerBound;
    }

    private static int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int number = i;
            int count = 0;

            while (number >= 1) {
                number &= number - 1;
                count++;
            }

            res[i] = count;
        }

        return res;
    }

    private static int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count = 0, currentWeight = 0;

        for (int weight : arr) {
            currentWeight += weight;
            if (currentWeight < 5000) count++;
            else break;
        }

        return count;
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        final int rowCount = board.length;
        final int colCount = board[0].length;
        int[] visitedCells = new int[rowCount * colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int idx = i * colCount + j;

                // not visited
                if (visitedCells[idx] == 0) {
                    char cell = board[i][j];

                    if (cell == BATTLESHIP_PART) {
                        count++;

                        // traverse horizontally
                        for (int k = j; k < colCount; k++) {

                            if (board[i][k] == EMPTY_CELL) break;
                            visitedCells[i * colCount + k] = 1;
                        }

                        // traverse vertically
                        for (int k = i; k < rowCount; k++) {

                            if (board[k][j] == EMPTY_CELL) break;
                            visitedCells[k * colCount + j] = 1;
                        }
                    }
                }
            }
        }

        return count;
    }

    private static boolean divisorGame(int N) {
        int turns = 0;

        while (N > 0) {
            for (int i = N / 2; i >= 1; i--) {
                if (N % i == 0) {
                    N -= i;
                    turns++;
                }
            }
        }

        return turns % 2 != 0;
    }

    private static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Map<Integer, List<List<Integer>>> differenceMap = new TreeMap<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (differenceMap.containsKey(diff)) {
                differenceMap.get(diff).add(Arrays.asList(arr[i], arr[i + 1]));
            } else {
                List<List<Integer>> list = new ArrayList();
                list.add(Arrays.asList(arr[i], arr[i + 1]));
                differenceMap.put(diff, list);
            }
        }

        return differenceMap.entrySet().iterator().next().getValue();
    }

    private static List<Integer> partitionLabels(String S) {
        List<Integer> cutOffPoints = new ArrayList();
        List<Integer> res = new ArrayList<>();
        char[] charArr = S.toCharArray();
        Map<Character, Integer> charIndexMap = new LinkedHashMap<>();
        int lastCutOffIndex = 0;

        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];

            if (!charIndexMap.containsKey(c)) {
                boolean isCutOffPoint = false;

                for (int j = lastCutOffIndex; j < i; j++) {
                    if (charIndexMap.get(charArr[j]) > i) {
                        isCutOffPoint = false;
                        break;
                    } else {
                        isCutOffPoint = true;
                    }
                }

                if (isCutOffPoint) {
                    lastCutOffIndex = i;
                    cutOffPoints.add(i);
                }
            }

            charIndexMap.putIfAbsent(c, S.lastIndexOf(c));
        }

        int beginIndex = 0, endIndex;

        for (int i = 0; i < cutOffPoints.size(); i++) {
            endIndex = cutOffPoints.get(i);

            res.add(new String(charArr, beginIndex, endIndex - beginIndex).length());
            beginIndex = endIndex;
        }

        if (beginIndex < charArr.length) {
            res.add(new String(charArr, beginIndex, charArr.length - beginIndex).length());
        }

        return res;
    }

    private static boolean isArmstrong(int N) {
        int sum = 0, tmp = N, exp = Integer.toString(N).length();

        while (tmp != 0) {
            sum += Math.pow((tmp % 10), exp);
            tmp /= 10;
        }

        return sum == N;
    }

    private static int[][] highFive(int[][] items) {
        int[][] studentScores = new int[1001][101];
        Set<Integer> studentIds = new HashSet<>();

        for (int[] studentScore : items) {
            studentIds.add(studentScore[0]);
            studentScores[studentScore[0]][studentScore[1]]++;
        }

        int[][] studentAverageScores = new int[studentIds.size()][2];

        for (Iterator<Integer> it = studentIds.iterator(); it.hasNext(); ) {
            int id = it.next();
            int[] scores = studentScores[id];

            int count = 0, score = 100, sum = 0;

            while (score > 0 && count < 5) {
                int scoreCount = scores[score];

                // we need the highest 5 scores
                if (count + scoreCount >= 5) {

                    sum += (5 - count) * score;
                } else if (scoreCount > 0) {
                    sum += scoreCount * score;
                }

                score--;
                count += scoreCount;
            }

            studentAverageScores[id - 1][0] = id;
            studentAverageScores[id - 1][1] = sum / 5;
        }

        return studentAverageScores;
    }

    private static int validSubarrays(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] - nums[i] >= 0) sum++;
                else break;
            }
        }

        return sum;
    }
}
