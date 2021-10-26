import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //In real scenario, object is provided by methods of TextBasedVendingMachine
        VendingMachineInterface machineInterface = new TextBasedVendingMachine();

        machineInterface.displayProducts();

        String selectedProduct = s.nextLine();
        try{
        	machineInterface.selectProduct(Integer.parseInt(selectedProduct));
            
	    	}
	    catch(NumberFormatException e){
	    	System.out.println(e);
	    	System.exit(0);
	    	}
        int p = Integer.parseInt(selectedProduct);
        
        //checking if choice entered is valid of not
        if(p > 4 || p <= 0)
        {
        	System.out.println("\n\tEnter Valid Choice. ERROR.");
        	System.exit(0);
        }
        
        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = s.nextLine();
        
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
        
        machineInterface.enterCoins(enteredCoins);

        machineInterface.displayChangeMessage();

    }
}