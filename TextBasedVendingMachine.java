public class TextBasedVendingMachine extends Thread implements VendingMachineInterface {

    private int selectedProduct;
    private CoinBundle change;


    @Override
    public void displayProducts() {
        System.out.println(" *********************************************");
        System.out.println("           OOP PROJECT MADE BY:           ");
        System.out.println("             Sadhika Verma\n");
        System.out.println(" *********************************************");
        System.out.println("           WELCOME TO THE VENDING MACHINE           ");
        System.out.println(" *********************************************");
        System.out.println("            Products available:               ");
        System.out.println("                                              ");
        for(Product product: Product.values()){
        	//product is a enum type of Product 
        	// loop runs until products are not null
            if(!Product.EMPTY.equals(product)) {
                System.out.println("     " + product.getSelectionNumber() + "  " + product.name() + " - Price: " + product.getPrice() + "   ");
            }
        }
        System.out.println("                                              ");
        System.out.println(" Please select your product: ");
    }

    @Override
    public void selectProduct(int product) {	
    		this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
        System.out.println(" Please enter coins as follows: ");
        System.out.println(" Number of:\n- 5 rupee coins\n- 10 rupee coins\n- 20 rupee coins\n- 50 rupee coins\n- 100 rupee coins  ");
        System.out.println("                                              ");
        System.out.println(" Example: If you would like to enter 2 ten rupee coins: 0,2,0,0,0");
        System.out.println("Please enter coins:");

    }

    @Override
    public void enterCoins(int... coins) {
    	Calculator calculator = new SimpleCalculator();
    	
    	//getting the item number and price from product class which is of enum type
    	Product product = Product.valueOf(this.selectedProduct);
    	
    	//to calculate total money the user has given
    	int total = calculator.calculateTotal(new CoinBundle(coins));
    	
    	//subtracting the amount of product from total money given
    	int changeAmount = total - product.getPrice();
    	this.change = calculator.calculateChange(changeAmount);
    }

    @Override
    public void displayChangeMessage() {
    	int r100, r50, r20, r10, r5;
    	System.out.print("\n\tGenerating Change Please Wait");
    	
    	for(int i=1;i<5;i++){
    		  // the thread will sleep for the 1000 milli seconds
    		    try{
    		    	Thread.sleep(1100);
    		    	}
    		    catch(InterruptedException e){
    		    	System.out.println(e);
    		    	}
    		    System.out.print(".");
    		  }
    	
    	
    	r100 = this.change.number100RupeeCoins;
    	r50 = this.change.number50RupeeCoins;
    	r20 = this.change.number20RupeeCoins;
    	r10 = this.change.number10RupeeCoins;
    	r5 = this.change.number5RupeeCoins;
    	if(r100 == -1 || r50 == -1 || r20 == -1 || r10 == -1 || r5 == -1)
    	{
    		System.out.println("\n                                              ");
    		System.out.println("\tInsufficient Funds. All Money Returned.\n\n\tTRY TRANSACTION WITH ADEQUATE FUNDS.");
    	}
    	else
    	{
    		System.out.println("\n                                              ");
    		System.out.println("\n**********  PLEASE COLLECT YOUR ITEM AND CHANGE   ********\n");
            System.out.println("Your change is :"+ change.getTotal()+" rupees splitted as follows: ");
            System.out.println("    100 rupee coins: "+ change.number100RupeeCoins);
            System.out.println("    50 rupee coins: "+ change.number50RupeeCoins);
            System.out.println("    20 rupee coins: "+ change.number20RupeeCoins);
            System.out.println("    10 rupee coins: "+ change.number10RupeeCoins);
            System.out.println("    5 rupee coins: "+ change.number5RupeeCoins);
    	}       
        System.out.println("********************  End Of Code ********************");
    }
}