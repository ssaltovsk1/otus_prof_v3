package test;

public class Tests {

    private final DemoClass demoClassWithConstructor = new DemoClass(123, "DemoName");

    @Before
    public void testDemoClassWithArgumentsConstructor(){
        DemoClass expectedClass = new DemoClass(123, "DemoName");

        try {
            ComparisonMethods.comparison(expectedClass, demoClassWithConstructor);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }

    @Before
    public void testInteger(){

        int expected = 3;
        int result = demoClassWithConstructor.getNumber();

        try {
            ComparisonMethods.comparison(expected, result);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }

    @Before
    public void testText(){
        String expected = "text";
        String result = demoClassWithConstructor.getText();

        try {
            ComparisonMethods.comparison(expected, result);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }

    @Test
    public void testIntegerTest(){

        int expected = 3;
        int result = demoClassWithConstructor.getNumber();

        try {
            ComparisonMethods.comparison(expected, result);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }

    @Test
    public void secondTestText(){
        String expected = "test1";
        String result = demoClassWithConstructor.getText();

        try {
            ComparisonMethods.comparison(expected, result);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }

    @Test
    public void testTextForTestIncorrect(){
        String expected = "DemoName";
        String result = demoClassWithConstructor.getText();

        try {
            ComparisonMethods.comparison(expected, result);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }

    @After
    public void afterTextForTestIncorrect(){
        int expected = 123;
        int result = demoClassWithConstructor.getNumber();

        try {
            ComparisonMethods.comparison(expected, result);
        } catch (Throwable e) {
            System.err.printf("Error: " + e.getMessage());
        }
    }
}
