package com.klm.cases.df.fare;

import lombok.Value;

@Value
public class Fare {
    double amount;
    Currency currency;
    String origin;
    String destination;


}
