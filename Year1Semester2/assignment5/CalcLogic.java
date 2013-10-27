class CalcLogic{
    //-- Instance variables.
    private int _currentTotal;   // The current total is all we need to remember.
    
    /** Constructor */
    public CalcLogic() {
        _currentTotal = 0;
    }
    
    public String getTotalString() {
        return "" + Integer.toHexString(_currentTotal);
    }
    
    public void setTotal(String n) {
        _currentTotal = convertToNumber(n);
    }
    
    public void add(String n) {
        _currentTotal += convertToNumber(n);
    }
    
    public void subtract(String n) {
        _currentTotal -= convertToNumber(n);
    }
    
    public void multiply(String n) {
        _currentTotal *= convertToNumber(n);
    }
    
    public void divide(String n) {
        _currentTotal /= convertToNumber(n);
    }

    public void and(String n) {
        _currentTotal &= convertToNumber(n);
    }
 
    public void or(String n) {
        _currentTotal |= convertToNumber(n);
    }
 
    public void xor(String n) {
        _currentTotal ^= convertToNumber(n);
    }
 
    public void nor(String n) {
        _currentTotal = ~(_currentTotal|convertToNumber(n));
    }

    public void nand(String n) {
        _currentTotal = ~(_currentTotal&convertToNumber(n));
    }
      
    private int convertToNumber(String n) {
        return Integer.parseInt(n,16);
    }
}


