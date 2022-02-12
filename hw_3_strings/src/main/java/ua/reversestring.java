package ua;

public class reversestring {
    public static String reverse(String src) {
        char[] array = src.toCharArray();
        for (int counter=0; counter < array.length/2; counter++) {
            char tmp = array[counter];
            array[counter] = array[array.length-1-counter];
            array[array.length-1-counter] = tmp;
        }
        return String.valueOf(array);
    }

    public static String reverse(String src, String dest) {
        return src.replace(dest,reverse(dest));
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String sub = reverse(src.substring(firstIndex,lastIndex));
        String[] parts = src.split(src.substring(firstIndex, lastIndex),2);
        return parts[0]+sub+parts[1];
    }
}
