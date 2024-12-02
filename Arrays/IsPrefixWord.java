public class IsPrefixWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String [] words =sentence.split(" ");
        for(int i=0 ; i<words.length ; i++){
            if(words[i].startsWith(searchWord))
            {
                return i+1;
            }
        }
        return -1;

        
    }

    public static void main(String[] args) {
        IsPrefixWord solution = new IsPrefixWord();
        String str = "this problem is an easy problem",searchWord="pro";
        System.out.println("index is:"+solution.isPrefixOfWord(str, searchWord));

    }
}