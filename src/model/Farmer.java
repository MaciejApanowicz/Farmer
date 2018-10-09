package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Farmer {
    public ArrayList<Barn> farm;

    public Farmer(){
        farm = new ArrayList<>();
    }

    public void setFarm(ArrayList<Barn> farm) {
        this.farm = farm;
    }

    public void addBarn (Barn barnToAdd) {
       farm.add(barnToAdd);
    }

    public void removeBarn(int barnID){
        farm.remove(barnID);
    }

    public int countFarmerBarns(){
       return farm.size();
    }

    public void showMyBarns (){
        for (Barn b : farm){
            System.out.println(b.toString());
            }
    }

    public void saveFarm (){
        ArrayList <Barn> farm = this.farm;

        File file = new File("Farm.txt");
        String cleanOld = "";

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(file.toPath(),cleanOld.getBytes(),StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Barn b : farm){
            String barnToWrite = b.barnFormatToWrite();
            try {
                Files.write(file.toPath(),(barnToWrite + '\r'+'\n').getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<Barn> loadFarm (){
        File file = new File("Farm.txt");
        ArrayList<Barn> farma = new ArrayList<>();
        try {
            Scanner in = new Scanner(
                    new FileInputStream("C:\\Users\\Maciej\\Desktop\\JavaKariera\\Farmer2\\Farm.txt"),"UTF-8");
            for (int i = 0 ;  i < 3; i++){
                farma.add(Barn.readData(in));
            }

            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return farma;
    }

    public  static Barn[] readFarm(Scanner in){
        int n = in.nextInt();
        Barn [] barns = new Barn[n];
        for (int i = 0; i < n; i ++){
            barns [i] = readBarn(in) ;
        }return barns;
    }

    public static Barn readBarn (Scanner in){
        String line = in.nextLine();
        String [] tokens = line.split("\\|");
        int id = Integer.parseInt(tokens[0]);
        String name = tokens [1];
        return new Barn(name);
    }
}



