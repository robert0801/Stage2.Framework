package settingscalc;


import java.util.Objects;

public class Calculator {

    private String numberOfInstance;
    private String operatingSystem;
    private String machineClass;
    private String typeMachineType;
    private String numberOfGPU;
    private String typeGPUType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public Calculator(String numberOfInstance, String operatingSystem, String machineClass, String typeMachineType,
                      String numberOfGPU, String typeGPUType, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstance = numberOfInstance;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.typeMachineType = typeMachineType;
        this.numberOfGPU = numberOfGPU;
        this.typeGPUType = typeGPUType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getTypeMachineType() {
        return typeMachineType;
    }

    public void setTypeMachineType(String typeMachineType) {
        this.typeMachineType = typeMachineType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getTypeGPUType() {
        return typeGPUType;
    }

    public void setTypeGPUType(String typeGPUType) {
        this.typeGPUType = typeGPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numberOfInstance=" + numberOfInstance +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", typeMachineType='" + typeMachineType + '\'' +
                ", numberOfGPU=" + numberOfGPU +
                ", typeGPUType='" + typeGPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", typeDatacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator calc = (Calculator) o;
        return numberOfInstance == calc.numberOfInstance &&
                numberOfGPU == calc.numberOfGPU &&
                Objects.equals(getOperatingSystem(), calc.getOperatingSystem()) &&
                Objects.equals(getMachineClass(), calc.getMachineClass()) &&
                Objects.equals(getTypeMachineType(), calc.getTypeMachineType()) &&
                Objects.equals(getTypeGPUType(), calc.getTypeGPUType()) &&
                Objects.equals(getLocalSSD(), calc.getLocalSSD()) &&
                Objects.equals(getDatacenterLocation(), calc.getDatacenterLocation()) &&
                Objects.equals(getCommittedUsage(), calc.getCommittedUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, operatingSystem, machineClass, typeMachineType, numberOfGPU, typeGPUType, localSSD, datacenterLocation, committedUsage);
    }




}
