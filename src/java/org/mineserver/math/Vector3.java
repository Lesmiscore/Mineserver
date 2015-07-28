/*
 * Copyright 2015 RandomAltThing (@TheDiamondYT)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in wr iting, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mineserver.math;

public class Vector3 {
	public int x = 0;
	public int y = 0;
	public int z = 0;

	public Vector3() {}

	public Vector3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getFloorX() {
		return (int) Math.floor(x);
	}

	public int getFloorY() {
		return (int) Math.floor(y);
	}

	public int getFloorZ() {
		return (int) Math.floor(z);
	}

	public int getRight() {
		return x;
	}

	public int getUp() {
		return y;
	}

	public int getForward() {
		return z;
	}

	public int getSouth() {
		return x;
	}

	public int getWest() {
		return z;
	}

	public Vector3 add(int x, int y, int z) {
		return new Vector3(this.x + x, this.y + y, this.z + z);
	}

	public Vector3 subtract(int x, int y, int z) {
		return add(-x, -y, -z);
	}

	public Vector3 multiply(int number) {
		return new Vector3(x * number, y * number, z * number);
	}

	public Vector3 divide(int number) {
		return new Vector3(x / number, y / number, z / number);
	}

	public Vector3 ceil() {
		return new Vector3((int) Math.ceil(x), (int) Math.ceil(y), (int) Math.ceil(z));
	}

	public Vector3 floor() {
		return new Vector3((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));
	}

	public Vector3 round() {
		return new Vector3((int) Math.round(x), (int) Math.round(y), (int) Math.round(z));
	}

	public Vector3 abs() {
		return new Vector3(Math.abs(x), Math.abs(y), Math.abs(z));
	}

	public Vector3 getSide(int face, int step) {
		switch((int) face) {
			case BlockFace.DOWN:
				return new Vector3(x, y - step, z);
			case BlockFace.UP:
				return new Vector3(x, y + step, z);
			case BlockFace.NORTH:
				return new Vector3(x, y, z - step);
			case BlockFace.SOUTH:
				return new Vector3(x, y, z + step);
			case BlockFace.WEST:
				return new Vector3(x - step, y, z);
			case BlockFace.EAST:
				return new Vector3(x + step, y, z);
			default:
				return this;
		}
	}

	public static int getOppositeSide(int face) {
		switch((int) face){
			case BlockFace.DOWN:
				return BlockFace.UP;
			case BlockFace.UP:
				return BlockFace.DOWN;
			case BlockFace.NORTH:
				return BlockFace.SOUTH;
			case BlockFace.SOUTH:
				return BlockFace.NORTH;
			case BlockFace.WEST:
				return BlockFace.EAST;
			case BlockFace.EAST:
				return BlockFace.WEST;
			default:
				return -1;
		}
	}

	public double distance(Vector3 pos) {
		return Math.sqrt(distanceSquared(pos));
	}

	public double distanceSquared(Vector3 pos) {
		return Math.pow(x - pos.x, 2) + Math.pow(y - pos.y, 2) + Math.pow(z - pos.z, 2);
	}

	public int maxPlainDistance(int x, int z) {
			return Math.max(Math.abs(this.x - x), Math.abs(this.z - z));
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	public int lengthSquared() {
		return x * x + y * y + z * z;
	}

	public Vector3 normalize() {
		int len = lengthSquared();
		if(len > 0)
			return divide((int) Math.sqrt(len));
		return new Vector3(0, 0, 0);
	}

	public int dot(Vector3 v) {
		return x * v.x + y * v.y + z * v.z;
	}

	public Vector3 cross(Vector3 v) {
		return new Vector3(
			y * v.z - z * v.y,
			z * v.x - x * v.z,
			x * v.y - y * v.x
		);
	}

	public boolean equals(Vector3 v) {
		return x == v.x && y == v.y && z == v.z;
	}

	public Vector3 getIntermediateWithXValue(Vector3 v, int x) {
		int xDiff = v.x - this.x;
		int yDiff = v.y - y;
		int zDiff = v.z - z;
		if((xDiff * xDiff) < 0.0000001)
			return null;
		int f = (x - this.x) / xDiff;
		if(f < 0 || f > 1)
			return null;
		else
			return new Vector3(this.x + xDiff * f, y + yDiff * f, z + zDiff * f);
	}

	public Vector3 getIntermediateWithYValue(Vector3 v, int y) {
		int xDiff = v.x - x;
		int yDiff = v.y - this.y;
		int zDiff = v.z - z;
		if((yDiff * yDiff) < 0.0000001)
			return null;
		int f = (y - this.y) / yDiff;
		if(f < 0 || f > 1)
			return null;
		else
			return new Vector3(x + xDiff * f, this.y + yDiff * f, z + zDiff * f);
	}

	public Vector3 getIntermediateWithZValue(Vector3 v, int z){
		int xDiff = v.x - x;
		int yDiff = v.y - y;
		int zDiff = v.z - this.z;
		if((zDiff * zDiff) < 0.0000001)
			return null;
		int f = (z - this.z) / zDiff;
		if(f < 0 || f > 1)
			return null;
		else
			return new Vector3(x + xDiff * f, y + yDiff * f, this.z + zDiff * f);
	}

	public Vector3 setComponents(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public String toString(){
		return "Vector3(X=" + x + ", Y=" + y + ", Z=" + z + ")";
	}
}