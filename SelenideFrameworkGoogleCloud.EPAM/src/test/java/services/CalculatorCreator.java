package services;

import settingscalc.Calculator;

public class CalculatorCreator {

    public static final String NUMBER_OF_INSTANCE = "numberOfInstance";
    public static final String OPERATING_SYSTEM = "operatingSystem";
    public static final String MACHINE_CLASS = "machineClass";
    public static final String MACHINE_TYPE = "machineType";
    public static final String NUMBER_OF_GPU = "numberOfGPU";
    public static final String TYPE_GPU = "typeGPU";
    public static final String LOCAL_SSD = "localSSD";
    public static final String DATACENTER_LOCATION = "datacenterLocation";
    public static final String COMMITTED_USAGE = "committedUsage";

    public static Calculator createCalculatorWithSomeProperty(){
        return new Calculator(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU),
                TestDataReader.getTestData(TYPE_GPU),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }


}
