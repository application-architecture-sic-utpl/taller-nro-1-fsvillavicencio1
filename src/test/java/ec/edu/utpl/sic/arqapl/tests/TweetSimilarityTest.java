/*Autor: Freddy Villavicencio*/

package ec.edu.utpl.sic.arqapl.tests;

import ec.edu.utpl.sic.arqapl.TweetSimilarity;
import ec.edu.utpl.sic.arqapl.metrics.Cosine;
import ec.edu.utpl.sic.arqapl.metrics.Jaccard;
import ec.edu.utpl.sic.arqapl.metrics.Jaro;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TweetSimilarityTest{
    
    @Parameters
    public static Iterable<Object[]> lista(){
        return Arrays.asList(new Object[][]{
            {"Hola mundo", "Hola mundo", 1.0}, {"Hola mundo netbeans java", "Hola mundo netbeans", 0.75}, {"Hola mundo", "Hola", 0.5},
            {"Hola mundo java", "Hola", 0.33}, {"Hola mundo netbeans java", "Hola", 0.25}, {"Hola", "Como", 0.00}
        });
    }
    
    private final String tweet1;
    private final String tweet2;
    private final double exp;
    
    public TweetSimilarityTest(String tweet1, String tweet2, double exp) {
        this.tweet1 = tweet1;
        this.tweet2 = tweet2;
        this.exp = exp;
    }
    
   
    @Test
    public void similar(){
        TweetSimilarity ts = new TweetSimilarity(new Jaccard());
        double result = ts.similarity(tweet1, tweet2);
        assertEquals("ERROR, no es el resultado esperado (Jaccard): ", exp, result, 0.01);
    }
    
    @Test
    public void similar2(){
        TweetSimilarity ts = new TweetSimilarity(new Cosine());
        double result = ts.similarity(tweet1, tweet2);
        assertEquals("ERROR, no es el resultado esperado (Cosine): ", exp, result, 0.01);
    }
    
    @Test
    public void similar3(){
        TweetSimilarity ts = new TweetSimilarity(new Jaro());
        double result = ts.similarity(tweet1, tweet2);
        assertEquals("ERROR, no es el resultado esperado (Jaro): ", exp, result, 0.01);
    }
}
