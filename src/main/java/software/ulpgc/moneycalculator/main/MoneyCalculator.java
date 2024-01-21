package software.ulpgc.moneycalculator.main;

import software.ulpgc.moneycalculator.api.fixerws.FixerCurrencyLoader;
import software.ulpgc.moneycalculator.api.fixerws.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.controller.Command;
import software.ulpgc.moneycalculator.controller.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.view.swing.SwingMain;

import java.util.List;

public class MoneyCalculator {

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.getMoneyDialog().define(currencies),
                main.getCurrencyDialog().define(currencies),
                new FixerExchangeRateLoader(),
                main.getMoneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }
}
