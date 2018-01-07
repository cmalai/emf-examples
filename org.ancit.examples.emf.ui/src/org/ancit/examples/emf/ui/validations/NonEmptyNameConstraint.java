package org.ancit.examples.emf.ui.validations;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import addressbook.AddressBook;
import addressbook.Contact;
import addressbook.Group;

public class NonEmptyNameConstraint extends AbstractModelConstraint {

	public NonEmptyNameConstraint() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		String name = null;
		if (eObj instanceof AddressBook) {
			AddressBook addressBook = (AddressBook) eObj;
			name = addressBook.getName();
			
		} else if (eObj instanceof Group) {
			Group addressBook = (Group) eObj;
			name = addressBook.getName();
			
		} else if (eObj instanceof Contact) {
			Contact addressBook = (Contact) eObj;
			name = addressBook.getName();
			
		}
		
		if (name == null || name.length() == 0) {
			return ctx.createFailureStatus(eObj.eClass().getName());
		}
		return ctx.createSuccessStatus();
	}

}
