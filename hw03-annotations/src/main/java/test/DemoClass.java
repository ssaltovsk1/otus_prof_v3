package test;

import java.util.Objects;

public class DemoClass {
    private int number;
    private String name;
    public DemoClass() {
    }
    public DemoClass(int number, String name) {
        this.number = number;
        this.name = name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemoClass demoClass)) return false;
        return getNumber() == demoClass.getNumber() && Objects.equals(name, demoClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getText());
    }

    public String getText() {
        return name;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    private void printData(){
        System.out.println(number + name);
    }


}