import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {


        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached!");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }

        }

        btnPrint.setOnClickListener(new ClickListener());
        listen();




        System.out.println("********************\n*********************\n****************");


        Gearbox Subaru = new Gearbox(6);
        Subaru.operateClutch(true);
        Subaru.changeGear(1);
        Subaru.operateClutch(false);
        System.out.println(Subaru.wheelSpeed(2000));
        Subaru.changeGear(2);
        System.out.println(Subaru.wheelSpeed(2100));
        Subaru.operateClutch(true);
        Subaru.changeGear(3);
        Subaru.operateClutch(false);
        System.out.println(Subaru.wheelSpeed(2900));


        System.out.println("********************\n*********************\n****************");

        Player player1 = new Player("Pawel", 100, 9000);
        System.out.println(player1.toString());
        saveObj(player1);

        player1.setHitPts(80);
        System.out.println(player1);
        player1.setWeapon("Doomsbringer");
        saveObj(player1);
//        loadObj(player1);
        System.out.println(player1);

        ISave werewolf = new Moster("Werewolf", 400, 30);
        System.out.println(werewolf);
        saveObj(werewolf);
        System.out.println("Calling get directly: " + ((Moster) werewolf).getHitPts());

    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n\t1 to enter a new string\n\t0 to quit");
        while(!quit){
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String strInput = scanner.nextLine();
                    values.add(index,strInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObj(ISave objToSave){
        for(int i=0;i<objToSave.write().size();i++){
            System.out.println("Saving " + objToSave.write().get(i) + " to storage");
        }
    }

    public static void loadObj(ISave objToLoad){
        ArrayList<String> values = readValues();
    }

    private static void listen() {
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
            }
        }

    }


}
