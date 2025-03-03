package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "ta";
        } else if (query.contains("which of the following numbers is the largest")) {
            String[] words = query.replaceAll(",", "").split(" ");
            boolean record = false;
            int largest = -1;
            for (int i = 0; i < words.length; i++) {
                if (record) {
                    if (Integer.parseInt(words[i]) > largest) {
                        largest = Integer.parseInt(words[i]);
                    }
                }
                if (words[i].equals("largest:")) {
                    record = true;
                }
            }
            return String.valueOf(largest);
        }  else if (query.contains("plus")) {
            String[] words = query.split(" ");
            return String.valueOf(Integer.parseInt(words[3]) + Integer.parseInt(words[5]));
        } else if (query.contains("multiplied")) {
            String[] words = query.split(" ");
            return String.valueOf(Integer.parseInt(words[3]) * Integer.parseInt(words[6]));
        } else if (query.contains("cube")) {
            String[] words = query.replaceAll(",", "").split(" ");
            boolean record = false;
            int largest = 1;
            for (int i = 0; i < words.length; i++) {
                if (record) {
                    int num = Integer.parseInt(words[i]);
                    if (Math.sqrt(num) == Math.round(Math.sqrt(num)) && Math.cbrt(num) == Math.round(Math.cbrt(num))) {
                        largest = num;
                    }
                }
                if (words[i].equals("cube:")) {
                    record = true;
                }
            }
            return String.valueOf(largest);
        } else if (query.contains("banana")) {
            return "yellow";
        } else if (query.contains("james bond")) {
            return "Sean Connery";
        } else if (query.contains("primes")) {
            String[] words = query.replaceAll(",", "").split(" ");
            boolean record = false;
            List<Integer> primes = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (record) {
                    if (isPrime(Integer.parseInt(words[i]))) {
                        primes.add(Integer.parseInt(words[i]));
                    }
                }
                if (words[i].equals("primes:")) {
                    record = true;
                }
            }
            return primes.toString();
        } else {
            return "";
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
