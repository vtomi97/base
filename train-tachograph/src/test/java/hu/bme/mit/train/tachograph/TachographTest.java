package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachographTest {
    Tachograph t;

    @Before
    public void init(){
        t = new Tachograph();
    }

    @Test
    public void TachoTest(){
        t.add(12,50);
        Assert.assertEquals(false,t.isEmpty());
    }
}
