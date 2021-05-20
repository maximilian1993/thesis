
public class Main {
	
	static String [] tour = {"00.05","02.07","03.03","06.01","05.09","06.08","05.08","02.03","04.01","03.09","04.09","00.01","04.06"}; 
	static String [] shortWay = new String[tour.length + 1];
	static int length = 0;
	static int counter = 1;
	
	public static int getX(String a) {
		int x = 0;
		String getIt;
		
		getIt = a.substring(0, 2);
		x = Integer.parseInt(getIt) * 10;
		return x;
	}
	
	public static int getY(String a) {
		int y = 0;
		String getIt;
		
		getIt = a.substring(3, 5);
		y = Integer.parseInt(getIt);
		
		return y;
	}
	
	public static int getLength(String a, String b) {
		int length = 0;
		
		if(getX(a) == getX(b)) {
			length = Math.abs((getY(a) - getY(b))); 
		}
		else if((getX(a) == 10 && getX(b) == 20) || (getX(a) == 30 && getX(b) == 40) || (getX(a) == 50 && getX(b) == 60) || (getX(a) == 20 && getX(b) == 10) || (getX(a) == 40 && getX(b) == 30) || (getX(a) == 60 && getX(b) == 50)) {
			length = Math.abs((getX(a) + getX(b)) + (getY(a) - getY(b))); 
		}
		else {
			length = Math.abs((getX(a) + getX(b)) + (getY(a) + getY(b))); 
		}
		return length;
	}

	public static boolean isNotIn(String a) {
		boolean isIn = true;
		
		for(int i = 0; i < shortWay.length; i++) {
			if(shortWay[i] == a) {
				isIn = false;
			}
		}
		
		return isIn;
	}
	
	public static void getRes(String a) {
		int localLength = 0;
		length = 1000;
		
		for (int i = 0; i < (tour.length); i++) {
			if(isNotIn(tour[i]) && a != tour[i]) {
				localLength = getLength(a, tour[i]);
				if(localLength < length) {
					shortWay[counter] = tour[i];
					length = localLength;
				}
			}
		}
		counter++;
	}
	
	
	public static void main(String[] args) {
		shortWay[0] = "00.00";
		
		for(int i = 0; i < tour.length; i++) {
			getRes(shortWay[i]);
		}
		
		for(int b = 0; b < tour.length+1; b++) {
			System.out.println(shortWay[b]);
		}
	}
}
