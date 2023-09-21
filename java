
/*
ID: 100021881
LANG: JAVA
PROG: zerosum
*/

import java.io.*;
import java.util.*;

public class zerosum {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("zerosum.in"));
        int N = Integer.parseInt(br.readLine());
        br.close();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
        System.out.println(N);
        System.out.println(sum("1 2-3+4"));
        Deque<String> deque = new LinkedList<String>();
        deque.add("");
        while (!deque.isEmpty()) {
            String item = deque.remove();
            int len = item.length() / 2 + 1;
            item += String.valueOf(len);
            //System.out.println(item + "\t" + sum(item));
            if (len < N) {
                deque.add(item + " ");
                deque.add(item + "+");
                deque.add(item + "-");
            } else if (len == N) {
                if (sum(item) == 0) {
                    out.println(item);
                }
            } else {
                break;
            }
        }
