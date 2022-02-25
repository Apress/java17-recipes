package org.java17recipes.chapter02.recipe02_11;

public interface Pool {

    /**
     * Calculate volume (gal) for a fixed depth square or rectangular pool.
     */
    public default double squareOrRectConstantDepth(double length, double width, double depth){
        return volumeCalc(length, width, depth);
    }
    
    /**
     * Calculate volume (gal) for a variable depth square or rectangular pool.
     */
    public default double squareOrRectVariableDepth(double length, double width,
                                                    double shallowDepth, double middleDepth, double deepDepth){
        double avgDepth = (shallowDepth + middleDepth + deepDepth) / 3; 
        return volumeCalc(length, width, avgDepth);
    }
    
    /**
     * Standard square or rectangular volume calculation. 
     */
    private double volumeCalc(double length, double width, double depth){
        return length * width * depth * 7.5;
    }
}

