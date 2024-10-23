import java.util.*;

public class Main {

    public static String getString(){
        Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine().trim();
            if(!s.isEmpty()){
                return s;
            }
            System.out.println("String must not be empty");
        }
    }

    public static Map<String,Integer> countWord (String s) {
        StringTokenizer str = new StringTokenizer(s);
        Map<String,Integer> countWord = new HashMap<>();
        while(str.hasMoreElements()){
            String token = str.nextToken();
            if(!countWord.containsKey(token)){
                countWord.put(token,1);
            }
            else{
                countWord.put(token,countWord.get(token) + 1);
            }
        }
        return countWord;
    }

    public static Map<Character,Integer> countLetter (String s){
        Map<Character,Integer> countLetter = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i)) || Character.isLetter(s.charAt(i))){
                if (!countLetter.containsKey(s.charAt(i))){
                    countLetter.put(s.charAt(i),1);
                }
                else{
                    countLetter.put(s.charAt(i), countLetter.get(s.charAt(i)) + 1);
                }
            }
        }
        return countLetter;
    }

    public static <K> void displaySortMap(Map<K, Integer> map){
        List<Map.Entry<K, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry<K, Integer>::getValue).reversed());
        System.out.print("{");
        for (Map.Entry<K, Integer> entry : list){
            System.out.print(entry.getKey() + "=" + entry.getValue() +" ");
        }
        System.out.print("}\n");
    }

    public static <K extends Comparable<K>> void displaySortCharacter(Map<K, Integer> map){
        List<Map.Entry<K, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<K,Integer>> comparator = new Comparator<Map.Entry<K, Integer>>() {
            @Override
            public int compare(Map.Entry<K, Integer> o1, Map.Entry<K, Integer> o2) {
               K key1 = o1.getKey();
               K key2 = o2.getKey();
               return -key1.compareTo(key2);
            }
        };
        list.sort(comparator);
        System.out.print("{");
        for (Map.Entry<K, Integer> entry : list){
            System.out.print(entry.getKey() + "=" + entry.getValue() +" ");
        }
        System.out.print("}\n");
    }

    public static void display(String s){
        Map<String,Integer> word = countWord(s);
        Map<Character,Integer> letter = countLetter(s);
        System.out.println(countWord(s));
        System.out.println(countLetter(s));
        displaySortMap(word);
        displaySortMap(letter);
        displaySortCharacter(letter);
    }

    public static void main(String[] args) {
        System.out.print("Enter your string:");
        String s = getString();
        countWord(s);
        countLetter(s);
        display(s);
    }
}