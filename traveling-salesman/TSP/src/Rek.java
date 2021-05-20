

public class Rek {
	// 00.10 muss in jedem Array auftauchen, da die Route dorthin zurückführen muss
	//static String [] parts = {"00.05","06.01","02.03","00.10"};
	//static String [] parts = {"Start","00.01","03.09","02.03","00.05","06.01","02.07","07.10","Ende"};
	//static String [] parts = {"Start","03.02","02.02","01.05","05.06","07.10","00.01","Ende"};
	static String [] parts = {"Start","00.05","02.07","03.03","06.01","05.09","06.08","05.08","02.03","04.01","03.09","04.09","00.01","04.06","Ende"};
	static int [][] regNum = {{0,1,2,3,4,5,6,7,8,9}, {10,11,12,13,14,15,16,17,18,19}, {20,21,22,23,24,25,26,27,28,29}, {30,31,32,33,34,35,36,37,38,39}, {40,41,42,43,44,45,46,47,48,49}, {50,51,52,53,54,55,56,57,58,59}, {60,61,62,63,64,65,66,67,68,69}, {70,71,72,73,74,75,76,77,78,79}, {80,81,82,83,84,85,86,87,88,89}};
	static int [][] tour = {{0,1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,10,11,3,4,5,6,7,8,9,10,11,12,5,6,7,8,9,10,11,12,13,14,6,7,8,9,10,11,12,13,14,15,8,9,10,11,12,13,14,15,16,17,9,10,11,12,13,14,15,16,17,18,11,12,13,14,15,16,17,18,19,20},{1,0,1,2,3,4,5,6,7,8,3,4,5,6,7,8,9,10,11,10,4,5,6,7,8,9,10,11,12,11,6,7,8,9,10,11,12,13,14,13,7,8,9,10,11,12,13,14,15,14,9,10,11,12,13,14,15,16,17,16,10,11,12,13,14,15,16,17,18,17,12,13,14,15,16,17,18,19,20,19},{2,1,0,1,2,3,4,5,6,7,4,5,6,7,8,9,10,11,10,9,5,6,7,8,9,10,11,12,11,10,7,8,9,10,11,12,13,14,13,12,8,9,10,11,12,13,14,15,14,13,10,11,12,13,14,15,16,17,16,15,11,12,13,14,15,16,17,18,17,16,13,14,15,16,17,18,19,20,19,18},{3,2,1,0,1,2,3,4,5,6,5,6,7,8,9,10,11,10,9,8,6,7,8,9,10,11,12,11,10,9,8,9,10,11,12,13,14,13,12,11,9,10,11,12,13,14,15,14,13,12,11,12,13,14,15,16,17,16,15,14,12,13,14,15,16,17,18,17,16,15,14,15,16,17,18,19,20,19,18,17},{4,3,2,1,0,1,2,3,4,5,6,7,8,9,10,11,10,9,8,7,7,8,9,10,11,12,11,10,9,8,9,10,11,12,13,14,13,12,11,10,10,11,12,13,14,15,14,13,12,11,12,13,14,15,16,17,16,15,14,13,13,14,15,16,17,18,17,16,15,14,15,16,17,18,19,20,19,18,17,16},{5,4,3,2,1,0,1,2,3,4,7,8,9,10,11,10,9,8,7,6,8,9,10,11,12,11,10,9,8,7,10,11,12,13,14,13,12,11,10,9,11,12,13,14,15,14,13,12,11,10,13,14,15,16,17,16,15,14,13,12,14,15,16,17,18,17,16,15,14,13,16,17,18,19,20,19,18,17,16,15},{6,5,4,3,2,1,0,1,2,3,8,9,10,11,10,9,8,7,6,5,9,10,11,10,9,8,7,6,5,4,11,12,13,12,11,10,9,8,7,6,12,13,14,13,12,11,10,9,8,7,14,15,16,15,14,13,12,11,10,9,15,16,17,16,15,14,13,12,11,10,17,18,19,18,17,16,15,14,13,12},{7,6,5,4,3,2,1,0,1,2,9,10,11,10,9,8,7,6,5,4,10,11,12,11,10,9,8,7,6,5,12,13,14,13,12,11,10,9,8,7,13,14,15,14,13,12,11,10,9,8,15,16,17,16,15,14,13,12,11,10,16,17,18,17,16,15,14,13,12,11,18,19,20,19,18,17,16,15,14,13},{8,7,6,5,4,3,2,1,0,1,10,11,10,9,8,7,6,5,4,3,11,12,11,10,9,8,7,6,5,4,13,14,13,12,11,10,9,8,7,6,14,15,14,13,12,11,10,9,8,7,16,17,16,15,14,13,12,11,10,9,17,18,17,16,15,14,13,12,11,10,19,20,19,18,17,16,15,14,13,12},{9,8,7,6,5,4,3,2,1,0,11,10,9,8,7,6,5,4,3,2,12,11,10,9,8,7,6,5,4,3,14,13,12,11,10,9,8,7,6,5,15,14,13,12,11,10,9,8,7,6,17,16,15,14,13,12,11,10,9,8,18,17,16,15,14,13,12,11,10,9,20,19,18,17,16,15,14,13,12,11},{2,3,4,5,6,7,8,9,10,11,0,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,10,3,4,5,6,7,8,9,10,11,12,4,5,6,7,8,9,10,11,12,13,6,7,8,9,10,11,12,13,14,15,7,8,9,10,11,12,13,14,15,16,9,10,11,12,13,14,15,16,17,18,},{3,4,5,6,7,8,9,10,11,10,1,0,1,2,3,4,5,6,7,8,2,1,2,3,4,5,6,7,8,9,4,3,4,5,6,7,8,9,10,11,5,4,5,6,7,8,9,10,11,12,7,6,7,8,9,10,11,12,13,14,8,7,8,9,10,11,12,13,14,15,10,9,10,11,12,13,14,15,16,17},{4,5,6,7,8,9,10,11,10,9,2,1,0,1,2,3,4,5,6,7,3,2,1,2,3,4,5,6,7,8,5,4,3,4,5,6,7,8,9,10,6,5,4,5,6,7,8,9,10,11,8,7,6,7,8,9,10,11,12,13,9,8,7,8,9,10,11,12,13,14,11,10,9,10,11,12,13,14,15,16},{5,6,7,8,9,10,11,10,9,8,3,2,1,0,1,2,3,4,5,6,4,3,2,1,2,3,4,5,6,7,6,5,4,3,4,5,6,7,8,9,7,6,5,4,5,6,7,8,9,10,9,8,7,6,7,8,9,10,11,12,10,9,8,7,8,9,10,11,12,13,12,11,10,9,10,11,12,13,14,15},{6,7,8,9,10,11,10,9,8,7,4,3,2,1,0,1,2,3,4,5,5,4,3,2,1,2,3,4,5,6,7,6,5,4,3,4,5,6,7,8,8,7,6,5,4,5,6,7,8,9,10,9,8,7,6,7,8,9,10,11,11,10,9,8,7,8,9,10,11,12,13,12,11,10,9,10,11,12,13,14},{7,8,9,10,11,10,9,8,7,6,5,4,3,2,1,0,1,2,3,4,6,5,4,3,2,1,2,3,4,5,8,7,6,5,4,3,4,5,6,7,9,8,7,6,5,4,5,6,7,8,11,10,9,8,7,6,7,8,9,10,12,11,10,9,8,7,8,9,10,11,14,13,12,11,10,9,10,11,12,13},{8,9,10,11,10,9,8,7,6,5,6,5,4,3,2,1,0,1,2,3,7,6,5,4,3,2,1,2,3,4,9,8,7,6,5,4,3,4,5,6,10,9,8,7,6,5,4,5,6,7,12,11,10,9,8,7,6,7,8,9,13,12,11,10,9,8,7,8,9,10,15,14,13,12,11,10,9,10,11,12},{9,10,11,10,9,8,7,6,5,4,7,6,5,4,3,2,1,0,1,2,8,7,6,5,4,3,2,1,2,3,10,9,8,7,6,5,4,3,4,5,11,10,9,8,7,6,5,4,5,6,13,12,11,10,9,8,7,6,7,8,14,13,12,11,10,9,8,7,8,9,16,15,14,13,12,11,10,9,10,11},{10,11,10,9,8,7,6,5,4,3,8,7,6,5,4,3,2,1,0,1,9,8,7,6,5,4,3,2,1,2,11,10,9,8,7,6,5,4,3,4,12,11,10,9,8,7,6,5,4,5,14,13,12,11,10,9,8,7,6,7,15,14,13,12,11,10,9,8,7,8,17,16,15,14,13,12,11,10,9,10},{11,10,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,1,0,10,9,8,7,6,5,4,3,2,1,12,11,10,9,8,7,6,5,4,3,13,12,11,10,9,8,7,6,5,4,15,14,13,12,11,10,9,8,7,6,16,15,14,13,12,11,10,9,8,7,18,17,16,15,14,13,12,11,10,9},{3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,0,1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,10,11,3,4,5,6,7,8,9,10,11,12,5,6,7,8,9,10,11,12,13,14,6,7,8,9,10,11,12,13,14,15,8,9,10,11,12,13,14,15,16,17},{4,5,6,7,8,9,10,11,12,11,2,1,2,3,4,5,6,7,8,9,1,0,1,2,3,4,5,6,7,8,3,4,5,6,7,8,9,10,11,10,4,5,6,7,8,9,10,11,12,11,6,7,8,9,10,11,12,13,14,13,7 ,8,9,10,11,12,13,14,15,14,9,10,11,12,13,14,15,16,17,16},{5,6,7,8,9,10,11,12,11,10,   3,2,1,2,3,4,5,6,7,8,  2,1,0,1,2,3,4,5,6,7,   4,5,6,7,8,9,10,11,10,9,    5,6,7,8,9,10,11,12,11,10,       7,8,9,10,11,12,13,14,13,12,   8,9,10,11,12,13,14,15,14,13,   10,11,12,13,14,15,16,17,16,15},{6,7,8,9,10,11,12,11,10,9,4,3,2,1,2,3,4,5,6,7,3,2,1,0,1,2,3,4,5,6,5,6,7,8,9,10,11,10,9,8,6,7,8,9,10,11,12,11,10,9,8,9,10,11,12,13,14,13,12,11,9,10,11,12,13,14,15,14,13,12,11,12,13,14,15,16,17,16,15,14},{7,8,9,10,11,12,11,10,9,8,5,4,3,2,1,2,3,4,5,6,4,3,2,1,0,1,2,3,4,5,6,7,8,9,10,11,10,9,8,7,7,8,9,10,11,12,11,10,9,8,9,10,11,12,13,14,13,12,11,10,10,11,12,13,14,15,14,13,12,11,12,13,14,15,16,17,16,15,14,13},{8,9,10,11,12,11,10,9,8,7,6,5,4,3,2,1,2,3,4,5,5,4,3,2,1,0,1,2,3,4,7,8,9,10,11,10,9,8,7,6,8,9,10,11,12,11,10,9,8,7,10,11,12,13,14,13,12,11,10,9,11,12,13,14,15,14,13,12,11,10,13,14,15,16,17,16,15,14,13,12},{9,10,11,12,11,10,9,8,7,6,7,6,5,4,3,2,1,2,3,4,6,5,4,3,2,1,0,1,2,3,8,9,10,11,10,9,8,7,6,5,9,10,11,12,11,10,9,8,7,6,11,12,13,14,13,12,11,10,9,8,12,13,14,15,14,13,12,11,10,9,14,15,16,17,16,15,14,13,12,11},{10,11,12,11,10,9,8,7,6,5,8,7,6,5,4,3,2,1,2,3,7,6,5,4,3,2,1,0,1,2,9,10,11,10,9,8,7,6,5,4,10,11,12,11,10,9,8,7,6,5,12,13,14,13,12,11,10,9,8,7,13,14,15,14,13,12,11,10,9,8,15,16,17,16,15,14,13,12,11,10},{11,12,11,10,9,8,7,6,5,4,9,8,7,6,5,4,3,2,1,2,8,7,6,5,4,3,2,1,0,1,10,11,10,9,8,7,6,5,4,3,11,12,11,10,9,8,7,6,5,4,13,14,13,12,11,10,9,8,7,6,14,15,14,13,12,11,10,9,8,7,16,17,16,15,14,13,12,11,10,9},{12,11,10,9,8,7,6,5,4,3,10,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,0,11,10,9,8,7,6,5,4,3,2,12,11,10,9,8,7,6,5,4,3,14,13,12,11,10,9,8,7,6,5,15,14,13,12,11,10,9,8,7,6,17,16,15,14,13,12,11,10,9,8,},{5,6,7,8,9,10,11,12,13,14,3,4,5,6,7,8,9,10,11,12,2,3,4,5,6,7,8,9,10,11,0,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,10,3,4,5,6,7,8,9,10,11,12,4,5,6,7,8,9,10,11,12,13,6,7,8,9,10,11,12,13,14,15},{6,7,8,9,10,11,12,13,14,13,4,5,6,7,8,9,10,11,12,11,3,4,5,6,7,8,9,10,11,10,1,0,1,2,3,4,5,6,7,8,2,1,2,3,4,5,6,7,8,9,4,5,6,7,8,9,10,11,12,11,5,6,7,8,9,10,11,12,13,12,7,8,9,10,11,12,13,14,15,14},{5,6,7,8,9,10,11,12,11,10,3,4,5,6,7,8,9,10,9,8,4,5,6,7,8,9,10,11,10,9,2,1,0,1,2,3,4,5,6,7,3,2,1,2,3,4,5,6,7,8,5,6,7,8,9,10,11,12,11,10,6,7,8,9,10,11,12,13,12,11,8,9,10,11,12,13,14,15,14,13},{8,9,10,11,12,13,14,13,12,11,6,7,8,9,10,11,12,11,10,9,5,6,7,8,9,10,11,10,9,8,3,2,1,0,1,2,3,4,5,6,4,3,2,1,2,3,4,5,6,7,6,7,8,9,10,11,12,11,10,9,7,8,9,10,11,12,13,12,11,10,9,10,11,12,13,14,15,14,13,12},{9,10,11,12,13,14,13,12,11,10,7,8,9,10,11,12,11,10,9,8,6,7,8,9,10,11,10,9,8,7,4,3,2,1,0,1,2,3,4,5,5,4,3,2,1,2,3,4,5,6,7,8,9,10,11,12,11,10,9,8,8,9,10,11,12,13,12,11,10,9,10,11,12,13,14,15,14,13,12,11},{10,11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,7,8,9,10,11,10,9,8,7,6,5,4,3,2,1,0,1,2,3,4,6,5,4,3,2,1,2,3,4,5,8,9,10,11,12,11,10,9,8,7,9,10,11,12,13,12,11,10,9,8,11,12,13,14,15,14,13,12,11,10},{11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,6,8,9,10,11,10,9,8,7,6,5,6,5,4,3,2,1,0,1,2,3,7,6,5,4,3,2,1,2,3,4,9,10,11,12,11,10,9,8,7,6,10,11,12,13,12,11,10,9,8,7,12,13,14,15,14,13,12,11,10,9},{12,13,14,13,12,11,10,9,8,7,10,11,12,11,10,9,8,7,6,5,9,10,11,10,9,8,7,6,5,4,7,6,5,4,3,2,1,0,1,2,8,7,6,5,4,3,2,1,2,3,10,11,12,11,10,9,8,7,6,5,11,12,13,12,11,10,9,8,7,6,13,14,15,14,13,12,11,10,9,8},{13,14,13,12,11,10,9,8,7,6,11,12,11,10,9,8,7,6,5,4,10,11,10,9,8,7,6,5,4,3,8,7,6,5,4,3,2,1,0,1,9,8,7,6,5,4,3,2,1,2,11,12,11,10,9,8,7,6,5,4,12,13,12,11,10,9,8,7,6,5,14,15,14,13,12,11,10,9,8,7},{14,13,12,11,10,9,8,7,6,5,12,11,10,9,8,7,6,5,4,3,11,10,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,1,0,10,9,8,7,6,5,4,3,2,1,12,11,10,9,8,7,6,5,4,3,13,12,11,10,9,8,7,6,5,4,15,14,13,12,11,10,9,8,7,6},{6,7,8,9,10,11,12,13,14,15,4,5,6,7,8,9,10,11,12,13,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,0,1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,10,11,3,4,5,6,7,8,9,10,11,12,5,6,7,8,9,10,11,12,13,14},{7,8,9,10,11,12,13,14,15,14,5,6,7,8,9,10,11,12,13,12,4,5,6,7,8,9,10,11,12,11,2,1,2,3,4,5,6,7,8,9,1,0,1,2,3,4,5,6,7,8,3,4,5,6,7,8,9,10,11,10,4,5,6,7,8,9,10,11,12,11,6,7,8,9,10,11,12,13,14,13},{8,9,10,11,12,13,14,15,14,13,6,7,8,9,10,11,12,13,12,11,5,6,7,8,9,10,11,12,11,10,3,2,1,2,3,4,5,6,7,8,2,1,0,1,2,3,4,5,6,7,4,5,6,7,8,9,10,11,10,9,5,6,7,8,9,10,11,12,11,10,7,8,9,10,11,12,13,14,13,12},{9,10,11,12,13,14,15,14,13,12,7,8,9,10,11,12,13,12,11,10,6,7,8,9,10,11,12,11,10,9,4,3,2,1,2,3,4,5,6,7,3,2,1,0,1,2,3,4,5,6,5,6,7,8,9,10,11,10,9,8,6,7,8,9,10,11,12,11,10,9,8,9,10,11,12,13,14,13,12,11},{10,11,12,13,14,15,14,13,12,11,8,9,10,11,12,13,12,11,10,9,7,8,9,10,11,12,11,10,9,8,5,4,3,2,1,2,3,4,5,6,4,3,2,1,0,1,2,3,4,5,6,7,8,9,10,11,10,9,8,7,7,8,9,10,11,12,11,10,9,8,9,10,11,12,13,14,13,12,11,10},{11,12,13,14,15,14,13,12,11,10,9,10,11,12,13,12,11,10,9,8,8,9,10,11,12,11,10,9,8,7,6,5,4,3,2,1,2,3,4,5,7,8,9,10,11,10,9,8,7,6,8,9,10,11,12,11,10,9,8,7,10,11,12,13,14,13,12,11,10,9},{11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,6,8,9,10,11,10,9,8,7,6,5,7,6,5,4,3,2,1,2,3,4,6,5,4,3,2,1,0,1,2,3,8,9,10,11,10,9,8,7,6,5,9,10,11,12,11,10,9,8,7,6,11,12,13,14,13,12,11,10,9,8},{13,14,15,14,13,12,11,10,9,8,11,12,13,12,11,10,9,8,7,6,10,11,12,11,10,9,8,7,6,5,8,7,6,5,4,3,2,1,2,3,7,6,5,4,3,2,1,0,1,2,9,10,11,10,9,8,7,6,5,4,10,11,12,11,10,9,8,7,6,5,12,13,14,13,12,11,10,9,8,7},{14,15,14,13,12,11,10,9,8,7,12,13,12,11,10,9,8,7,6,5,11,12,11,10,9,8,7,6,5,4,9,8,7,6,5,4,3,2,1,2,8,7,6,5,4,3,2,1,0,1,10,11,10,9,8,7,6,5,4,3,11,12,11,10,9,8,7,6,5,4,11,12,11,10,9,8,7,6,5,4,13,14,13,12,11,10,9,8,7,6},{15,14,13,12,11,10,9,8,7,6,13,12,11,10,9,8,7,6,5,4,12,11,10,9,8,7,6,5,4,3,10,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,0,11,10,9,8,7,6,5,4,3,2,12,11,10,9,8,7,6,5,4,3,14,13,12,11,10,9,8,7,6,5},{8,9,10,11,12,13,14,15,16,17,6,7,8,9,10,11,12,13,14,15,5,6,7,8,9,10,11,12,13,14,3,4,5,6,7,8,9,10,11,12, 2,3,4,5,6,7,8,9,10,11,0,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,10,3,4,5,6,7,8,9,10,11,12},{9,10,11,12,13,14,15,16,17,16,7,8,9,10,11,12,13,14,15,14,6,7,8,9,10,11,12,13,14,13,4,5,6,7,8,9,10,11,12,11,3,4,5,6,7,8,9,10,11,10,1,0,1,2,3,4,5,6,7,8,2,1,2,3,4,5,6,7,8,9,4,5,6,7,8,9,10,11,12,11},{10,11,12,13,14,15,16,17,16,15,8,9,10,11,12,13,14,15,14,13,7,8,9,10,11,12,13,14,13,12,5,6,7,8,9,10,11,12,11,10,4,5,6,7,8,9,10,11,10,9,2,1,0,1,2,3,4,5,6,7,3,2,1,2,3,4,5,6,7,8,5,6,7,8,9,10,11,12,11,10},{11,12,13,14,15,16,17,16,15,14,9,10,11,12,13,14,15,14,13,12,8,9,10,11,12,13,14,13,12,11,6,7,8,9,10,11,12,11,10,9,5,6,7,8,9,10,11,10,9,8,3,2,1,0,1,2,3,4,5,6,4,3,2,1,2,3,4,5,6,7,6,7,8,9,10,11,12,11,10,9}, {12,13,14,15,16,17,16,15,14,13,10,11,12,13,14,15,14,13,12,11,9,10,11,12,13,14,13,12,11,10,7,8,9,10,11,12,11,10,9,8,6,7,8,9,10,11,10,9,8,7,4,3,2,1,0,1,2,3,4,5,5,4,3,2,1,2,3,4,5,6,7,8,9,10,11,12,11,10,9,8},{13,14,15,16,17,16,15,14,13,12,11,12,13,14,15,14,13,12,11,10,10,11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,7,8,9,10,11,10,9,8,7,6,5,4,3,2,1,0,1,2,3,4,6,5,4,3,2,1,2,3,4,5,8,9,10,11,12,11,10,9,8,7},{14,15,16,17,16,15,14,13,12,11,12,13,14,15,14,13,12,11,10,9,11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,6,8,9,10,11,10,9,8,7,6,5,6,5,4,3,2,1,0,1,2,3,7,6,5,4,3,2,1,2,3,4,9,10,11,12,11,10,9,8,7,6},{15,16,17,16,15,14,13,12,11,10,13,14,15,14,13,12,11,10,9,8,12,13,14,13,12,11,10,9,8,7,10,11,12,11,10,9,8,7,6,5,9,10,11,10,9,8,7,6,5,4,7,6,5,4,3,2,1,0,1,2,8,7,6,5,4,3,2,1,2,3,10,11,12,11,10,9,8,7,6,5},{16,17,16,15,14,13,12,11,10,9,14,15,14,13,12,11,10,9,8,7,13,14,13,12,11,10,9,8,7,6,11,12,11,10,9,8,7,6,5,4,10,11,10,9,8,7,6,5,4,3,8,7,6,5,4,3,2,1,0,1,9,8,7,6,5,4,3,2,1,2,11,12,11,10,9,8,7,6,5,4},{17,16,15,14,13,12,11,10,9,8,15,14,13,12,11,10,9,8,7,6,14,13,12,11,10,9,8,7,6,5,12,11,10,9,8,7,6,5,4,3,11,10,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,1,0,10,9,8,7,6,5,4,3,2,1,12,11,10,9,8,7,6,5,4,3},{9,10,11,12,13,14,15,16,17,18,7,8,9,10,11,12,13,14,15,16,6,7,8,9,10,11,12,13,14,15,4,5,6,7,8,9,10,11,12,13,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,0,1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,10,11},{10,11,12,13,14,15,16,17,18,17,8,9,10,11,12,13,14,15,16,15,7,8,9,10,11,12,13,14,15,14,5,6,7,8,9,10,11,12,13,12,4,5,6,7,8,9,10,11,12,11,2,1,2,3,4,5,6,7,8,9,1,0,1,2,3,4,5,6,7,8,3,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,17,16,9,10,11,12,13,14,15,16,15,14,8,9,10,11,12,13,14,15,14,13,6,7,8,9,10,11,12,13,12,11,5,6,7,8,9,10,11,12,11,10,3,2,1,2,3,4,5,6,7,8,2,1,0,1,2,3,4,5,6,7,4,5,6,7,8,9,10,11,10,9},{12,13,14,15,16,17,18,17,16,15,10,11,12,13,14,15,16,15,14,13,9,10,11,12,13,14,15,14,13,12,7,8,9,10,11,12,13,12,11,10,6,7,8,9,10,11,12,11,10,9,4,3,2,1,2,3,4,5,6,7,3,2,1,0,1,2,3,4,5,6,5,6,7,8,9,10,11,10,9,8},{13,14,15,16,17,18,17,16,15,14,11,12,13,14,15,16,15,14,13,12,10,11,12,13,14,15,14,13,12,11,8,9,10,11,12,13,12,11,10,9,7,8,9,10,11,12,11,10,9,8,5,4,3,2,1,2,3,4,5,6,4,3,2,1,0,1,2,3,4,5,6,7,8,9,10,11,10,9,8,7},{14,15,16,17,18,17,16,15,14,13,12,13,14,15,16,15,14,13,12,11,11,12,13,14,15,14,13,12,11,10,9,10,11,12,13,12,11,10,9,8,8,9,10,11,12,11,10,9,8,7,6,5,4,3,2,1,2,3,4,5,5,4,3,2,1,0,1,2,3,4,7,8,9,10,11,10,9,8,7,6},{15,16,17,18,17,16,15,14,13,12,13,14,15,16,15,14,13,12,11,10,12,13,14,15,14,13,12,11,10,9,10,11,12,13,12,11,10,9,8,7,9,10,11,12,11,10,9,8,7,6,7,6,5,4,3,2,1,2,3,4,6,5,4,3,2,1,0,1,2,3,8,9,10,11,10,9,8,7,6,5},{16,17,18,17,16,15,14,13,12,11,14,15,16,15,14,13,12,11,10,9,13,14,15,14,13,12,11,10,9,8,11,12,13,12,11,10,9,8,7,6,10,11,12,11,10,9,8,7,6,5,8,7,6,5,4,3,2,1,2,3,7,6,5,4,3,2,1,0,1,2,9,10,11,10,9,8,7,6,5,4},{17,18,17,16,15,14,13,12,11,10,15,16,15,14,13,12,11,10,9,8,14,15,14,13,12,11,10,9,8,7,12,13,12,11,10,9,8,7,6,5,11,12,11,10,9,8,7,6,5,4,9,8,7,6,5,4,3,2,1,2,8,7,6,5,4,3,2,1,0,1,10,11,10,9,8,7,6,5,4,3},{18,17,16,15,14,13,12,11,10,9,16,15,14,13,12,11,10,9,8,7,15,14,13,12,11,10,9,8,7,6,13,12,11,10,9,8,7,6,5,4,12,11,10,9,8,7,6,5,4,3,10,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,0,11,10,9,8,7,6,5,4,3,2},{11,12,13,14,15,16,17,18,19,20,9,10,11,12,13,14,15,16,17,18,8,9,10,11,12,13,14,15,16,17,6,7,8,9,10,11,12,13,14,15,5,6,7,8,9,10,11,12,13,14,3,4,5,6,7,8,9,10,11,12,2,3,4,5,6,7,8,9,10,11,0,1,2,3,4,5,6,7,8,9},{12,13,14,15,16,17,8,19,20,19,10,11,12,13,14,15,16,17,18,17,9,10,11,12,13,14,15,16,17,16,7,8,9,10,11,12,13,14,15,14,6,7,8,9,10,11,12,13,14,13,4,5,6,7,8,9,10,11,12,11,3,4,5,6,7,8,9,10,11,10,1,0,1,2,3,4,5,6,7,8},{13,14,15,16,17,18,19,20,19,18,11,12,13,14,15,16,17,18,17,16,10,11,12,13,14,15,16,17,16,15,8,9,10,11,12,13,14,15,14,13,7,8,9,10,11,12,13,14,13,12,5,6,7,8,9,10,11,12,11,10,4,5,6,7,8,9,10,11,10,9,2,1,0,1,2,3,4,5,6,7},{14,15,16,17,18,19,20,19,18,17,12,13,14,15,16,17,18,17,16,15,11,12,13,14,15,16,17,16,15,14,9,10,11,12,13,14,15,14,13,12,8,9,10,11,12,13,14,13,12,11,6,7,8,9,10,11,12,11,10,9,5,6,7,8,9,10,11,10,9,8,3,2,1,0,1,2,3,4,5,6},{15,16,17,18,19,20,19,18,17,16,13,14,15,16,17,18,17,16,15,14,12,13,14,15,16,17,16,15,14,13,10,11,12,13,14,15,14,13,12,11,9,10,11,12,13,14,13,12,11,10,7,8,9,10,11,12,11,10,9,8,6,7,8,9,10,11,10,9,8,7,4,3,2,1,0,1,2,3,4,5},{16,17,18,19,20,19,18,17,16,15,14,15,16,17,18,17,16,15,14,13,13,14,15,16,17,16,15,14,13,12,11,12,13,14,15,14,13,12,11,10,10,11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,7,8,9,10,11,10,9,8,7,6,5,4,3,2,1,0,1,2,3,4},{17,18,19,20,19,18,17,16,15,14,15,16,17,18,17,16,15,14,13,12,14,15,16,17,16,15,14,13,12,11,12,13,14,15,14,13,12,11,10,9,11,12,13,14,13,12,11,10,9,8,9,10,11,12,11,10,9,8,7,6,8,9,10,11,10,9,8,7,6,5,6,5,4,3,2,1,0,1,2,3},{18,19,20,19,18,17,16,15,14,13,16,17,18,17,16,15,14,13,12,11,15,16,17,16,15,14,13,12,11,10,13,14,15,14,13,12,11,10,9,8,12,13,14,13,12,11,10,9,8,7,10,11,12,11,10,9,8,7,6,5,9,10,11,10,9,8,7,6,5,4,7,6,5,4,3,2,1,0,1,2},{19,20,19,18,17,16,15,14,13,12,17,18,17,16,15,14,13,12,11,10,16,17,16,15,14,14,13,12,11,10,9,14,15,14,13,12,11,10,9,8,7,13,14,13,12,11,10,9,8,7,6,11,12,11,10,9,8,7,6,5,4,10,11,10,9,8,7,6,5,4,3,8,7,6,5,4,3,2,1,0,1},{20,19,18,17,16,15,14,13,12,11,18,17,16,15,14,13,12,11,10,9,17,16,15,14,13,12,11,10,9,8,15,14,13,12,11,10,9,8,7,6,14,13,12,11,10,9,8,7,6,5,12,11,10,9,8,7,6,5,4,3,11,10,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,1,0}     ,{12,11,10,9,8,7,6,5,4,3,14,13,12,11,10,9,8,7,6,5,15,14,13,12,11,10,9,8,7,6,17,16,15,14,13,12,11,10,9,8,18,17,16,15,14,13,12,11,10,9,20,19,18,17,16,15,14,13,12,11,21,20,19,18,17,16,15,14,13,12,23,22,21,20,19,18,17,16,15,14}};
	static String [] ergParts = new String[parts.length];
	static String [] solutionParts = new String[parts.length];
	
