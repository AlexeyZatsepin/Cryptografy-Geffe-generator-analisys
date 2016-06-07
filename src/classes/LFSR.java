package classes;

public class LFSR {

    /**
     * Начальное состояние
     */
    private final long startState;

    /**
     * Текущее состояние
     */
    private long state;

    /**
     * Маска при помощи которой будет производится умножение
     */
    private final long multiplicativeMask;

    /**
     * Длина регистра
     */
    private final int length;

    public LFSR(long polynomial, long startState) {
        int n = Long.numberOfLeadingZeros(polynomial) + 1;
        if (n > 63) {
            throw new IllegalArgumentException("Illegal register length: " + (63 - n));
        }
        int identityMask = (0xffffffff >>> n);
        this.length = 63 - n;
        this.multiplicativeMask = polynomial & identityMask;
        this.startState = startState & identityMask;
        this.state = this.startState;
    }

    public long next() {
        //бит сьема
        long outputBit = state & 1;
        //обновляем состояние регистра
        int nextValue = Long.bitCount(state & multiplicativeMask) & 1;
        state = (state >>> 1) | (nextValue << (length - 1));
        return outputBit;
    }

    public void reset() {
        state = startState;
    }
}
