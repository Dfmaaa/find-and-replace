
public class Main2 {
    public static void main(String[] args){

        String word=args[0];
        String find=args[1];
        String replace=args[2];

        // Maximum amount of elements the new array can require. 
        int x = (int)(Math.floor( word.length() / find.length()  ) + 1 ) * Math.abs( replace.length() - word.length() );
        
        char new_arr[] = new char[x];

        int narr_cnt = 0;

        int total_occurences = 0;


        for(int i = 0; i< word.length(); i++){

            if(word.charAt(i) == find.charAt(0)){
                // this means there's no more space for more possibilities
                if(i+find.length() > word.length()){
                    break;
                }

                //// possibility of going out of bounds has been removed.

                // last characters of possible string and target string aren't equal
                else if(word.charAt(i+find.length()-1) != find.charAt(find.length()-1)){
                    
                    new_arr[narr_cnt] = word.charAt(i);
                    
                    narr_cnt++;

                    continue; // it will look for another occurence of first letter of target after this
                
                }
                
                // case is now: first and last letters match. middle has to be checked now. 
                else{

                    int NFLAG = 0;

                    for(int j = 0; j < find.length() -1; j++){

                        if(word.charAt(i+j) != find.charAt(j)){

                            NFLAG = 1;
                            break;

                        }
                        
                        

                    }

                    // target string found
                    if(NFLAG != 1){
                        System.out.println("Target string " + find + " found from [" + i + "] to [" + (i+find.length()-1) + "]. Replacing with " + replace );

                        int z = 0;

                        for (z = 0; z < replace.length(); z ++){

                            new_arr[narr_cnt + z ] = replace.charAt(z);
                        }

                        narr_cnt += z;

                        i+=find.length()-1;

                        total_occurences++;
                    }

                }


            }

            else{

                new_arr[narr_cnt] = word.charAt(i);

                narr_cnt++;

                continue; // added for clarity
            }

        }

            if(total_occurences == 0){
                System.out.println("No occurences of " + find + " found in " + word);

            }

            else{

                System.out.println("Total occurences of " + find + " found in " + word + " : " + total_occurences); 

                System.out.println("Printing new string with replaced text.");

                for(int i = 0; i<narr_cnt+1; i++){
                    System.out.print(new_arr[i]);
                }
                System.out.println("");

            }


    }
}