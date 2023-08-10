package tv;

public class TV {
	private int channel;    // 1~255 넘어가면 rotate
	private int volume;     // 0~100 넘어가면 rotate
	private boolean power;  
	
	public TV(int channel, int volume, boolean power) {
		
	}

	public void power(boolean on) {
		power = on;
	}
	
	public void channel(boolean up) {
		
	}
	
	public void channel(int channel) {
		this.channel = channel;
	}
	
	public void volume(boolean up) {
		
	}
	
	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") + ", channel="+channel+", volume="+volume);
	}
}
