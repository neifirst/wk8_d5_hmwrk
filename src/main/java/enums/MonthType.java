package enums;

public enum MonthType {

    JAN(12),
    FEB(1),
    MAR(2),
    APR(3),
    MAY(4),
    JUN(5),
    JUL(6),
    AUG(7),
    SEP(8),
    OCT(9),
    NOV(10),
    DEC(11);

    private int tag;

    MonthType(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
