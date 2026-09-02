package pckg_fst;

import java.util.concurrent.ThreadLocalRandom;

public class AUX_CLS {
    private static final int ORIGIN = 0;
    private static final int BOUND = 250;

    public static int[] getIntArray(int numElements) {
        int[] array = new int[numElements];
        for(int k=0; k<numElements; k++){
            array[k] = ThreadLocalRandom.current().nextInt(ORIGIN,BOUND);
        }
        return array;
    }
}
