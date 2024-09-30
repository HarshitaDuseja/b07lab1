
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ThreadInfo;

public class Polynomial{

    double [] A;
    int [] E;

    public Polynomial(){
        this.A = new double[]{0};
        this.E = new int[]{0};
    }

    public Polynomial(double [] B, int [] D){
        this.A = B;
        this.E = D;
    }

    public Polynomial add(Polynomial plus){
        Polynomial tot = new Polynomial();
        int l1 = this.A.length;
        int l2 = plus.A.length;
        if(l2 > l1){
            tot.A = new double[l2];
            tot.E = new int[l2];
        }
        else{
            tot.A = new double[l1];
            tot.E = new int[l1];
        }
        if(l2 > l1){
            for(int x = 0; x < l1; x++){
                tot.A[x] = this.A[x] + plus.A[x];
                tot.E[x] = this.E[x];
            }
            if(l2 != l1){
                for(int y = l1; y < l2; y++){
                    tot.A[y] = plus.A[y];
                }
            }
        }
        if(l1 > l2){
            for(int x = 0; x < l2; x++){
                tot.A[x] = plus.A[x] + this.A[x];
                tot.E[x] = this.E[x];
            }
            if(l2 != l1){
                for(int y = l2; y < l1; y++){
                    tot.A[y] = this.A[y];
                    tot.E[y] = this.E[y];
                }
            }
        }
        return tot;
    }

    public double evaluate(double plug){
        double sum = 0;
        int l = this.A.length;
        for(int x = 0; x < l; x++){
            sum = sum + (this.A[x]*(Math.pow(plug,this.E[x])));
        }

        return sum;
    }
    
    public boolean hasRoot(double r){
        double sum = 0;
        int l = this.A.length;
        for(int x = 0; x < l; x++){
            sum = sum + this.A[x]*(Math.pow(r, x));
        }

        if(sum == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Polynomial multiply(Polynomial product){
        int len = this.A.length * product.A.length; 
        double[] endresultA = new double [len];
        int[] endresultE = new int [len];
        int c = 0;
        for(int i=0; i<this.A.length; i++){
            for(int j=0; j<product.A.length; j++){
                endresultA[c] = this.A[i] * product.A[j];
                endresultE[c] = this.E[i] + product.E[j];
                c++;
            }

        }
        return new Polynomial(endresultA, endresultE);
    }

    public void saveToFile(String filename) throws IOException {
        PrintStream output = new PrintStream(filename);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            if (i != 0 && A[i] > 0) {
                sb.append("+");
            }
            sb.append(A[i]);
            if (E[i] != 0) {
                sb.append("x^").append(E[i]);
            }
        }

        output.print(sb.toString());
        output.close();
    }
}
    }



}