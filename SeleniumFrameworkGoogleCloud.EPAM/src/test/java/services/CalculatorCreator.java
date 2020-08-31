package services;

import settingscalc.Calculator;

public class CalculatorCreator {

    private static final String NUMBER_OF_INSTANCE = "numberOfInstance";
    private static final String OPERATING_SYSTEM = "operatingSystem";
    private static final String MACHINE_CLASS = "machineClass";
    private static final String MACHINE_TYPE = "machineType";
    private static final String NUMBER_OF_GPU = "numberOfGPU";
    private static final String TYPE_GPU = "typeGPU";
    private static final String LOCAL_SSD = "localSSD";
    private static final String DATACENTER_LOCATION = "datacenterLocation";
    private static final String COMMITTED_USAGE = "committedUsage";

    public static Calculator createCalculatorWithSomeProperty() {
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
