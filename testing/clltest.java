package infowiz.com.mytestingcode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by win10 on 23/02/2018.
 */

public class clltest {
    testter t;
    @Test
    public void get() throws Exception
    {
        t=new testter();
        int res=t.sum(20,20);
        int c=10+10;
        assertEquals(40,res);

        System.out.print(c);


    }

}
