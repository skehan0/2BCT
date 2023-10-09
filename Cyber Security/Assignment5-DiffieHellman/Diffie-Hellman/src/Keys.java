class Keys{

private static long power(long a, long b, long p)
        {
        if (b == 1)
        return a;
        else
        return (((long)Math.pow(a, b)) % p);
        }

// Driver code
public static void main(String[] args)
        {
        long P, G, x, a, y, b, ga, gb;

        // Both the persons will be agreed upon the
        // public keys G and P

        // A prime number P is taken
        P = 13;
        System.out.println("The value of P:" + P);

        // A primitive root for P, G is taken
        G = 6;
        System.out.println("The value of G:" + G);

        // Alice will choose the private key a
        // a is the chosen private key
        a = 5;
        System.out.println("The private key a for Alice:" + a);

        // Gets the generated key
        x = power(G, a, P);

        // Bob will choose the private key b
        // b is the chosen private key
        b = 2;
        System.out.println("The private key b for Bob:" + b);

        // Gets the generated key
        y = power(G, b, P);

        // Generating the secret key after the exchange
        // of keys
        ga = power(y, a, P); // Secret key for Alice
        gb = power(x, b, P); // Secret key for Bob


        System.out.println("Secret key for the Alice is:" + ga);
        System.out.println("Secret key for the Bob is:" + gb);
        }
        }