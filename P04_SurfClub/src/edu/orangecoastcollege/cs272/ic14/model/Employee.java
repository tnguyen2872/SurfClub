package edu.orangecoastcollege.cs272.ic14.model;
import sun.util.calendar.BaseCalendar.Date;

public class Employee {
	private int mId;
	private String mFirstName;
	private String mLastName;
	private String mPosition;
	private String mDateHired;
	private String mGender;
	private String mSSN;
	private Double mWage;
	
	
	
	
	
	public Employee(int id, String firstName, String lastName, String position, String dateHired, String gender, String ssn, double wage)
	{
		mId = id;
		mFirstName = firstName;
		mLastName = lastName;
		mPosition = position;
		mDateHired = dateHired;
		mGender = gender;
		mSSN = ssn;
		mWage = wage;
		
	}

	public int getId() {
		return mId;
	}
	public void setId(int id) {
		mId = id;
	}


	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}


	public String getPosition() {
		return mPosition;
	}

	public void setPosition(String position) {
		mPosition = position;
	}

	public String getDateHired() {
		return mDateHired;
	}

	public void setDateHired(String dateHired) {
		mDateHired = dateHired;
	}

	public String getGender() {
		return mGender;
	}

	public void setGender(String gender) {
		mGender = gender;
	}

	public Double getWage() {
		return mWage;
	}
	public void setWage(Double wage) {
		mWage = wage;
	}

	public String getSSN() {
		return mSSN;
	}

	public void setSSN(String sSN) {
		mSSN = sSN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mDateHired == null) ? 0 : mDateHired.hashCode());
		result = prime * result + ((mFirstName == null) ? 0 : mFirstName.hashCode());
		result = prime * result + ((mGender == null) ? 0 : mGender.hashCode());
		result = prime * result + mId;
		result = prime * result + ((mLastName == null) ? 0 : mLastName.hashCode());
		result = prime * result + ((mPosition == null) ? 0 : mPosition.hashCode());
		result = prime * result + ((mSSN == null) ? 0 : mSSN.hashCode());
		result = prime * result + ((mWage == null) ? 0 : mWage.hashCode());
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
		Employee other = (Employee) obj;
		if (mDateHired == null) {
			if (other.mDateHired != null)
				return false;
		} else if (!mDateHired.equals(other.mDateHired))
			return false;
		if (mFirstName == null) {
			if (other.mFirstName != null)
				return false;
		} else if (!mFirstName.equals(other.mFirstName))
			return false;
		if (mGender == null) {
			if (other.mGender != null)
				return false;
		} else if (!mGender.equals(other.mGender))
			return false;
		if (mId != other.mId)
			return false;
		if (mLastName == null) {
			if (other.mLastName != null)
				return false;
		} else if (!mLastName.equals(other.mLastName))
			return false;
		if (mPosition == null) {
			if (other.mPosition != null)
				return false;
		} else if (!mPosition.equals(other.mPosition))
			return false;
		if (mSSN == null) {
			if (other.mSSN != null)
				return false;
		} else if (!mSSN.equals(other.mSSN))
			return false;
		if (mWage == null) {
			if (other.mWage != null)
				return false;
		} else if (!mWage.equals(other.mWage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [mId=" + mId + ", mFirstName=" + mFirstName + ", mLastName=" + mLastName + ", mPosition="
				+ mPosition + ", mDateHired=" + mDateHired + ", mGender=" + mGender + ", mSSN=" + mSSN + ", mWage="
				+ mWage + "]";
	}
	
	
}