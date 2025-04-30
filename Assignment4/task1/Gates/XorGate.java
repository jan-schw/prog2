package task1.Gates;

public class XorGate extends Gate{

    private OrGate or;
    private AndGate and;
    private NotGate not;

    public XorGate() {
        super("XOR");
        this.or = new OrGate();
        this.and = new AndGate();
        this.not = new NotGate();
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        //(a | b) & !(a & b)
        return this.and.evaluate(this.or.evaluate(a, b), this.not.evaluate(this.and.evaluate(a, b), b));
    }
    
}
