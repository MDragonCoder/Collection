import java.util.Random;

class Test {
    public static void main(String[] args)
    {
        HashTable<Integer> hashtable = new HashTable<Integer>();
        System.out.println(hashtable);

        Random rand = new Random(12); // Set the seed to 12 to obtain the same pseudorandom values.
        for(int i = 0; i < 40; i++) { // Repeat 40 times.
            int x = rand.nextInt(90000) + 10000; // Generate a five-digit pseudorandom integer x.
            hashtable.add(x); // Add x to the hash table.
            System.out.println(hashtable); // Print the hash table.
        }

        rand.setSeed(12); // Set the seed to 12 seed to obtain the same pseudorandom values.
        for(int i = 0; i < 40; i++) { // Repeat 40 times.
            int x = rand.nextInt(90000) + 10000; // Generate a five-digit pseudorandom integer x.
            hashtable.remove(x); // Remove x from the hash table.
            System.out.println(hashtable); // Print the hash table.
        }
    }
}
