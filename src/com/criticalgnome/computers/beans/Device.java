package com.criticalgnome.computers.beans;

/**
 * @author CriticalGnome
 *
 */
public class Device {
	private String name;
	private String origin;
	private int price;
	private Type type;
	private boolean critical;

	/**
	 * Device constructor
	 * 
	 * @param name
	 *            String:Device name
	 * @param origin
	 *            String:Device origin
	 * @param price
	 *            int:Current price
	 * @param type
	 *            Type:Type of device
	 * @param critical
	 *            boolean:Is device critical
	 */
	public Device(String name, String origin, int price, Type type, boolean critical) {
		super();
		this.name = name;
		this.origin = origin;
		this.price = price;
		this.type = type;
		this.critical = critical;
	}

	public Device() {

	}

	@Override
	public String toString() {
		return "Device [name=" + name + ", origin=" + origin + ", price=" + price + ", type=" + type + ", critical="
				+ critical + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (critical ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Device other = (Device) obj;
		if (critical != other.critical)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (price != other.price)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isCritical() {
		return critical;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}

}
