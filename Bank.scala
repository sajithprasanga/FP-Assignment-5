object Bank  extends App{

	var cus1 = new Acc("ID001", 1000, 10000);
	var cus2 = new Acc("ID002", 1500, 15000);	
	var cus3 = new Acc("ID003", 1200, -10);
	var cus4 = new Acc("ID004", 1300, -100);
	

	cus4.transfer(cus2, 3000);							//a method transfer which transfer the money from this account to a given account
	println("transfer Succesfull \n Customer.2 to Customer.4 transfer 3000/=");
	
	var bank:List[Acc] = List(cus1, cus2, cus3, cus4);

	println("\n1. List of Accounts with negative balances: ");
	for (man <- bank) {
		man.neg();
	}

		
	var summ:Double  = 0;
	for (man <- bank) {
		summ = summ + man.sum().asInstanceOf[Double];
	}
	println("\n2 Calculate the sum of all account balances: "+summ);
	
	println("\nCalculate the final balances of all accounts after apply the interest: "); 
	for (man <- bank) {
		println(man.interest());
	}

}

class Acc(id:String, n:Int, b:Double){
	val nic:String = id;
	val accnumber:Int = n;
	var balance:Double = b; 

	def transfer(a:Acc, b:Int) = { this.balance = this.balance + b;
					       a.balance = a.balance -b; } 
	def neg()  = {if(this.balance < 0) println("["+ this.nic +" : "+ this.accnumber +" : "+ this.balance+ "]")};
	
	def sum() = {this.balance }

	def interest() = new Acc(this.nic,this.accnumber,if(this.balance>0) this.balance*0.05 + this.balance else this.balance*0.1 + this.balance);
	

	override def toString = "["+ nic +" : "+ accnumber +" : "+ balance+ "]"; 
}