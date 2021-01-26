package com.micro;

import java.util.*;

class Solution {


    public static int countInversion(int[] arr, int l, int m, int r) {
        int left[] = Arrays.copyOfRange(arr, l, m + 1);
        int right[] = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps++;

            }
        }
        return swaps;

    }


    public static int recurUtil(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += recurUtil(arr, l, m);
            count += recurUtil(arr, m + 1, r);
            count += countInversion(arr, l, m, r);
        }

        return count;
    }

    public static boolean checkPossibility(int[] nums) {
        int val = recurUtil(nums, 0, nums.length - 1);
        return val <= 1;
    }

    public static boolean checkPossibilityTest(int[] nums) {

        int count = 0;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }

                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];

                } else {
                    nums[i] = nums[i + 1];
                }

            }
        }

        return true;
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() == 0 || B.length() == 0)
            return false;
        char[] tempAChar = A.toCharArray();
        char[] tempBChar = B.toCharArray();
        if (A.equals(B)) {
            for (int i = 1; i < tempAChar.length; i++) {
                if (tempAChar[i - 1] != tempAChar[i])
                    return false;
            }
            return true;
        }

        int changedCount = 0;
        int changeIdx1 = -1;
        int changeIdx2 = -1;
        boolean flag = false;
        for (int i = 0; i < tempAChar.length; i++) {
            if (tempAChar[i] != tempBChar[i]) {
                changedCount++;
                if (!flag)
                    changeIdx1 = i;
                if (flag)
                    changeIdx2 = i;
                flag = true;
            }

        }


        if (changedCount > 2)
            return false;
        char temp = tempAChar[changeIdx1];
        tempAChar[changeIdx1] = tempAChar[changeIdx2];
        tempAChar[changeIdx2] = temp;
        if (new String(tempAChar).equals(new String(tempBChar)))
            return true;
        else
            return false;


    }

    public long thirdMax(int[] nums) {
        long first, second, third;
        first = Integer.MIN_VALUE;
        second = Integer.MIN_VALUE;
        third = Integer.MIN_VALUE;
        boolean minValueExists = false;
        for (Integer i : nums) {
            if (i == Integer.MIN_VALUE) minValueExists = true;
            if (i > first) {
                third = second;
                second = first;
                first = i;
            } else if (i > second && i != first) {
                third = second;
                second = i;
            } else if (i > third && i != second && i != first) {
                third = i;
            }
        }

        if (second != third && (minValueExists || third > Integer.MIN_VALUE))
            return third;
        return first;


        //System.out.println(third);

    }

    public void switchA(int[] arr) {
        int count = 0;
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == 0 && arr[i + 1] == 0) {
                count++;
                i += 2;
            } else break;
        }
        while (i < arr.length - 1) {
            if (arr[i] == 1) break;
            i++;
        }
        int j = arr.length - 1;
        while (j >= i) {
            if (arr[j] == 0 && arr[j - 1] == 0) {
                count++;
                j -= 2;
            } else break;
        }
        while (j >= i) {
            if (arr[j] == 1) break;
            j--;
        }
        i++;
        while (i < j) {
            if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
                count++;
                i += 2;
            } else i++;
        }
        System.out.println(count);

    }

    public boolean validPalindrome(String s) {

        int count = 0;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (s.charAt(i + 1) == s.charAt(j)) {
                    i++;
                    count++;
                } else if (s.charAt(i) == s.charAt(j - 1)) {
                    j--;
                    count++;
                } else return false;
            }
        }
        if (count <= 1 && (j - i) <= 1)
            return true;
        return false;

    }

    //pattern = "abba", s = "dog cat cat dog"
    /*
        a dog
        b cat
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        char[] patternArr = pattern.toCharArray(); // a b b a
        String[] strArray = s.split(" "); //dog cat cat dog
        if (patternArr.length != strArray.length) return false;
        Set<Character> patSet = new HashSet<>();
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < patternArr.length; i++) {
            char ch = patternArr[i];
            String str = strArray[i];
            patSet.add(ch);
            strSet.add(str);
            if (map.containsKey(ch) && !map.get(ch).equals(str)) {
                return false;
            } else map.put(ch, str);
        }
        if (patSet.size() != strSet.size())
            return false;
        return true;

    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            head = next;
            next = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        head.next = prev;
        return head;
    }

    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        double sum = 0;

        while (j < k) {
            sum += nums[j];
            j++;
        }
        double avg = sum / k;
        while (j < nums.length) {
            sum = sum - nums[i] + nums[j];
            double currAvg = sum / k;
            if (currAvg > avg) {
                avg = currAvg;
            }
            i++;
            j++;
        }
        return avg;
    }


    public int findLengthOfLCIS(int[] nums) {


        int l = 1;
        int max = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev)
                l++;
            else {
                if (l > max) max = l;
                l = 1;
            }
            prev = nums[i];
        }

        if (l > max)
            max = l;
        return max;

    }

    public String recur(String str, int n, int k) {

        if (k == n) return str;
        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        char ch = charArr[0];
        int count = 1;
        for (int i = 1; i < charArr.length; i++) {
            if (ch == charArr[i]) {
                count++;
            } else {
                sb.append("" + count + "" + ch);
                ch = charArr[i];
                count = 1;

            }
        }
        sb.append("" + count + "" + ch);

        return recur(sb.toString(), n, k + 1);

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        String[] strArray = paragraph.toLowerCase().split(" ");
        for (String str : strArray) {
            if (!set.contains(str)) {
                Integer freq = map.getOrDefault(str, 0);
                map.put(str, freq + 1);
            }
        }

        List list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return ((Map.Entry<String, Integer>) list.get(0)).getKey();


    }

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j += 2) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    static void matrixRotation(int[][] mat, int t) {
        int m = mat.length;
        int n = mat[0].length;

//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++)
//                arr[i][j]=matrix.get(i).get(j);
//        }

        while (t-- > 0) {
            int r = 0, c = 0, row = m - 1, col = n - 1;
            int k = 0;
            while (r < row && c < col) {
                int val = mat[r][c];
                for (int i = r + 1; i <= row; i++) {
                    k = mat[i][c];
                    mat[i][c] = val;
                    val = k;
                }
                for (int j = c + 1; j <= col; j++) {
                    k = mat[row][j];
                    mat[row][j] = val;
                    val = k;
                }
                for (int i = row - 1; i >= r; i--) {
                    k = mat[i][col];
                    mat[i][col] = val;
                    val = k;
                }
                for (int j = col - 1; j >= c; j--) {
                    k = mat[r][j];
                    mat[r][j] = val;
                    val = k;
                }
                r++;
                c++;
                row--;
                col--;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }


    }

    static long arrayManipulation(int n, int[][] queries) {

        long[] dp = new long[n + 1];
        for (int i = 0; i < queries.length ; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            dp[a] += k;
            if (b + 1 < n + 1)
                dp[b + 1] -= k;
        }
        long max = 0;
        for (int i = 1; i < n + 1; i++) {
            long k = max + dp[i];
            if (k > max)
                max = k;
        }

        return max;

    }


    public static void main(String[] args) {


        int[][] arr = {{1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}};
        System.out.println( arrayManipulation(5, arr));


        Solution sol = new Solution();
        // System.out.println(sol.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        //  System.out.println(sol.wordPattern("abba", "dog dog dog dog"));

//        ListNode node1 = new ListNode(1, null);
//        ListNode node2 = new ListNode(2, null);
////        Node node3 = new Node(2, null);
//        Node node4 = new Node(1, null);

        //      node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

     /*   ListNode head = node1;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode head1 = p1.next;

        ListNode head2 = reverse(head1);

        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                System.out.println("false");
                return;
            }
            head = head.next;
            head2 = head2.next;
        }
        System.out.println(true);
*/

