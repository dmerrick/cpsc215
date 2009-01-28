/**
 * This class finds duplicates in an arbitrary number of integers.
 *
 * @auther Dana Merrick
 * @version 1.0, 01/24/2007
 * @see String
 */


public class FindDuplicates
{
	public static void main(String argv[])
	{
		// this is the array that holds the values we have already seen
		Boolean[] seen = new Boolean[argv.length];

		// initialize seen array as all false
		for(int k=0; k < seen.length; k++) {
			seen[k] = false;
		}


		// start looping through the argv array
		// caveat: argv contains strings!
		for(int i=0; i < argv.length; i++) {
			// the current number of occurances
			int count = 1; // starts at 1 because we've seen one already

			// loop through the rest of the array
			for(int j=i+1; j < argv.length; j++) {

				/*
				// debugging messages
				System.out.println("i = " + i);
				System.out.println("j = " + j);
				System.out.println("argv[i] = " + argv[i]);
				System.out.println("argv[j] = " + argv[j]);
				System.out.println("count = " + count);
				System.out.println();
				//end debugging messages
				*/
			
				// increase the count if we find a duplicate that hasn't been seen
				if (argv[i].equals(argv[j]) && !seen[Integer.parseInt(argv[i])]) {
					++count;
				}//if
			}//for j

			// display output if we've found multiple occurances
			if (count > 1) {
				System.out.println("There are " + count + " copies of " + argv[i]);
				// we've seen this int, so set the seen array to true
				seen[Integer.parseInt(argv[i])] = true;
			}

		}//for i
	} //main()
} //FindDuplicates
