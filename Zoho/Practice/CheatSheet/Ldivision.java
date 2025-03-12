	public class Ldivision{
		public static void main(String args[]){
			// System.out.println(bin(10));
			// System.out.println(bin(48));

			//hex stuff
			String hexCode = "1AC5";
			// System.out.println(hexToBinf(hexCode));

			//bin stuff

			System.out.println("Hex code:"+hexCode);
			System.out.println("Hex to Bin:");
			String bin = hexToBinf(hexCode);
			System.out.println(bin);

			System.out.println("Bin to Hex:");
			System.out.println(binToHex(bin));
		}

		public static int bin(int n){
			if(n == 1) return 1;
			int rem = n%2;
			return (bin(n/2)*10)+rem;
		}

		public static String hexToBin(String hcode){

			StringBuilder res = new StringBuilder();
			for(int i=0;i<hcode.length();i++){
				if(hcode.charAt(i) <= 57 && hcode.charAt(i)>=48){

					//new learning!=> Integer.toString() -> convert num to string
					res.append(Integer.toString(bin(Integer.parseInt(hcode.charAt(i)+""))));
				}
				else{
					int val = hcode.charAt(i) - 55;
					res.append(bin(val)+"");
				}
			}

			return res.toString();
		}

		public static String hexToBinf(String hcode){

			StringBuilder res = new StringBuilder();

			for(int i=0;i<hcode.length();i++){
				int val;
				if(hcode.charAt(i) >= '0' && hcode.charAt(i) <= '9'){
					val = hcode.charAt(i)-'0';
				}
				else{
					val = hcode.charAt(i) - 55;
				}
				res.append(String.format("%04d",bin(val)));
			}

			return res.toString();
		}

		public static String binToHex(String bin){
			StringBuilder res = new StringBuilder();

			for(int i=0;i<bin.length();i+=4){
				String bits = bin.substring(i, i+4);

				// Integer.parseInt('stringNum','radix(base to convert)')
				int val = Integer.parseInt(bits,2);
				if(val >=0 && val <=9){
					res.append(Integer.toString(val));
				}
				else{
					res.append((char)(val+55));
				}
			}
			return res.toString();
		}


	}