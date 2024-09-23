public class Polynomial{

    double [] A;

    public Polynomial(){
        this.A = new double[]{0};
    }

    public Polynomial(double [] B){
        this.A = B;
    }

    public Polynomial add(Polynomial plus){
        Polynomial tot = new Polynomial();
        int l1 = this.A.length;
        int l2 = plus.A.length;
        if(l2 > l1){
            tot.A = new double[l2];
        }
        else{
            tot.A = new double[l1];
        }
        if(l2 > l1){
            for(int x = 0; x < l1; x++){
                tot.A[x] = this.A[x] + plus.A[x];
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
            }
            if(l2 != l1){
                for(int y = l2; y < l1; y++){
                    tot.A[y] = this.A[y];
                }
            }
        }
        return tot;
    }

    public double evaluate(double plug){
        double sum = 0;
        int l = this.A.length;
        for(int x = 0; x < l; x++){
            sum = sum + (this.A[x]*(Math.pow(plug,x)));
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



}