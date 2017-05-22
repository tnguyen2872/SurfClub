package edu.orangecoastcollege.cs272.ic14.model;

public class Supplier 
{
	private int mId;
	private String mName;
	private String mAddress;
	private String mCity;
	private String mState;
	private String mProductCategory;
	
	public Supplier(int id, String name, String address, String city, String state, String productCategory) {
		super();
		mId = id;
		mName = name;
		mAddress = address;
		mCity = city;
		mState = state;
		mProductCategory = productCategory;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return mId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		mId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return mName;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		mName = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return mAddress;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		mAddress = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return mCity;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		mCity = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return mState;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		mState = state;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return mProductCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		mProductCategory = productCategory;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mAddress == null) ? 0 : mAddress.hashCode());
		result = prime * result + ((mCity == null) ? 0 : mCity.hashCode());
		result = prime * result + mId;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mProductCategory == null) ? 0 : mProductCategory.hashCode());
		result = prime * result + ((mState == null) ? 0 : mState.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (mAddress == null) {
			if (other.mAddress != null)
				return false;
		} else if (!mAddress.equals(other.mAddress))
			return false;
		if (mCity == null) {
			if (other.mCity != null)
				return false;
		} else if (!mCity.equals(other.mCity))
			return false;
		if (mId != other.mId)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mProductCategory == null) {
			if (other.mProductCategory != null)
				return false;
		} else if (!mProductCategory.equals(other.mProductCategory))
			return false;
		if (mState == null) {
			if (other.mState != null)
				return false;
		} else if (!mState.equals(other.mState))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supplier [mId=" + mId + ", mName=" + mName + ", mAddress=" + mAddress + ", mCity=" + mCity + ", mState="
				+ mState + ", mProductCategory=" + mProductCategory + "]";
	}
	
	
	

}
