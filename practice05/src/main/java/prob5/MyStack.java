package prob5;

public class MyStack{
	
	static int index = 0;

	private String[] buffer;
	
	public MyStack(int i) {
		buffer = new String[i];
	}

	public void push(String s) {
		
		if (index >= buffer.length){
			String[] newBuffer = new String[buffer.length*2];
			for(int i=0;i<buffer.length;i++) {
				newBuffer[i] = buffer[i];
			}
			buffer = null;
			buffer = newBuffer;
			newBuffer = null;
		}
		buffer[index] = s;
		index += 1;
	}

	public boolean isEmpty() {
		return index==0;
	}

	public String pop() throws MyStackException {
		
		if(isEmpty()) {
			throw new MyStackException();
		}
		index -= 1;
		return buffer[index];
	}

}