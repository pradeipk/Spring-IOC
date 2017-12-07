package com.pradeip.spring;

public class TextEditor {
	   private SpellChecker spellChecker;
	   private Integer val;

	   /**
	    * Define a constructor 
	    * @param spellChecker
	    */
	   public TextEditor(SpellChecker spellChecker,Integer val) {
	      System.out.println("Inside TextEditor constructor." );
	      this.spellChecker = spellChecker;
	      this.val = val;
	   }
	   public void spellCheck() {
	      spellChecker.checkSpelling();
	      System.out.println("val :"+ val);
	   }
	}