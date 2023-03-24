package ru.otus;

public class TestLogging implements TestLoggingInterface {

    @Log
    @Override
    public void calculation(int param) {};

    @Log
    @Override
    public void calculation(int param, String paramTwo) {};

    @Override
    public void calculation(int param, int paramTwo, int paramThree) {};

}
