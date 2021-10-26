public enum Product {
    CADBURY(1,100), PEPSI(2,50), WATER(3,30), WAFFERS(4,150), EMPTY(0,0);

    private int selectionNumber;
    private int price;

    //constructor
    Product(int selectionNumber, int price){
        this.selectionNumber = selectionNumber;
        this.price = price;
    }

    public int getSelectionNumber(){
        return selectionNumber;
    }

    public int getPrice(){
        return this.price;
    }
    
    public static Product valueOf(int numberSelection){
        for(Product product: Product.values()){
            if(numberSelection == product.getSelectionNumber()){
                return product;
            }
        }
        return EMPTY;
    }

}