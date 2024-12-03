public class AddingSpacesToString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder();
         str.append(s.substring(0,spaces[0]));
         int i=1;
         for(;i<spaces.length;i++){
            str.append(" ");
            str.append(s.substring(spaces[i-1],spaces[i]));
         }
         str.append(" ");
         str.append(s.substring(spaces[i-1]));

         return str.toString();
        
    }
    public static void main(String[] args) {
        AddingSpacesToString soln = new AddingSpacesToString();
        String s ="LeetcodeHelpsMeLearn";
        int [] spaces ={8,13,15};
        System.out.println("After adding spaces : " + soln.addSpaces(s,spaces));
    }

    
}