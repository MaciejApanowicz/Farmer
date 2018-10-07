package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Farmer {
    public ArrayList<Barn> farm;

    public Farmer(){
        farm = new ArrayList<>();
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
            Files.write(file.toPath(),cleanOld.getBytes(),StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Barn b : farm){
            String barnToWrite = b.toString();
            try {
                Files.write(file.toPath(),(barnToWrite + '\r'+'\n').getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}



