package Book;

import java.util.*;

class PhoneBook {
    private Map<String, Set<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        Set<Integer> phoneNumbers = phoneBook.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNum);
        phoneBook.put(name, phoneNumbers);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, Set<Integer>>> entryList = new ArrayList<>(phoneBook.entrySet());
        Comparator<Map.Entry<String, Set<Integer>>> valueComparator = Comparator
                .comparingInt(entry -> entry.getValue().size());
        entryList.sort(valueComparator.reversed());
        for (Map.Entry<String, Set<Integer>> entry : entryList) {
            System.out.println(entry.getKey() + " Phone numbers: " + entry.getValue());
        }
    }
}

public class phoneB {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("John", 123456789);
        phoneBook.add("Jane", 987654321);
        phoneBook.add("John", 987654321);
        phoneBook.add("Jane", 555555555);
        phoneBook.add("Alice", 111111111);
        phoneBook.add("Bob", 222222222);
        phoneBook.add("Alice", 333333333);

        phoneBook.printPhoneBook();
    }
}

