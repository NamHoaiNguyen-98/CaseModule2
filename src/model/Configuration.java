package model;

import java.io.Serializable;

public class Configuration implements Serializable {
    private int id;
    private String cpu;
    private String ram;
    private String hardDrive;
    private String cardVga;
    private String screen;

    public Configuration() {
    }

    public Configuration(int id,String cpu, String ram, String hardDrive, String cardVga, String screen) {
        this.id = id;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.cardVga = cardVga;
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getCardVga() {
        return cardVga;
    }

    public void setCardVga(String cardVga) {
        this.cardVga = cardVga;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-202s%-20s%-30s%-25s",cpu,ram,hardDrive,cardVga,screen);
    }
}
