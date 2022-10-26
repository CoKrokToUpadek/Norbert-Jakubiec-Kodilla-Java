package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamAdditionDecorator extends AbstractPizzaOrderDecorator{

    public HamAdditionDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(7));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+"/d Additional Ham";
    }
}
