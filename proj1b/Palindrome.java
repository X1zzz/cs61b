public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> wordDeque = new LinkedListDeque();

        for(int i=0; i <= word.length()-1; i++){
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

//    public Deque<Character> wordToDequeReserve(String word){
//        LinkedListDeque<Character> wordDeque = new LinkedListDeque();
//
//        for(int i=0; i <= word.length()-1; i++){
//            wordDeque.addFirst(word.charAt(i));
//        }
//        return wordDeque;
//    }
//
//    public boolean isPalindrome(String word) {
//        Deque<Character> orderedDeque = wordToDeque(word);
//        Deque<Character> reserveDeque = wordToDequeReserve(word);
//        for(int i=0; i <= word.length()-1; i++){
//            if (orderedDeque.removeFirst() != reserveDeque.removeFirst()) {
//                return false;
//            }
//        }
//        return true;
//
//    }

    private boolean judgeAndMinusDeque(Deque<Character> orderedDeque) {
        if (orderedDeque.size() == 0 || orderedDeque.size() == 1) {
            return true;
        }
        if (orderedDeque.removeFirst() != orderedDeque.removeLast()) {
            return false;
        }
        return judgeAndMinusDeque(orderedDeque);
    }

    public boolean isPalindrome(String word) {
        Deque<Character> orderedDeque = wordToDeque(word);
        boolean result =judgeAndMinusDeque(orderedDeque);
        return result;
    }


    private boolean judgeAndMinusDeque(Deque<Character> orderedDeque, CharacterComparator cc) {
        if (orderedDeque.size() == 0 || orderedDeque.size() == 1) {
            return true;
        }
        if (!cc.equalChars(orderedDeque.removeFirst(), orderedDeque.removeLast())) {
            return false;
        }
        return judgeAndMinusDeque(orderedDeque,cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> orderedDeque = wordToDeque(word);
        boolean result =judgeAndMinusDeque(orderedDeque,cc);
        return result;
    }

}
