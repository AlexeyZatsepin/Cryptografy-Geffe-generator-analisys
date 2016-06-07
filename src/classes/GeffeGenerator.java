package classes;

public class GeffeGenerator {
	private LFSR  l1;
    private LFSR  l2;
    private LFSR  l3;
    
    GeffeGenerator(LFSR  l1, LFSR  l2, LFSR  l3){
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }
    
    public long next(){
        long x = l1.next();
        long y = l2.next();
        long s = l3.next();
        return (s & x) ^ ((s ^ 1) & y);
    }

    public LFSR getL1() {
        return l1;
    }

    public LFSR getL2() {
        return l2;
    }

    public LFSR getL3() {
        return l3;
    }

}
