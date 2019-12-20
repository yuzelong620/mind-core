/**
 * 
 */
package com.mind.core.util;

/**
 * 物品、数量、概率
 * @author ninglong 2014年11月29日 下午9:12:23
 */
public class ThreeTuple {

	private String key;
	private int value;
	private int probability;
	
	public ThreeTuple(String key, int value, int probability) {
		this.key = key;
		this.value = value;
		this.probability = probability;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getProbability() {
		return probability;
	}
	public void setProbability(int probability) {
		this.probability = probability;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
