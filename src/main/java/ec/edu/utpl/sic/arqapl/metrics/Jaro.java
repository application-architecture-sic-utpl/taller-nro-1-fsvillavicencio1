package ec.edu.utpl.sic.arqapl.metrics;

import org.apache.commons.text.similarity.JaroWinklerDistance; 
/**
 *
 * @author Freddy
 */
public class Jaro implements Similaritable{

    @Override
    public double similarity(String text1, String text2) {
        JaroWinklerDistance algorithm = new JaroWinklerDistance();
        return algorithm.apply(text1, text2);
    }
    
}
