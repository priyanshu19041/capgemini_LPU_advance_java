package com.assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HostelRoom {
	@Id
	private int roomId;
	private int roomNumber;
	private String blockName;
	private int floorNumber;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	@Override
	public String toString() {
		return "HostelRoom [roomId=" + roomId + ", roomNumber=" + roomNumber + ", blockName=" + blockName
				+ ", floorNumber=" + floorNumber + "]";
	}
	
}