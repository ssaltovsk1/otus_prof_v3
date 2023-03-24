import test.*;

import java.lang.reflect.InvocationTargetException;

public class TestStarter {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        NotationStarter notationStarter = new NotationStarter();
        notationStarter.initializeMethodsWithNotations(Tests.class);

    }
}

