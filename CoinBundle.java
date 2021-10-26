public class CoinBundle {
    public int number5RupeeCoins;
    public int number10RupeeCoins;
    public int number20RupeeCoins;
    public int number50RupeeCoins;
    public int number100RupeeCoins;

    //constructor of class with array
    public CoinBundle(int... enteredCoins) {
        this.number5RupeeCoins = enteredCoins[0];
        this.number10RupeeCoins = enteredCoins[1];
        this.number20RupeeCoins = enteredCoins[2];
        this.number50RupeeCoins = enteredCoins[3];
        this.number100RupeeCoins = enteredCoins[4];

    }
    
    public int getTotal(){
    	int total = 0;
    	total = total+this.number5RupeeCoins*Coin.FIVE_RUPEES.getValue();
    	total = total+this.number10RupeeCoins*Coin.TEN_RUPEES.getValue();
    	total = total+this.number20RupeeCoins*Coin.TWENTY_RUPEES.getValue();
    	total = total+this.number50RupeeCoins*Coin.FIFTY_RUPEES.getValue();
        total = total+this.number100RupeeCoins*Coin.HUNDRED_RUPEES.getValue();
    	return total;
    }
        
}