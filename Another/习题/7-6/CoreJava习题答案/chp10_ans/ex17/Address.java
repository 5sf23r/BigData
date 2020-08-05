package chp10.ex17;

public class Address {
	private String addressName;
	private String zipCode;
	
	public Address(){}
	
	public Address(String addressName, String zipCode) {
		this.addressName = addressName;
		this.zipCode = zipCode;
	}

	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public int hashCode(){
		int result = 0;
		if (this.addressName != null) result += this.addressName.hashCode();
		if (this.zipCode != null) result += this.zipCode.hashCode();
		return result;
	}
	
	public boolean equals(Object obj){
		if (obj == null) return false;
		if (obj == this) return true;
		if (this.getClass() != obj.getClass()) return false;
		Address addr = (Address) obj;
		if (addr.addressName.equals(this.addressName)
				&& addr.zipCode.equals(this.zipCode)){
			return true;
		}else{
			return false;
		}
	}
	
}
