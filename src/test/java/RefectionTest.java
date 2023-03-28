
import edu.upc.eetac.dsa.User;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefectionTest {

    @Test
    public void basic() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {


        User u1 = new User ("1", "Juan");
        Assert.assertEquals("Juan", u1.getName());


        Class c = Class.forName("edu.upc.eetac.dsa.User");
        User u2 = (User) c.newInstance();
        u2.setName("Pere");
        Assert.assertEquals("Pere", u2.getName());

        Class c2 = u1.getClass();

        for (Constructor constr: c2.getConstructors()) {
            System.out.println(constr.toGenericString());
        }
        System.out.println("====================");

        for (Field f: c2.getDeclaredFields()) {
            System.out.println(f.getName());
        }

        System.out.println("====================");

        for (Method m: c2.getDeclaredMethods()) {
            System.out.println(m.getName());
        }

        System.out.println("====================");

        User u = new User("1","Juan");
        Class uClass = u.getClass();

        Method method1 = uClass.getMethod("getId");
        String str1 = (String) method1.invoke(u, new Object[] {});
        System.out.println("getId: " + str1);

        Method method2 = uClass.getMethod("getName");
        String str2 = (String) method2.invoke(u, new Object[] {});
        System.out.println("getName: " + str2);

        Method method3 = uClass.getMethod("setName", new Class[]{String.class});
        //System.out.println("calling setString2 with 'Toni'");
        method3.invoke(u, new Object[] { "Toni" });

        Method method4 = uClass.getMethod("setId", String.class);
        //System.out.println("calling setString2 with 'Toni'");
        method4.invoke(u, new Object[] { "2" });

        str1 = (String) method1.invoke(u, new Object[] {});
        System.out.println("getId2: " + str1);

        str2 = (String) method2.invoke(u, new Object[] {});
        System.out.println("getName2: " + str2);

    }
}
