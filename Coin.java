public enum Coin {
    FIVE_RUPEES(5), TEN_RUPEES(10),  TWENTY_RUPEES(20), FIFTY_RUPEES(50), HUNDRED_RUPEES(100);

    private int value;

    //constructor
    Coin(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
    
    public static int[] parseCoins(String coins){
        String[] numberCoinsInText = coins.split(",");
        
        int[] result = new int[numberCoinsInText.length];
        
        for(int i=0; i<numberCoinsInText.length; i++){
        	
            result[i] = Integer.parseInt(numberCoinsInText[i]);
        }
        return result;
    }
}