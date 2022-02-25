package org.java17recipes.chapter04.recipe04_05;

public class ComparingValues {
    
    public static void main(String[] args){
        compareFloat();
    }
    
    /**
     * Example comparing float values
     */
    public static void compareFloat(){
        Float float1 = Float.valueOf("9.675");
        Float float2 = Float.valueOf("7.3826");
        Float float3 = Float.valueOf("23467.373");
        
        System.out.println("-- Using compareTo --");
        System.out.println(float1.compareTo(float3));
        System.out.println(float2.compareTo(float3));
        System.out.println(float1.compareTo(float1));
        System.out.println(float3.compareTo(float2));
       
        
        System.out.println("-- Using compare --");
        System.out.println(Float.compare(float1, float3));
        System.out.println(Float.compare(float2, float3));
        System.out.println(Float.compare(float1, float1));
        System.out.println(Float.compare(float3, float2));
        
    }    
}

