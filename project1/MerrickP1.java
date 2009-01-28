public class MerrickP1 {
	public static void main(String argv[]) {

    /*
		ArraySequence<String> S = new ArraySequence<String>();

		S.addFirst("hello");
		System.out.println(S.getFirst());
    */

		System.out.println("\nDEBUG:\tinitial.txt\n");

	  // Problem 3.1: Initialize the text to be the same as the text given in initial.txt. 
		MyTextEditor text = new MyTextEditor();

		text.insertAfterCursor("Narnia...where the woods are thick and cool, where Talking Beasts are called to");
		text.insertAfterCursor("life, the land beyond the wardrobe, the secret country known only to Peter,");
		text.insertAfterCursor("Susan, Edmund, and Lucy. Narnia...where horses talk and hermits like company,");
		text.insertAfterCursor("where evil men turn into donkeys, where boys go into battle. ");
		text.insertAfterCursor("Narnia...the land between the lamp-post and the castle of Cair Paravel,");
		text.insertAfterCursor("where animals talk, where magical things happen,the world of wicked dragons ");
		text.insertAfterCursor("and magic spells, where the very best is brought out of even the worst people,");
		text.insertAfterCursor("where anything can happen(and most oftan does). ");
		text.insertAfterCursor("Narnia...where owls are wise, where some of the giants like to");
		text.insertAfterCursor("snack on humans (and, if carefully cooked, on Marsh-wiggles, too), ");
		text.insertAfterCursor("where a prince is put under an evil spell. ");
		text.insertAfterCursor("Narnia...where dwarfs are loyal and tough and strong-or are they?");

		// Problem 3.2: Print the text.
		text.print();

		// Problem 3.3: Use each and every method in the MyTextEditor class (except for print()) to convert
		// this text into the text given in middle.txt.

		System.out.println("\nDEBUG:\tmiddle.txt\n");

		// a silly loop to test some of the methods
		for(int i=0;i<text.size();i++) {
			text.moveCursorToLine(i);
			if (text.cursorLineNum() == 5)
				text.insertBeforeCursor("LINE NUMBER FIVE!");
			text.replaceAtCursor("");
		}

		// another silly loop for method testing
		text.moveCursorToLine(1);
		text.cursorUp();
		while(!text.isCursorAtLastLine()) {
			text.cursorDown();
			text.removeAtCursor();
		}

		if (!text.isEmpty()) // mainly to test isEmpty()
			text.insertAfterCursor("Hello, World!");

		// clear the array since we've been fooling with it
		text = new MyTextEditor();

		text.insertAfterCursor("Narnia... where the woods are thick and cool, where Talking Beasts are called to");
		text.insertAfterCursor("life, the land beyond the wardrobe, the secret country known only to Peter,");
		text.insertAfterCursor("Susan, Edmund, and Lucy. Narnia...where horses talk and hermits like company,");
		text.insertAfterCursor("where evil men turn into donkeys, where boys and girls go into battle. ");
		text.insertAfterCursor("");
		text.insertAfterCursor("Narnia... the land between the lamp-post and the castle of Cair Paravel,");
		text.insertAfterCursor("where animals talk, where magical things happen, the world of wicked deans ");
		text.insertAfterCursor("and magic spells, where the very best is brought out of even the worst people,");
		text.insertAfterCursor("where anything can happen(and most oftan does). ");
		text.insertAfterCursor("");
		text.insertAfterCursor("Narnia... where professors are wise, where some of the giants like to");
		text.insertAfterCursor("snack on students (and, if carefully cooked, on Marsh-wiggles, too), ");
		text.insertAfterCursor("where a prince is put under an evil spell. ");
		text.insertAfterCursor("");
		text.insertAfterCursor("Narnia... where dwarfs are loyal and tough and strong-or are they?");

		// Problem 3.4: Print the text. 
		text.print();

		// Problem 3.5: Use as many additional methods in the MyTextEditor class as needed to convert this text into the text given in final.txt.
    //
		System.out.println("\nDEBUG:\tfinal.txt\n");

		text.moveCursorToLine(0);
		text.replaceAtCursor("Narnia... where the woods are thick and cool, where Talking Beasts are called to");
		text.cursorDown();
		text.replaceAtCursor("life, the land beyond the wardrobe, the secret country known only to Peter,");
		text.cursorDown();
		text.replaceAtCursor("Susan, Edmund, and Lucy. ");
		text.cursorDown();
		text.replaceAtCursor("");
		text.cursorDown();
		text.replaceAtCursor("Narnia... where horses talk and hermits like company,");
		text.cursorDown();
		text.replaceAtCursor("where evil men turn into donkeys, where boys and girls go into battle. ");
		text.cursorDown();
		text.replaceAtCursor("");
		text.cursorDown();
		text.replaceAtCursor("Narnia... the land between the lamp-post and the castle of Cair Paravel,");
		text.cursorDown();
		text.replaceAtCursor("where animals talk, where magical things happen, the world of wicked deans ");
		text.cursorDown();
		text.replaceAtCursor("and magic spells, where the very best is brought out of even the worst people,");
		text.cursorDown();
		text.replaceAtCursor("where anything can happen (and most often does). ");
		text.cursorDown();
		text.replaceAtCursor("");
		text.cursorDown();
		text.replaceAtCursor("Narnia... where owls are wise, where some of the giants like to");
		text.cursorDown();
		text.replaceAtCursor("snack on students (and, if carefully cooked, on Marsh-wiggles, too), ");
		text.cursorDown();
		text.replaceAtCursor("where a prince is put under an evil spell. ");
		text.cursorDown();
		text.replaceAtCursor("");
		text.insertBeforeCursor("Narnia... where dwarfs are loyal and tough and strong---or are they really?");

		// Problem 3.6: Print the text.
		text.print();

		}
	}
