package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PineappleAdditionDecorator extends AbstractPizzaOrderDecorator{

    public PineappleAdditionDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(10));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+"/d Additional Pineapple (God have mercy)";
    }
}
