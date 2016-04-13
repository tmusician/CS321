public static Report{
  
  private static int income;
  private static int SR_Occupancy;
  private static int DR_Occupancy;
  
  public static void main(String[] args){
    this.income = 0;
    this.SR_Occupancy = 0;
    this.DR_Occupancy = 0;
  }
  
  public static void inc_SR_Occupancy(){ this.SR_Occupancy++; }
  public static void dec_SR_Occupancy(){ this.SR_Occupancy--; }
  
  public static void inc_DR_Occupancy(){ this.DR_Occupancy--; }
  public static void dec_DR_Occupancy(){ this.DR_Occupancy--; }
  
  public static void incIncome(int inc){ this.income += inc; }
  
  public static void day_change(){
    this.income = 0;
  }
  
  
  
  
}
