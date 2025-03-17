import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] Alice = br.readLine().split(" ");
		String[] Bob = br.readLine().split(" ");
		
		int alice = 0;
		int bob = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(Alice[i]) > Integer.parseInt(Bob[i])) {
				if (Integer.parseInt(Alice[i]) - Integer.parseInt(Bob[i]) == 7) {
					bob += 3;
					alice -= 1;
				} else {
					alice += 2;
				}
			} else if (Integer.parseInt(Alice[i]) < Integer.parseInt(Bob[i])){
				if (Integer.parseInt(Bob[i]) - Integer.parseInt(Alice[i]) == 7) {
					alice += 3;
					bob -= 1;
				} else {
					bob += 2;
				}
			} else {
				alice += 1;
				bob += 1;
			}
		}
		
		bw.write(alice + " " + bob + "\n");
		bw.flush();
	}
}