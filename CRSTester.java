import java.util.Arrays;
import java.util.Random;

public class CRSTester {
    public static void main(String args[]){
        Random rand = new Random();
        int n = rand.nextInt(1000);
        float p = rand.nextFloat();

        System.out.println("Printing matrix A");
        CRSTester tester = new CRSTester();
        CRSTester tester2 = new CRSTester();
        tester.setA(generateMatrix(p,n));
        System.out.println("");
        tester2.setA(generateMatrix(p,n));
        System.out.println("");

        System.out.println("Printing vector x");
        tester.setX(generateVector(n));
        System.out.println("");

        System.out.println("Printing the product of matrix a with vector x");
        float[] b = tester.uncompressedProduct(tester.getA(),tester.getX());
        float[] b2 = tester2.uncompressedProductZero(tester.getA(),tester.getX());
        tester.setB(b);
        tester2.setB(b2);
        System.out.println("");

        System.out.println("Printing the size of n versus the runtime of 'uncompressedProduct;");
        System.out.format("Size of n: %d  :  Run time of uncompressedProduct: %d%n", n,tester.getCounter());
        System.out.format("Size of n: %d  :  Run time of uncompressedProductZero: %d%n", n,tester2.getCounter());


    }

    private float[][] a;
    private float[] x;
    private float[] b;
    private long counter;

    float[][] getA(){
        return a;
    }

    void setA(float[][] _a){
        this.a = _a;
    }

    float[] getX() {
        return x;
    }

    void setX(float[] _x){
        this.x = _x;
    }

    float[] getB() {
        return b;
    }

    void setB(float[] _b){ this.b = _b; }

    void setCounter(long _counter){ this.counter = _counter; }

    long getCounter(){
        return counter;
    }


    //Create an array with random size nxn
    static float[][] generateMatrix(float p, int n){
        Random rand = new Random();
        float[][] a = new float[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //populate the array with 0s or a random float between 1 and 2
                if(Math.random() <= p){
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1 + (2-1)*rand.nextFloat();
                }
            }
            System.out.println(Arrays.toString(a[i]));
        }
        return a;
    }

    static float[] generateVector(int n){
        Random rand = new Random();
        float[] x = new float[n];

        for(int i = 0; i < n; i++){
            x[i] = rand.nextFloat();
        }
        System.out.println(Arrays.toString(x));
        return x;
    }

    float [] uncompressedProduct(float[][] a, float[] x){
        long startTime = System.nanoTime();
        float[]b = new float[x.length];
        float colVal;

        for(int i = 0; i < b.length; i++){
            colVal = 0;
            for(int j = 0; j < b.length; j++){
                colVal += x[j]*a[i][j];
            }
            b[i] = colVal;
        }
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        setCounter(elapsed);
        System.out.println(Arrays.toString(b));
        return b;
    }

    //Check for 0 value in a matrix
    float [] uncompressedProductZero(float[][] a, float[] x){
        long startTime = System.nanoTime();
        float[]b = new float[x.length];
        float colVal;

        for(int i = 0; i < b.length; i++){
            colVal = 0;
            for(int j = 0; j < b.length; j++){
                if (x[j] != 0 || a[i][j] != 0){
                    colVal += x[j] * a[i][j];
                }

            }
            b[i] = colVal;
        }
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        setCounter(elapsed);
        System.out.println(Arrays.toString(b));
        return b;
    }

}
