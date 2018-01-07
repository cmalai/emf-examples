package org.ancit.examples.emf.edit.extensions;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import addressbook.Contact;
import addressbook.provider.ContactItemProvider;

public class ContactItemProviderExtension extends ContactItemProvider implements ITableItemLabelProvider {

	public ContactItemProviderExtension(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getColumnText(Object object, int columnIndex) {
		String result = new String();
		Contact contact = (Contact)object;
		switch (columnIndex) {
		case 0:
			result = contact.getName();
			break;
		case 1:
			result = contact.getAddress();
			break;
		case 2:
			result = contact.getMobileno();
			break;
		case 3:
			result = contact.getEmailid();
			break;

		default:
			break;
		}
		return result;
	}

}
