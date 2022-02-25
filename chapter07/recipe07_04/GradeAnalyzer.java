package org.java17recipes.chapter07.recipe07_04;


import java.util.Arrays;
 
public class GradeAnalyzer {

    // The internal grades array
    private int[] _grades;

    public void setGrades(int[] grades) {
        this._grades = grades;
    }

    // Return cloned grades so the caller cannot modify our internal grades
    public int[] getGrades() {
        return _grades != null ? _grades.clone() : null;
    }

    public int meanGrade() {
        int mean = 0;
        if (_grades != null && _grades.length > 0) {
            int sum = 0;
            for (int i = 0; i < _grades.length; i++) {
                sum += _grades[i];
            }
            mean = sum / _grades.length;
        }
        return mean;
    }

    public int minGrade() {
        int min = 0;
        for (int index = 0; index < _grades.length; index++) {
            if (_grades[index] < min) {
                min = _grades[index];
            }
        }
        return min;
    }

    public int maxGrade() {
        int max = 0;
        for (int index = 0; index < _grades.length; index++) {
            if (_grades[index] > max) {
                max = _grades[index];
            }
        }
        return max;
    }

    static int[] initGrades1() {
        int[] grades = new int[5];
        grades[0] = 77;
        grades[1] = 48;
        grades[2] = 69;
        grades[3] = 92;
        grades[4] = 87;
        return grades;
    }

    static int[] initGrades2() {
        int[] grades = {57, 88, 67, 95, 99, 74, 81};
        return grades;
    }

    static int[] initGrades3() {
        return new int[]{100, 70, 55, 89, 97, 98, 82};
    }

    public static void main(String... args) {

        GradeAnalyzer ga = new GradeAnalyzer();
        ga.setGrades(initGrades1());
        System.out.println("Grades 1:");
        System.out.println("Mean of all grades is " + ga.meanGrade());
        System.out.println("Min grade is " + ga.minGrade());
        System.out.println("Max grade is " + ga.maxGrade());
        ga.setGrades(initGrades2());
        System.out.println("Grades 2:");
        System.out.println("Mean of all grades is " + ga.meanGrade());
        System.out.println("Min grade is " + ga.minGrade());
        System.out.println("Max grade is " + ga.maxGrade());
        ga.setGrades(initGrades3());
        System.out.println("Grades 3:");
        System.out.println("Mean of all grades is " + ga.meanGrade());
        System.out.println("Min grade is " + ga.minGrade());
        System.out.println("Max grade is " + ga.maxGrade());

        Object testArray = ga.getGrades();
        Class testClass = testArray.getClass();
        System.out.println("isArray: " + testClass.isArray());
        System.out.println("getClass: " + testClass.getName());
        System.out.println("getSuperclass: " + testClass.getSuperclass());
        System.out.println("getComponentType: " + testClass.getComponentType());
        System.out.println("Arrays.toString: " + Arrays.toString((int[]) testArray));

    }
}
