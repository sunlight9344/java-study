package prob03;

import java.util.Objects;

public class Money {
	// hascode , equals 안에 있는 amount 가 같게
	
	private int amount;

	public Money(int i) {
		this.amount = i;
	}

	public Object add(Money in) {
		return new Money(this.amount + in.amount);
	}

	public Object minus(Money in) {
		return new Money(this.amount - in.amount);
	}

	public Object multiply(Money in) {
		return new Money(this.amount * in.amount);
	}

	public Object devide(Money in) {
		return new Money(this.amount / in.amount);
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
	
	/* 코드 작성 */
}
