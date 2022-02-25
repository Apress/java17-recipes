package org.java17recipes.chapter07.recipe07_03;


public class SwitchTypeChecker {
    
    public static Class varTypeClass(Object o) { return o.getClass(); };
    public static Class varTypeClass(Enum e) { return e.getClass().getSuperclass(); };
    public static Class varTypeClass(char c) { return char.class; };
    public static Class varTypeClass(byte b) { return byte.class; };
    public static Class varTypeClass(short s) { return short.class; };
    public static Class varTypeClass(int i) { return int.class; };
    public static Class varTypeClass(long l) { return long.class; };
    public static Class varTypeClass(float f) { return float.class; };
    public static Class varTypeClass(double d) { return double.class; };
    public static Class varTypeClass(boolean d) { return boolean.class; };
    
    public void isValidSwitchType(Class typeClass) {
        String switchType = typeClass.getSimpleName();
        boolean valid = true;
        switch (switchType) {
            case "char":
            case "byte":
            case "short":
            case "int":
                System.out.print("Primitive type " + switchType);
                break;
            case "Character":
            case "Byte":
            case "Short":
            case "Integer":
                System.out.print("Boxed primitive type " + switchType);
                break;
            case "String":
            case "Enum":
                System.out.print(switchType);
                break;
            default:  // invalid switch type
                System.out.print(switchType);
                valid = false;
        }
        System.out.println(" is " + (valid ? "" : "not ") + "a valid switch type.");
    }

    public static void main(String[] args) {
        SwitchTypeChecker check = new SwitchTypeChecker();
        check.isValidSwitchType(varTypeClass('7'));
        check.isValidSwitchType(varTypeClass(7));
        check.isValidSwitchType(varTypeClass(777.7d));
        check.isValidSwitchType(varTypeClass((short)7));
        check.isValidSwitchType(varTypeClass(new Integer(7)));
        check.isValidSwitchType(varTypeClass("Java 8 Rocks!"));
        check.isValidSwitchType(varTypeClass(new Long(7)));
        check.isValidSwitchType(varTypeClass(true));             
        check.isValidSwitchType(varTypeClass(java.nio.file.AccessMode.READ));
    }  
}