//    int[] arr={2,2,2,2,2};
//    int k=4;
//    sol.findLengthOfLCIS(arr);

        //    System.out.println(sol.recur("1", 4, 1));
        // int arr[] = {1, 4, 2, 5, 3};
        String str = "";

        //   System.out.println(sol.sumOddLengthSubarrays(arr));

        int[] charArr = new int[26];
        String str1 = "53456390";
        char[] pp = str1.toCharArray();

        Arrays.sort(pp);
//        System.out.println(sol.findMinFibonacciNumbers(7));
//        System.out.println(sol.findMinFibonacciNumbers(10));
//        System.out.println(sol.findMinFibonacciNumbers(1000000000));

        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(sol.maxIncreaseKeepingSkyline(grid));
//        for(int i=0;i<str1.length();i++)
//        {
//            int j=str1.charAt(i)-'a';
//            charArr[j]++;
//        }
//        for(int i=0;i<26;i++)
//            if(charArr[i]!=0){
//                System.out.println((char) ('a'+i) +" " +charArr[i]);
//            }
//        String jewels="sdf";
//        char[] jewelsArr=jewels.toCharArray();
//        Set<Character> characters=new HashSet<>();
//        for(int i=0;i<jewels.length();i++)
//            characters.add(jewels.charAt(i));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] leftView = new int[grid.length];
        int[] topView = new int[grid[0].length];

        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] > max)
                    max = grid[i][j];
            leftView[k++] = max;
        }
        k = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++)
                if (grid[j][i] > max)
                    max = grid[j][i];
            topView[k++] = max;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int x = leftView[i];
            for (int j = 0; j < grid[0].length; j++) {
                int y = topView[j];
                res += Math.min(x, y) - grid[i][j];
            }
        }

        return res;
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> arr = new ArrayList<>();

        int a = 1;
        int b = 1;
        arr.add(1);
        int c = a + b;
        while (c <= k) {
            arr.add(c);
            a = b;
            b = c;
            c = a + b;
        }

        int count = 0;
        int idx = arr.size() - 1;


        while (k != 0) {
            idx = binarySearch(arr, k, idx);
            k -= arr.get(idx);
            count++;
        }

        return count;

    }

    public int binarySearch(List<Integer> list, int k, int end) {
        int start = 0;
        int mid = start + (end - start) / 2;

        while (start < end) {
            mid = start + (end - start) / 2;
            int midNo = list.get(mid);
            if (midNo == k) {
                return mid;
            } else if (midNo > k) {
                if (mid > 0 && list.get(mid - 1) <= k) {
                    return mid - 1;
                }
                end = mid - 1;
            } else {
                if (mid < list.size() - 1 && list.get(mid + 1) > k) {
                    return mid;
                }
                start = mid + 1;
            }
        }

        return list.size() - 1;
    }

    public int minPartitions(String n) {
        char[] charArray = n.toCharArray();
        Arrays.sort(charArray);
        return charArray[charArray.length - 1];
    }
}