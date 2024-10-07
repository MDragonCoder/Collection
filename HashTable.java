import java.util.LinkedList;

class HashTable<T>
{
    private final double MAX_LOAD_FACTOR = 2; // maximum load factor.
    private final double MIN_LOAD_FACTOR = 0.5; // minimum load factor.

    private int n; // number of elements.
    private int[] m = {3, 7, 17, 37, 79, 163, 331}; // size of the table
    private int j; // index for the array m.
    private LinkedList<T>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        j = 0;
        table = new LinkedList[m[j]];//location of new Linked Lists
        for(int i = 0; i < table.length; i++)//going through linked list with value = null
            table[i] = new LinkedList<T>();// making eavch index a linked list of type T
    }

    private int hashFunction(int key) {
        return key % m[j];//makes each key relate to the linked list
    }

    private double loadFactor() {
        return (double) n / m[j];// capcity of linked list in linked list
    }

    public boolean contains(T element) {
        int key = element.hashCode() & 0x7fffffff;
        int hashValue = hashFunction(key);
        return table[hashValue].contains(element);
    }

    public void add(T element) {
        int key = element.hashCode() & 0x7fffffff;//takes the element and converts it into a hashValue
        int hashValue = hashFunction(key);//uses the function to relate the key to make it searchable by 
        if(table[hashValue].contains(element)){
            table[hashValue].add(element);
            n++;
            if(loadFactor() > MAX_LOAD_FACTOR){
                j++;
                LinkedList<T>[] table2 = new LinkedList[m[j]];
                for(int i = 0; i < table.length; i++){
                table[i] = new LinkedList<T>();
                }
                for(int i = 0; i< table.length;i++){
                    for(T e: table[i]){
                     int keys = e.hashCode() & 0x7fffffff;
                     int hashValue2 = hashFunction(keys);
                     table2[hashValue2].add(e);


                    }
                } table = table2;
            }
        } 
    }

    public void remove(T element) {
        int key = element.hashCode() & 0x7fffffff;
        int hashValue = hashFunction(key);
        if(table[hashValue].contains(element)) {
            table[hashValue].remove(element);
            n--;
            if(loadFactor() < MIN_LOAD_FACTOR){
                j--;
                LinkedList<T>[] table2 = new LinkedList[m[j]];//need new Linked Lists != null before giving arrays
                for(int i = 0; i < table.length; i++){
                table[i] = new LinkedList<T>();
                }
                for(int i =0; i< table.length; i++){
                    for(T r : table[i]){
                        int keys = r.hashCode() & 0x7fffffff;
                        int hashValue3 = hashFunction(keys);
                        table2[hashValue3].add(r);
                    }
                }table = table2;
            }
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("n=" + n + ", m=" + m[j] + ", n/m=" + String.format("%.2f", loadFactor()) + "\n");
        builder.append("{\n");
        for(int i = 0; i < table.length; i++)
            builder.append((i < 10 ? "0" : "") + i + ": " + table[i] + "\n");
        builder.append("}\n");
        return builder.toString();
    }
}
