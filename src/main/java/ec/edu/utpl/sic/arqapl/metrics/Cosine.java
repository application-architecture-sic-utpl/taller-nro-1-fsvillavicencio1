package ec.edu.utpl.sic.arqapl.metrics;

import org.apache.commons.text.similarity.CosineDistance;

public class Cosine implements Similaritable {
    
    @Override
    public double similarity(String text1, String text2) {
        CosineDistance cosine = new CosineDistance();
        double similarity = 1.0 - cosine.apply(text1, text2);

        return similarity;
    }
}
