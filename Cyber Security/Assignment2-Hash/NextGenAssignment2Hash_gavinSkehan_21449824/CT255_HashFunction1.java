import java.security.SecureRandom;
/**
 *
 * @author Gavin Skehan
 */
public class CT255_HashFunction1 {
    public static void main(String[] args) {
        int res = 0;

        if (args != null && args.length > 0) { // Check for <input> value
            res = hashF1(args[0]); // call hash function with <input>
            if (res < 0) { // Error
                System.out.println("Error: <input> must be 1 to 64 characters long.");
            }
            else {
                System.out.println("input = " + args[0] + " : Hash = " + res);
                System.out.println("Start searching for collisions");
                // Your code to look for a hash collision starts here!

                // characters the password generator can use
                String ALPHA_CAPS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String ALPHA="abcdefghijklmnopqrstuvwxyz";
                String NUMERIC = "0123456789";

                int i = 0;

                while(i<10){
                    String password = randomPassword(10, ALPHA_CAPS + ALPHA + NUMERIC);
                    // Call password with 10 characters long with the above character variables
                    int tempHash = hashF1(password); // hashing the password so we can comapre
                    // it to the hash of the input
                    if(tempHash==res) { // check to see if the hash is the same
                        System.out.printf("Collision found with Password: %s\n", password);
                        // print collision
                        i++;
                    }

                }
        }
    }
        else { // No <input>
        System.out.println("Use: CT255_HashFunction1 <Input>");
    }
}

    private static int hashF1(String s){
        int ret = -1, i;
        int[] hashA = new int[]{1, 1, 1, 1};

        String filler, sIn;

        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");

        if ((s.length() > 64) || (s.length() < 1)) { // String does not have required length
            ret = -1;
        }
        else {
            sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
            sIn = sIn.substring(0, 64); // // Limit string to first 64 characters
            // System.out.println(sIn); // FYI
            for (i = 0; i < sIn.length(); i++){
                char byPos = sIn.charAt(i); // get i'th character
                hashA[i % 4] += (byPos * 17); // randomise so there are less collisions
                hashA[(i+1) % 4] += (byPos * 31);
                hashA[(i+2) % 4] += (byPos * 101);
                hashA[(i+3) % 4] += (byPos * 79);
            }

            hashA[0] %= 255;  // % is the modulus operation, i.e. division with rest
            hashA[1] %= 255;
            hashA[2] %= 255;
            hashA[3] %= 255;

            ret = hashA[0] + (hashA[1] * 256) + (hashA[2] * 256 * 256) + (hashA[3] * 256 * 256 * 256);
            if (ret < 0) ret *= -1;
        }
        return ret;
    }
    
    private static String randomPassword(int len, String dic){ // random password generator
        SecureRandom random = new SecureRandom();
        
        String result = "";
        for(int i = 0;i < len;i++){ // repeats 10 times
            int index = random.nextInt(dic.length()); // pick random number between the range
            result += dic.charAt(index); // Adds character at position of index
        }
        return result; // returns result to string password
    }
}
