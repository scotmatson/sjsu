public class Package
{
	private String address;
	
	/*
	 * Shipping priority determines when this package
	 * should be shipped in relation to the other
	 * packages. Packages with higher priority should be
	 * shipped first.
	 * 
	 * 0 = whenever, 1 = regular, 2 = high, 3 = very high
	 */
	private int shippingPriority;
	
	/*
	 * The next package in a linked list
	 */
	public Package next;
	
	public Package(String address, int prio)
	{
		this.address = address;
		this.shippingPriority = prio;
	}
	
	public String getAddress(){ return this.address; }
	public int getPriority(){ return this.shippingPriority; }
	
	@Override
	public String toString()
	{
		return "Package[address=" + this.getAddress() + ", shippingPriority=" + this.getPriority() + "]";
	}
}