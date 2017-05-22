package edu.orangecoastcollege.cs272.ic14.model;


public class Order {
	private int mId;
	private String mDate;
	private int mQuantity;
	private double mTotal;
	private String mCreditCard;
	public Order (int id, String date, int quantity, double total, String creditCard)
	{
		mId = id;
		mDate = date;
		mQuantity = quantity;
		mTotal = total;
		mCreditCard = creditCard;
	}
	public int getId() {
		return mId;
	}
	public void setId(int id) {
		mId = id;
	}
	public String getDate() {
		return mDate;
	}
	public void setDate(String date) {
		mDate = date;
	}
	public int getQuantity() {
		return mQuantity;
	}
	public void setQuantity(int quantity) {
		mQuantity = quantity;
	}
	public double getTotal() {
		return mTotal;
	}
	public void setTotal(double total) {
		mTotal = total;
	}
	public String getCreditCard() {
		return mCreditCard;
	}
	public void setCreditCard(String creditCard) {
		mCreditCard = creditCard;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mCreditCard == null) ? 0 : mCreditCard.hashCode());
		result = prime * result + ((mDate == null) ? 0 : mDate.hashCode());
		result = prime * result + mId;
		result = prime * result + mQuantity;
		long temp;
		temp = Double.doubleToLongBits(mTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (mCreditCard == null) {
			if (other.mCreditCard != null)
				return false;
		} else if (!mCreditCard.equals(other.mCreditCard))
			return false;
		if (mDate == null) {
			if (other.mDate != null)
				return false;
		} else if (!mDate.equals(other.mDate))
			return false;
		if (mId != other.mId)
			return false;
		if (mQuantity != other.mQuantity)
			return false;
		if (Double.doubleToLongBits(mTotal) != Double.doubleToLongBits(other.mTotal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [Id=" + mId + ", Date=" + mDate + ", Quantity=" + mQuantity + ", Total=" + mTotal
				+ ", CreditCard=" + mCreditCard + "]";
	}

}
