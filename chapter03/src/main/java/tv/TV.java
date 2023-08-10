package tv;

public class TV {
	private int channel;    // 1~255 넘어가면 rotate
	private int volume;     // 0~100 넘어가면 rotate
	private boolean power;  
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(boolean up) {
		if(up) {
			this.channel += 1;	
		}else{
			this.channel -= 1;
		}
		
		if(this.channel > 255) {
			this.channel = 0;
		}
		if(this.channel < 0) {
			this.channel = 255;
		}
	}
	
	public void channel(int channel) {
		this.channel = channel;
	}
	
	public void volume(boolean up) {
		if(up) {
			this.volume += 1;	
		}else{
			this.volume -= 1;
		}
		if(this.volume > 255) {
			this.volume = 0;
		}
		if(this.volume < 0) {
			this.volume = 100;
		}
	}
	
	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") + ", channel="+channel+", volume="+volume);
	}
}
