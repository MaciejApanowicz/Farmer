package model;



public class Farmer {

    public Barn [] barnArray;



    public Farmer(){

        barnArray = new Barn[10];

    }



    public void addBarn (Barn barnToAdd) {

        for (int i = 0; i < barnArray.length; i++) {

            {

                if (barnArray[i] == null){

                    this.barnArray[i] = barnToAdd;

                    break;

                }

            }

        }

    }

    public int countFarmerBarns(){

        int numberOfBarns = 0;

        for (int i = 0; i< barnArray.length; i++){

            if (barnArray[i]!=null)

                numberOfBarns += 1;

        }

        return numberOfBarns;

    }



    public void showMyBarns (){

        for (int i =0; i< barnArray.length;i++){

            if (barnArray[i]!=null){

                System.out.println(barnArray[i].toString());

                if (i!= countFarmerBarns()-1)

                    System.out.println();

            }

        }

    }

}