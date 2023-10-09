package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz

        //  /Users/ahmetbulutluoz/Downloads/foto.png
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png"

        System.out.println(System.getProperty("user.dir"));
        // projenin dosya yolunu verir
        // /Users/nihal/IdeaProjects/com.Team113JUnit

        System.out.println(System.getProperty("user.home"));
        // /Users/nihal

        /*
            biz Downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz

            herkesin bilgisayarinda farkli         herkeste ayni
                   /Users/nihal                 /Downloads/foto.png
            System.getProperty("user.home")     /Downloads/foto.png
         */

        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = "/Downloads/foto.png";

        String dosyaYolu= dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // ayni islemi projemizin altindaki deneme.txt icin yapsak
        // src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt

        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluherkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";

        dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
