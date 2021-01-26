package test.java;

/**
 * Problem:
 * NOTE: You are not allowed to use split, reverse or substring methods
 * i/p: I am a Robot!
 * o/p: I ma a Tobor!
 * <p>
 * i/p: I am a lEuc3ine
 * o/p: I ma a eNic3uel
 */

public class Test {
    /**
     *
     * @param start
     * @param end
     * @return true, if any of the character is special else return false
     */

    static boolean isSpecial(char start, char end) {

        //Checking start character is number
        if ((start >= '0' && start <= '9') || (end >= '0' && end <= '9'))
            return true;

        //Checking start character is not alphabet.
        if (!((start >= 'a' && start <= 'z') || (start >= 'A' && start <= 'Z')))
            return true;

        //Checking end character is not alphabet.
        return !((end >= 'a' && end <= 'z') || (end >= 'A' && end <= 'Z'));
    }

    /**
     *
     * @param str
     * @param start
     * @param end
     *
     * Method is reversing the individual word
     */
    public static void reverseWord(char[] str, int start, int end) {

        char temp;
        while (start <= end) {

            /**
             * Example:
             * start character=M
             * end character=y
             */
            //Check any of character is special
            if (isSpecial(str[start], str[end])) {
                start++;
                end--;
                continue;
            }

            /**Check start character is lower or not.
             * Example:
             * isStartLower=false
             */
            boolean isStartLower = (str[start] >= 'a' && str[start] <= 'z');


            /** Check end character is lower or not.
             * Example:
             * isEndLower=true
             */
            boolean isEndLower = (str[end] >= 'a' && str[end] <= 'z');

            /**Swap character
             * Example:
             * start character=y
             * end character=M
             */
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            /**if start and end character are of different type before swap, do the needful changes
             * after swap
             * Example:
             * start character=Y
             * end character=m
             */
            if ((isEndLower && !isStartLower) || (!isEndLower && isStartLower)) {
                /**if end char is lower and start char is capital, change start char to capital and
                 * end char to small
                 * Example:
                 * start character=Y
                 * end character=m
                 */
                if (isEndLower) {
                    str[start] -= 32;
                    str[end] += 32;
                }

                /**if start char is lower and end char is capital, change end char to capital and
                 * start char to small
                 * Same as above operation.
                 */
                if (isStartLower) {
                    str[start] += 32;
                    str[end] -= 32;
                }
            }

            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        String s = "My twitter Handler is !leucine30yEars";
        char[] str = s.toCharArray();
        char ch = s.charAt(s.length() - 1);
        int strLength = str.length;
        /**
         * Checking last character of given String is other than alphabets and number, if it is
         * reduce the size of string.
         */
        if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')))
            strLength--;

        int start = 0;

        for (int end = 0; end < strLength; end++) {
            if (str[end] == ' ') {
                /**
                 * reversing each word from start point to current end-1, because at the index
                 * end space is there.
                 */
                reverseWord(str, start, end - 1);
                /**
                 * Updating my start point for next word.
                 */
                start = end + 1;
            }
        }

        /**
         * Reverse last word of string.
         */
        reverseWord(str, start, strLength - 1);

        System.out.println("Reversed String -->  "+ new String(str));
    }
}
