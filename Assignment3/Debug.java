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
      case ADD:             //Operator.ADD zu ADD geändert. Hier wird nicht der Typ benötigt, sondern nur der Wert des enums
        return this.left_ + this.right_;
      case SUBTRACT:        //Operator.SUBTRACT zu SUBTRACT geändert. Grund: s.o.
        return this.left_ - this.right_;
      case MULTIPLY:        //Operator.MULTIPLY zu MULTIPLY geändert. Grund: s.o.
        return this.left_ * this.right_;
      case DIVIDE:          //Operator.DIVIDE zu DIVIDE geändert. Grund: s.o.
        return this.left_ / this.right_;
      default:
        return 0.0;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4];   //Array-Größe auf 4 reduziert, das reicht für die Operatoren und führt nicht zu NullPointern
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i, i + 1, ops[i]);  //i und i+1 getauscht, damit es nicht zu einer Division durch 0 kommt
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}