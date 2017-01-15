package com.criticalgnome.computers.beans;

import java.util.List;

/**
 * @author CriticalGnome
 *
 */
public class Type {
	private Group group;
	private boolean peripheral;
	private boolean hasCooler;
	private int energyConsumption;
	private List<Port> ports;

	public static class Builder {
		private Group group;
		private boolean peripheral;
		private boolean hasCooler;
		private int energyConsumption;
		private List<Port> ports;

		public Builder group(Group group) {
			this.group = group;
			return this;
		}

		public Builder peripheral(boolean peripheral) {
			this.peripheral = peripheral;
			return this;
		}

		public Builder hasCooler(boolean hasCooler) {
			this.hasCooler = hasCooler;
			return this;
		}

		public Builder energyConsumption(int energyConsumption) {
			this.energyConsumption = energyConsumption;
			return this;
		}

		public Builder ports(List<Port> ports) {
			this.ports = ports;
			return this;
		}

		public Type build() {
			return new Type(this);
		}

	}

	private Type(Builder builder) {
		group = builder.group;
		peripheral = builder.peripheral;
		hasCooler = builder.hasCooler;
		energyConsumption = builder.energyConsumption;
		ports = builder.ports;
	}

	/**
	 * Type constructor
	 *
	 * @param group
	 *            Group:Group of device
	 * @param peripheral
	 *            boolean:Is device peripheral
	 * @param hasCooler
	 *            boolean:Has device a cooler
	 * @param energyConsumption
	 *            int:Energy consumption
	 * @param ports
	 *            List:List of device ports
	 */
	public Type(Group group, boolean peripheral, boolean hasCooler, int energyConsumption, List<Port> ports) {
		super();
		this.group = group;
		this.peripheral = peripheral;
		this.hasCooler = hasCooler;
		this.energyConsumption = energyConsumption;
		this.ports = ports;
	}

	public Type() {

	}

	@Override
	public String toString() {
		return "Type [group=" + group + ", peripheral=" + peripheral + ", hasCooler=" + hasCooler
				+ ", energyConsumption=" + energyConsumption + ", ports=" + ports + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + energyConsumption;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + (hasCooler ? 1231 : 1237);
		result = prime * result + (peripheral ? 1231 : 1237);
		result = prime * result + ((ports == null) ? 0 : ports.hashCode());
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
		Type other = (Type) obj;
		if (energyConsumption != other.energyConsumption)
			return false;
		if (group != other.group)
			return false;
		if (hasCooler != other.hasCooler)
			return false;
		if (peripheral != other.peripheral)
			return false;
		if (ports == null) {
			if (other.ports != null)
				return false;
		} else if (!ports.equals(other.ports))
			return false;
		return true;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isPeripheral() {
		return peripheral;
	}

	public void setPeripheral(boolean peripheral) {
		this.peripheral = peripheral;
	}

	public boolean isHasCooler() {
		return hasCooler;
	}

	public void setHasCooler(boolean hasCooler) {
		this.hasCooler = hasCooler;
	}

	public int getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(int energyConsumption) {
		this.energyConsumption = energyConsumption;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

}
