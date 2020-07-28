object neg  extends App{
	val a = new Rational(3,4);
	val b = new Rational(5,8);
	val c = new Rational(2,7);

	println("Value is: "+a.neg);

	val answer = (a.add(b.neg)).add(c.neg);
	println("Substraction using negative value = " + answer);
}

class Rational(n:Int, d:Int){
	def numer = n;
	def denom = d;
	
	def neg = new Rational(-this.numer, this.denom);
	
	def add(r:Rational) = new Rational(this.numer*r.denom+ this.denom*r.numer, this.denom*r.denom);

	def sub(r:Rational) = this add r.neg;	

	override def toString =  numer + "/" + denom;
}