	static int shortest = 10000;
	
	public static int getX(String a) {
		int x = 0;
		String getIt;
		getIt = a.substring(0, 2);
		x = Integer.parseInt(getIt);
		return x;
	}
	
	public static int getY(String a) {
		int y = 0;
		String getIt;
		getIt = a.substring(3, 5);
		y = Integer.parseInt(getIt);
		return y;
	}
	
	public static boolean checkDub(String[] folge) {
		boolean more = false;
		
		for(int i = 0; i < folge.length - 1; i++) {
			for(int a = i + 1; a < folge.length; a++) {
				if(folge[i].equals(folge[a])) {
					more = true;
				}
			}
		}
		return more;
	}
	
	public static void checkShort(String[] reihe) {
		int aktLength = 0;
		for(int i = 0; i < reihe.length - 1; i++) {
			if(reihe[i].equals("Start") ) {
				aktLength = aktLength + tour[80][regNum[(getX(reihe[i+1]))][  (getY(reihe[i+1])) -1]];
			}
			else if(reihe[i+1].equals("Ende")) {
				aktLength = aktLength + tour[80][regNum[(getX(reihe[i]))][  (getY(reihe[i])) -1]];
			}
			else {
				aktLength = aktLength + tour[regNum[(getX(reihe[i]))][(getY(reihe[i]))-1]][regNum[(getX(reihe[i+1]))][  (getY(reihe[i+1])) -1 ]];
			}
			
		}
		if(aktLength < shortest) {
			shortest = aktLength;
			for(int a = 0; a < ergParts.length; a++) {
				solutionParts[a] = reihe[a];
			}
		}
	}
	
	public static void kombi(String[] erg, int counter, int pos) {
		
		if(counter == parts.length ) {
			if(!checkDub(erg) && erg[parts.length-1].equals("Ende")) {
				for(int z = 0; z < parts.length; z++) {
					ergParts[z] = erg[z];
				}
				checkShort(ergParts);
			}	
		}
		else {
			for(int t = 0; t < parts.length; t++) {
				erg[pos] = parts[t];
				if(erg[0].equals("Start")) {
					
					kombi(erg, counter + 1, pos+1);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		String[] a = new String[parts.length];
		kombi(a,0, 0);
		System.out.println("ERG");
		for(int i = 0; i < solutionParts.length; i++) {
			System.out.println(solutionParts[i]);
		}
		System.out.println(shortest);
	}
	
}
