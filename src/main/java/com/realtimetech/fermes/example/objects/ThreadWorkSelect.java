package com.realtimetech.fermes.example.objects;

import java.util.Random;

import com.realtimetech.fermes.database.Link;

public class ThreadWorkSelect implements Runnable {
	private Link<DummyManager> dummyManager;
	private int volume;

	public ThreadWorkSelect(Link<DummyManager> dummyManager, int volume) {
		this.dummyManager = dummyManager;
		this.volume = volume;
	}

	@Override
	public void run() {
		Random random = new Random();

		for (int i = 0; i < volume; i++) {
			int itemCount = dummyManager.get().getDummyCount();

			if (itemCount == 0) {
				i--;
			} else {
				DummyManager dummyManager2 = dummyManager.get();
				try {
					int nextInt = random.nextInt(itemCount);
					Link<Dummy> itemByGid = dummyManager2.getDummy(nextInt);
					@SuppressWarnings("unused")
					Dummy dummy = itemByGid.get();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
	}
}