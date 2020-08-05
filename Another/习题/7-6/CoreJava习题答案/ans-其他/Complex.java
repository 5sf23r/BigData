package chp5;

public class Complex {
	double real;
	double imaginary;
	public Complex(){
		this.real = 0;
		this.imaginary = 0;
	}
	
	public Complex(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public Complex add(double n){
		return new Complex(this.real + n, this.imaginary);
	}
	
	public Complex add(Complex c){
		return new Complex(this.real + c.real, this.imaginary+c.imaginary);
	}
	
	public Complex sub(double n){
		return new Complex(this.real - n, this.imaginary);
	}
	
	public Complex sub(Complex c){
		return new Complex(this.real - c.real, this.imaginary - c.imaginary);
	}
	
	public Complex mul(double n){
		return new Complex(this.real * n , this.imaginary * n);
	}
	
	public Complex mul(Complex c){
		double r = this.real * c.real - this.imaginary*c.imaginary;
		double i = this.real * c.imaginary + this.imaginary * c.real;
		return new Complex(r, i);
	}
}
