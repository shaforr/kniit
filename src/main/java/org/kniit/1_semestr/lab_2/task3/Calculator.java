

public class Calculator {
    private double a, b;
    private String result;
    private String s; 

    public void setFirst(double a)
    {
            this.a = a;
    }
    public void setSecond(double b)
    {
            this.b = b;
    }
    public void setOperator(String s)
    {
            this.s = s;
    }

    public void add()
    {
        this.result = String.valueOf(this.a + this.b);
    }
    public void subtract()
    {
        this.result = String.valueOf(this.a - this.b);
    }
    public void multiply() 
    {
        this.result = String.valueOf(this.a * this.b);
    }
    public void divide()
    {
        if (this.b == 0){
            this.result = "На ноль делить нельзя!";
        }
        else
        {
            this.result = String.valueOf(this.a / this.b);
        }
    }

    public String Calculate(){
    switch (this.s) {
                case "+":
                    add();
                    break;
                case "-":
                    subtract();
                    break;
                case "*":
                    multiply();
                    break;
                case "/":
                    divide();
                    break;
            }
            return this.result;
        }
    
}
