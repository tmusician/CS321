public static Report{
  
  private static int income;
  private static int Occupancy;
  
  public static void main(String[] args){
    this.income = 0;
    this.Occupancy = 0;
  }
  
  public static void incOccupancy(){ this.Occupancy++; }
  
  public static void incIncome(int inc){ this.income += inc; }
  
  public static void day_change(){
    this.income = 0;
  }
  
  
  
  
}
