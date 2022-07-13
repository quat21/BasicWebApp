package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

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
                    if (Integer.parseInt(word) > largest) {
                        largest = Integer.parseInt(word);
                    }
                }
                if (words[i].equals("largest:")) {
                    record = true;
                }
            }
            return String.valueOf(largest);
        }  else if (true) {
            return "";
        } else if (true) {
            return "";
        } else if (true) {
            return "";
        } else if (true) {
            return "";
        } else if (true) {
            return "";
        } else if (true) {
            return "";
        } else {
            return "";
        }
    }
}
