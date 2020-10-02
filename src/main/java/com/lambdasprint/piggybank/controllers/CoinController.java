
package com.lambdasprint.piggybank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lambdasprint.piggybank.models.Coin;
import com.lambdasprint.piggybank.repositories.CoinRepository;

@RestController
public class CoinController {
    @SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping(value = "/total", produces = {"application/json"})
    private ResponseEntity<?> displayTotals() {
        Iterable<Coin> coins = coinRepository.findAll();

        double totalValue = 0.00;
        for (Coin coin : coins) {
            totalValue += coin.getValue() * coin.getQuantity();
            if (coin.getQuantity() == 1)
                System.out.println(coin.getQuantity() + " " + coin.getName());
            else
                System.out.println(coin.getQuantity() + " " + coin.getNameplural());
        }

        System.out.println("The piggy bank holds " + totalValue);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
