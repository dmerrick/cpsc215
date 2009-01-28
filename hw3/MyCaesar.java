/** 
	* Class for doing encryption and decryption using the Caesar Cipher.
	* With additions for homework exercises.
	*
	* @author Dana Merrick
	*/
public class MyCaesar {

	public static final int ALPHASIZE = 26; // English alphabet (uppercase only)
	public static final char[] alpha = {'A','B','C','D','E','F','G','H', 'I',
		'J','K','L','M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	protected char[] encrypt = new char[ALPHASIZE];  // Encryption array
	protected char[] decrypt = new char[ALPHASIZE];  // Decryption array

	/** Constructor that initializes the encryption and decryption arrays */
	public MyCaesar() {
		this("",24);
	}

	/** Constructor that initializes the encryption and decryption arrays
		* @param s a string to use as a key
		* @param n an int that represents the number of times to shift
    */
	public MyCaesar(String s, int n) {

		// start throwing arguement exceptions
		if (!s.equals(s.toUpperCase()))
			throw new KeywordException("string must be uppercase");

		if (s.length() >= 26)
			throw new KeywordException("string too long");

		// we'll end up using this array later
		char[] string = s.toUpperCase().toCharArray();

		for (int i=0;i<string.length;i++) {
			for (int j=0;j<string.length;j++) {
				if (i != j && string[i]==string[j])
					throw new KeywordException("string not distinct");
			}
		}

			if (n < 1 || n > 26)
			  throw new IntegerKeyException("integer must be between 1 and 26");

		// okay, we're ready to start working
		// if the string is the empty string, we can short circuit most of the code
		if (string.length == 0) {

      // this is essentially the constuctor from the Caesar class
			for (int i=0; i<ALPHASIZE; i++) 
				encrypt[i] = alpha[(i + ALPHASIZE+1-n) % ALPHASIZE]; // rotate alphabet by n places
			for (int i=0; i<ALPHASIZE; i++) 
				decrypt[encrypt[i] - 'A'] = alpha[i]; // decrypt is reverse of encrypt

		} else { // given string is not empty

      // set the first part of the encrypt string to the given string
			for (int i=0;i<string.length;i++) {
				encrypt[i]=string[i];
			}


      // newAlpha represents the intersection of the alphabet and s
			char[] newAlpha = new char[ALPHASIZE-s.length()+1];
      // we construct a mutable array here since alpha is declared final
			char[] mutable = alpha;

			// start building up newAlpha...
      // first, removing the chars that are in s
			for (int i=0;i<string.length;i++) {
				for (int j=i+1;j<mutable.length;j++) {
					if (string[i]==mutable[j]) {
            // set them to '{' so they'll be at the end when we sort
						mutable[j]='{'; // we'll look for this later
					}
				}
			}

      // now we no longer have duplicates from s, but we have {'s
      // so let's sort them so all of the {'s move to the back
			for (int i=0; i<mutable.length; i++) {
				for (int j=0; j<mutable.length-1-i; j++){
					if (mutable[j] > mutable[j+1]) {
						// swap the two elements
						char temp = mutable[j];
						mutable[j]=mutable[j+1];
						mutable[j+1]= temp;
					}
				}
			}

      // almost done with newAlpha!
      // now lets move everthing but the end a's into newArray
			for (int i=0;i<newAlpha.length-1;i++) {
				newAlpha[i] = mutable[i];
				System.out.println("DEBUG:\tnewAlpha["+i+"]="+mutable[i]);
			}
      // newAlpha should be finished now, so we can start doing the real work


      // fill in the rest of encrypt with newAlpha, shifting it as needed
			for (int i=s.length(); i<ALPHASIZE; i++) 
				encrypt[i] = newAlpha[((i-s.length())+n) % Math.abs(newAlpha.length-1)];

      // helpful debugging message to show what our encrypt array is
			for (int i=0;i<encrypt.length;i++) {
				System.out.println("DEBUG:\tencrypt["+i+"]="+encrypt[i]);
			}

      // here is where I have problems... for some reason it was never as
      // simple as using the line of code from the original example
			for (int i=0; i<ALPHASIZE; i++) 
				decrypt[i] = encrypt[ALPHASIZE-1-i]; // decrypt is reverse of encrypt
				//decrypt[encrypt[i] - 'A'] = alpha[i]; // this line _should_ work!
		}
	}

	/** Encryption method
   * @param secret the message to encrypt
   * @return the encrypted string
   */
	public String encrypt(String secret) {
		char[] mess = secret.toCharArray();     // the message array
		for (int i=0; i<mess.length; i++)       // encryption loop
			if (Character.isUpperCase(mess[i]))   // we have a letter to change
			mess[i] = encrypt[mess[i] - 'A'];   // use letter as an index
		return new String(mess).toUpperCase();
	}

	/** Decryption method
   * @param secret the encrypted string
   * @return the decrypted string
   */
	public String decrypt(String secret) {
		char[] mess = secret.toCharArray();     // the message array
		for (int i=0; i<mess.length; i++)       // decryption loop
			if (Character.isUpperCase(mess[i]))   // we have a letter to change
			mess[i] = decrypt[mess[i] - 'A'];   // use letter as an index
		return new String(mess).toLowerCase();
	}

	/**  Main method for testing the MyCaesar cipher */
	public static void main(String[] args) {
		MyCaesar cipher = new MyCaesar();           // Create a MyCaesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt).toLowerCase());
		String secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt(secret);
		System.out.println(secret);             // the ciphertext
		secret = cipher.decrypt(secret);
		System.out.println(secret);             // should be plaintext again
		System.out.println();


		cipher = new MyCaesar("BLUE",5);           // Create a MyCaesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt).toLowerCase());
		secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt(secret);
		System.out.println(secret);             // the ciphertext
		secret = cipher.decrypt(secret);
		System.out.println(secret);             // should be plaintext again
		System.out.println();


		cipher = new MyCaesar("HI",10);           // Create a MyCaesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt).toLowerCase());
		secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt(secret);
		System.out.println(secret);             // the ciphertext
		secret = cipher.decrypt(secret);
		System.out.println(secret);             // should be plaintext again
		System.out.println();


		cipher = new MyCaesar("DANMERICK",1);           // Create a MyCaesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt).toLowerCase());
		secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt(secret);
		System.out.println(secret);             // the ciphertext
		secret = cipher.decrypt(secret);
		System.out.println(secret);             // should be plaintext again
		System.out.println();

		cipher = new MyCaesar("FOBAR",7);           // Create a MyCaesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt).toLowerCase());
		secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt(secret);
		System.out.println(secret);             // the ciphertext
		secret = cipher.decrypt(secret);
		System.out.println(secret);             // should be plaintext again
		System.out.println();

		cipher = new MyCaesar("GOATS",20);           // Create a MyCaesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt).toLowerCase());
		secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = cipher.encrypt(secret);
		System.out.println(secret);             // the ciphertext
		secret = cipher.decrypt(secret);
		System.out.println(secret);             // should be plaintext again
		System.out.println();

    /* these cause exceptions
		cipher = new MyCaesar("augh",1);
		cipher = new MyCaesar("OHNO",1);
		cipher = new MyCaesar("ABCDEFGHIJKLMNOPQRSTUVWXYZA",1);
		cipher = new MyCaesar("PERFCT",0);
    */
		// an example exception
		cipher = new MyCaesar("GREAT",27);
	}

}

