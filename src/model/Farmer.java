package model;

public class Farmer {
    public Barn [] barnArray;

    public Farmer(){
        barnArray = new Barn[10];
    }

    public void addBarn (Barn barnToAdd) {
        System.out.println();
        for (int i = 0; i < barnArray.length; i++) {
            {
                if (barnArray[i] == null){
                this.barnArray[i] = barnToAdd;
                break;
                }
            }
        }
    }

    public void showMyBarns (){

        for (int i =0; i< barnArray.length;i++){
            if (barnArray[i]!=null){
            System.out.println(barnArray[i].toString());}
        }
    }
}



