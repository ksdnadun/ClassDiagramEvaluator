package com.research.classdiagramevaluator.service.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.utilities.ExpressionInOCL;

public class Test {
	
//	public EList getBooks()
//	  {
//	    if (books == null)
//	    {
//	      books = new EObjectWithInverseResolvingEList(Book.class, this,
//	                    LibraryPackage.WRITER__BOOKS, LibraryPackage.BOOK__AUTHOR);
//	    }
//	    return books;
//	  }
//	
//	private void test() {
//		OCL ocl = OCL.newInstance(new PivotEnvironmentFactory());
//		OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);
//		ExpressionInOCL invariant = helper.createInvariant(
//		    "books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
//		ExpressionInOCL query = helper.createQuery(
//		    "books->collect(b : Book | b.category)->asSet()");
//
//		// create a Query to evaluate our query expression
//		Query queryEval = ocl.createQuery(query);
//		// create another to check our constraint
//		Query constraintEval = ocl.createQuery(invariant);
//
//		List<Library> libraries = getLibraries();  // hypothetical source of libraries
//		// only print the set of book categories for valid libraries
//		for (Library next : libraries) {
//		   if (constraintEval.check(next)) {
//		      // the OCL result type of our query expression is Set(BookCategory)
//		      @SuppressWarnings("unchecked")
//		      Set<BookCategory> categories = (Set<BookCategory>) queryEval.evaluate(next);
//
//		      System.out.printf("%s: %s%n", next.getName(), categories);
//		   }
//		}
//	}

}
