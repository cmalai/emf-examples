package org.ancit.examples.emf.edit.extensions;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import addressbook.provider.AddressbookItemProviderAdapterFactory;

public class AddressbookItemProviderAdapterFactoryExtension extends AddressbookItemProviderAdapterFactory {
	
	public AddressbookItemProviderAdapterFactoryExtension() {
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(IItemColorProvider.class);
		supportedTypes.add(ITableItemColorProvider.class);
	}

	@Override
	public Adapter createContactAdapter() {
		if(contactItemProvider == null) {
			contactItemProvider = new ContactItemProviderExtension(this);
		}
		return contactItemProvider;
	}
}
