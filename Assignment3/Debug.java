enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

//Should not be instanciated with right_==0 and op_==DIVIDE
class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op){
    this.left_  = left;
    this.right_ = right;
    this.op_    = op;
  }

  double evaluate() {
    switch (this.op_) {
      case Operator.ADD:
        return this.left_ + this.right_;
      case Operator.SUBTRACT:
        return this.left_ - this.right_;
      case Operator.MULTIPLY:
        return this.left_ * this.right_;
      case Operator.DIVIDE:
        return this.left_ / this.right_;
      default:
        return 0.0;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[5];
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i + 1, i, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}