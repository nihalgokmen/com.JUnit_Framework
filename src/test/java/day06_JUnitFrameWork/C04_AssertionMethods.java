package day06_JUnitFrameWork;


import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethods {

    @Test
    public void test01(){

        /*
            Eger testin sonucunu turkce olarak OLUMLU bir cumle ile sorduysa --> assertTrue kullaniriz
            Eger OLUMSUZ cumle kullanilmissa --> assertFalse kullaniriz.

         */

        int sayi1 = 20;
        int sayi2 = 10;
        int sayi3 = 30;

        // Sayi1'in Sayi2'den buyuk oldugunu test edin
        Assert.assertTrue(sayi1>sayi2); // PASSED

        // sayi1'in sayi 3'ten buyuk olmadigini test edin
        Assert.assertFalse(sayi1>sayi3); // PASSED

        // sayi1'in sayi3'ten kucuk oldugunu test edin
        Assert.assertTrue(sayi1<sayi3); // PASSED

    }
}
