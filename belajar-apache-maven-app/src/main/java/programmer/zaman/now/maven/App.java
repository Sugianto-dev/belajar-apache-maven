package programmer.zaman.now.maven;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 * MATERI DEPENDENCY
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );

        // MATERI DEPENDENCY
        Gson gson = new Gson();

        Person person = new Person("Eko Kurniawan Khannedy");
        String json = gson.toJson(person);

        System.out.println(json);
    }
}
