import java.util.ArrayList;


         class NumberOperations {

             static ArrayList<Integer> EvenNumbers = new ArrayList<>();
            static  ArrayList<Integer> PrimeNumbers = new ArrayList<>();


             synchronized ArrayList<Integer> PrimeController(ArrayList<Integer> arr,int FirstNum,int FinalNum) {

                 for (int i=FirstNum; FirstNum<FinalNum ; FirstNum++) {
                     if (arr.get(FirstNum) % 2 != 0) {
                         PrimeNumbers.add(arr.get(FirstNum));
                     }
                 }

                 return PrimeNumbers;
             }

             synchronized ArrayList<Integer> EvenController(ArrayList<Integer> arr,int FirstNum,int FinalNum) {

                 for (int i=FirstNum; FirstNum<FinalNum;FirstNum++) {
                     if (arr.get(FirstNum) % 2 == 0) {
                         EvenNumbers.add(arr.get(FirstNum));
                     }
                 }
                 return EvenNumbers;
             }

         }

          class EvenThread extends Thread {

            NumberOperations NumberOperations = new NumberOperations();
            ArrayList<Integer> arr = new ArrayList<>();
              int FirstNum;
              int FinalNum;

            public EvenThread(ArrayList<Integer> arr,int FirstNum,int FinalNum) {
                super();
                this.arr = arr;
                this.FirstNum=FirstNum;
                this.FinalNum=FinalNum;
            }


            @Override
            public void run() {

                NumberOperations.EvenController(this.arr, this.FirstNum,this.FinalNum);

            }
        }

            class PrimeThread extends Thread {

                NumberOperations NumberOperations = new NumberOperations();
                ArrayList<Integer> arr = new ArrayList<>();
                int FirstNum;
                int FinalNum;

                 public PrimeThread(ArrayList<Integer> arr,int FirstNum,int FinalNum) {
                     super();
                  this.arr = arr;
                  this.FirstNum=FirstNum;
                  this.FinalNum=FinalNum;
                 }


                @Override
                 public void run() {

                     NumberOperations.PrimeController(this.arr,this.FirstNum, this.FinalNum);


                        }
                    }

public class trial {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }

        PrimeThread thread1=new PrimeThread(numbers,0,2500);
        EvenThread thread2=new EvenThread(numbers,0,2500);
        PrimeThread thread3=new PrimeThread(numbers,2500,5000);
        EvenThread thread4=new  EvenThread(numbers,2500,5000);
        PrimeThread thread5=new PrimeThread(numbers,5000,7500);
        EvenThread thread6=new  EvenThread(numbers,5000,7500);
        PrimeThread thread7=new PrimeThread(numbers,7500,10000);
        EvenThread thread8=new  EvenThread(numbers,7500,10000);





        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();


        } catch (InterruptedException e) {

            System.out.println("Main thread is interrupted");
        }


        System.out.println(" Tek sayılar listesi : ");

        for(Integer i : NumberOperations.PrimeNumbers){

            System.out.print(i + " , ");
    }

        System.out.println();
        System.out.println("######################################################################################################################################################");
        System.out.println("######################################################################################################################################################");

        System.out.println(" Çift sayılar listesi : ");

        for(Integer i : NumberOperations.EvenNumbers){

            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.println("Main thread is finishing");

    }
}
