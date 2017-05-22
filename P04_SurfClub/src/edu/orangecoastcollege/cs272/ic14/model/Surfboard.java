package edu.orangecoastcollege.cs272.ic14.model;

public class Surfboard 
{
	private int mId;
	private String mName;
	private double mLength;
	private double mWidth;
	private double mThickness;
	private String mFins;
	private int mCheckoutCount;
	
	public Surfboard(int id, String name, double length, double width, double thickness, String fins) {
		super();
		mId = id;
		mName = name;
		mLength = length;
		mWidth = width;
		mThickness = thickness;
		mFins = fins;
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
	 * @return the length
	 */
	public double getLength() {
		return mLength;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		mLength = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return mWidth;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		mWidth = width;
	}

	/**
	 * @return the thickness
	 */
	public double getThickness() {
		return mThickness;
	}

	/**
	 * @param thickness the thickness to set
	 */
	public void setThickness(double thickness) {
		mThickness = thickness;
	}

	/**
	 * @return the fins
	 */
	public String getFins() {
		return mFins;
	}

	/**
	 * @param fins the fins to set
	 */
	public void setFins(String fins) {
		mFins = fins;
	}

	/**
	 * @return the checkoutCount
	 */
	public int getCheckoutCount() {
		return mCheckoutCount;
	}

	/**
	 * @param checkoutCount the checkoutCount to set
	 */
	public void setCheckoutCount(int checkoutCount) {
		mCheckoutCount = checkoutCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCheckoutCount;
		result = prime * result + ((mFins == null) ? 0 : mFins.hashCode());
		result = prime * result + mId;
		long temp;
		temp = Double.doubleToLongBits(mLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		temp = Double.doubleToLongBits(mThickness);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mWidth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Surfboard other = (Surfboard) obj;
		if (mCheckoutCount != other.mCheckoutCount)
			return false;
		if (mFins == null) {
			if (other.mFins != null)
				return false;
		} else if (!mFins.equals(other.mFins))
			return false;
		if (mId != other.mId)
			return false;
		if (Double.doubleToLongBits(mLength) != Double.doubleToLongBits(other.mLength))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (Double.doubleToLongBits(mThickness) != Double.doubleToLongBits(other.mThickness))
			return false;
		if (Double.doubleToLongBits(mWidth) != Double.doubleToLongBits(other.mWidth))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Surfboard [mId=" + mId + ", mName=" + mName + ", mLength=" + mLength + ", mWidth=" + mWidth
				+ ", mThickness=" + mThickness + ", mFins=" + mFins + ", mCheckoutCount=" + mCheckoutCount + "]";
	}

	

}