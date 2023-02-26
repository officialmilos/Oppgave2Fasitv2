package com.example.oppgave2fasitv2;

/*import com.example.oppgave2fasitv2.Models.Currency;
import com.example.oppgave2fasitv2.Models.CurrencyValue;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController()
public class CurrencyController {

    private ArrayList<Currency> currencyRegister = new ArrayList<>(){
        {
            add(new Currency("USD", 8.5));
            add(new Currency("EUR", 10.0));
            add(new Currency("GBP", 11.0));
            add(new Currency("SEK", 1.0));
        }
    };

    @PostMapping("/getCurrencies")
    public ArrayList<Currency> getCurrencies(){
        return currencyRegister;
    }

    @PostMapping("/calculateValue")
    public double calculateValue(CurrencyValue currencyValue){
        for(Currency currency : currencyRegister){
            if(currency.getCurrency().equals(currencyValue.getCurrency())){
                return currency.getRate() * currencyValue.getAmount();
            }
        }
        return 0;
    }

}