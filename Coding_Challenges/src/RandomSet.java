import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomSet {
	int size=0;
	Map<Integer, Integer> indexToValMap = new HashMap<Integer, Integer>();
    Map<Integer,Integer> valToIndexMap= new HashMap<Integer, Integer>();
    public boolean insert(int val) {
        indexToValMap.put(size, val);
        valToIndexMap.put(val, size);
        size++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valToIndexMap.containsKey(val)){
        	int index=valToIndexMap.get(val);
        	valToIndexMap.remove(val);
        	indexToValMap.remove(index);
        	return true;
        }
        else{
        	return false;
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index=random.nextInt(size);
        return indexToValMap.get(index);
    }
}
