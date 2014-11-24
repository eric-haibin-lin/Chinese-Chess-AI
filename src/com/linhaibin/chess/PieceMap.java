package com.linhaibin.chess;

import java.util.concurrent.ConcurrentHashMap;

public class PieceMap<K,V> extends ConcurrentHashMap<K,V> {
	protected V defaultValue;

	public PieceMap(V defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public V get(Object k) {
		return containsKey(k) ? super.get(k) : defaultValue;
	}
}
