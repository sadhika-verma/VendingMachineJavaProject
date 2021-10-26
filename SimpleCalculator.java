public class SimpleCalculator implements Calculator{

    @Override
    public int calculateTotal(CoinBundle enteredCoins) {
        return enteredCoins.getTotal();
    }

    @Override
    public CoinBundle calculateChange(int amountMoneyToReturn) {
        CoinBundle change = new CoinBundle(new int[5]);
       
        int remainingAmount = amountMoneyToReturn;
        change.number100RupeeCoins = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;

        change.number50RupeeCoins = remainingAmount / 50;
        remainingAmount = remainingAmount % 50;

        change.number20RupeeCoins = remainingAmount / 20;
        remainingAmount = remainingAmount % 20;

        change.number10RupeeCoins = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        change.number5RupeeCoins = remainingAmount / 5;

        return change;
    }
}