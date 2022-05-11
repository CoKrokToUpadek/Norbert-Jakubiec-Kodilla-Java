package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;



public class ShapeCollector {

    List<Shape> shapes;

    public ShapeCollector() {
        shapes=new ArrayList<>();

    }

    public boolean addFigure(Shape shape){
        if (shapes.add(shape)){
            return true;
        }
        return false;
    }

    public boolean removeFigure(Shape shape){
        if (shapes.remove(shape)){
            return true;
        }
         return false;
    }

    public Shape getFigure(int n){
        if (n>=shapes.size() || n<0){
            return null;
        } else {
            return shapes.get(n);
        }
    }

    public String showFigures(){
        String output="";

        if (shapes.size()==0){
            return output;
        }else {
            for (Shape shape :shapes){
                output+=shape.getShapeName()+", ";
            }
        }
        output=output.substring(0,output.length()-2);
        return output;
    }

    public int getSize(){
        return shapes.size();
    }

}
