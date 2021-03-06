package converter;

public enum Length {
	
	Mile(1609.44),
	Kilometer(1000.0),
	Meter(1.0),
	Centimeter(0.0100),
	Foot(0.30480),
	Wa(2.00000),
	AU(149597870700L);
	
	
	private final double value;
	
	private Length(double value) { this.value = value; }
	
	public double getValue() { return this.value; }
	
	

}
