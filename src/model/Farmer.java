package model;

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
}



