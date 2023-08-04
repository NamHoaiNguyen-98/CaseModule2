package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import manager.inteface.IConfiguration;
import model.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class ConfigurationManager implements IConfiguration, Serializable {
    private final Scanner scanner;
    private final List<Configuration> configurationList;
    private final String path = "D:\\CaseModule2\\src\\file\\Configurations";
    private final String regex = "^.+$";
    private static ConfigurationManager configurationManager;

    private ConfigurationManager(Scanner scanner) {
        this.scanner = scanner;
        configurationList = ReadAndWriteFile.readFromFile(path);
    }

    public static ConfigurationManager getInstance(Scanner scanner) {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager(scanner);
        }
        return configurationManager;
    }

    public Configuration getConfiguration() {
        int id = getIdUp();
        System.out.println("Input Cpu: ");
        String cpu = Input.inputString(regex);
        System.out.println("Input Ram: ");
        String ram = Input.inputString(regex);
        System.out.println("Input hardDrive: ");
        String hardDrive = Input.inputString(regex);
        System.out.println("Input cardVga: ");
        String cardVga = Input.inputString(regex);
        System.out.println("Input Screen: ");
        String screen = Input.inputString(regex);
        return new Configuration(id, cpu, ram, hardDrive, cardVga, screen);
    }

    @Override
    public void create() {
        Configuration configuration = getConfiguration();
        if (configuration.getCpu() != null || configuration.getRam() != null
                || configuration.getHardDrive() != null
                || configuration.getCardVga() != null || configuration.getScreen() != null) {
            configurationList.add(configuration);
            System.out.println("Add success !");

        } else {
            System.out.println("Add failed");
        }
        ReadAndWriteFile.writeToFile(configurationList, path);

    }


    public void update(int id) {
        Configuration configuration = findById(id);
        if (configuration != null) {
            System.out.println("Input New Cpu: ");
            String cpu = scanner.nextLine();
            if (!cpu.isEmpty()) {
                configuration.setCpu(cpu);
            }
            System.out.println("Input New Ram: ");
            String ram = scanner.nextLine();
            if (!ram.isEmpty()) {
                configuration.setCpu(ram);
            }
            System.out.println("Input New hardDrive: ");
            String hardDrive = scanner.nextLine();
            if (!hardDrive.isEmpty()) {
                configuration.setCpu(hardDrive);
            }
            System.out.println("Input New cardVga: ");
            String cardVga = scanner.nextLine();
            if (!cardVga.isEmpty()) {
                configuration.setCpu(cardVga);
            }
            System.out.println("Input New Screen: ");
            String screen = scanner.nextLine();
            if (!screen.isEmpty()) {
                configuration.setCpu(screen);
            }
            System.out.println("Update success!");
        }
        ReadAndWriteFile.writeToFile(configurationList, path);

    }

    @Override
    public void display() {
        if (!configurationList.isEmpty()) {
            for (Configuration configuration : configurationList) {
                System.out.println(configuration);
            }
        } else {
            System.out.println("Configuration does not exits");
        }

    }


    public Configuration findById(int id) {
        for (Configuration configuration : configurationList) {
            if (configuration.getId() == id) {
                return configuration;
            }
        }
        return null;
    }

    private int getIdUp() {
        int maxId = 0;
        for (Configuration configuration : configurationList) {
            if (configuration.getId() > maxId) {
                maxId = configuration.getId();
            }
        }
        return maxId + 1;

    }
    @Override
    public void update() {

    }

    @Override
    public Configuration findById() {
        return null;
    }
}
