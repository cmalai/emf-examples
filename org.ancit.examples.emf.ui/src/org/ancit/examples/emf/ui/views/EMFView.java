package org.ancit.examples.emf.ui.views;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import addressbook.AddressBook;
import addressbook.AddressbookFactory;
import addressbook.Contact;
import addressbook.Group;
import addressbook.provider.AddressbookItemProviderAdapterFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;

public class EMFView extends ViewPart {
	
	public static final String ID = "org.ancit.examples.emf.ui.views.EMFView";
	
	@Inject IWorkbench workbench;

	private ComposedAdapterFactory adapterFactory;

	private TreeViewer treeViewer;

	private AddressBook book;

	private AdapterFactoryEditingDomain editingDomain;

	public EMFView() {
		createActions();
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory.addAdapterFactory(new AddressbookItemProviderAdapterFactory());
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
	}
	private void createActions() {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		{
			loadAction = new Action("Load") {				@Override
				public void run() {
					FileDialog fDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
					String filePath = fDialog.open();
					
					if(filePath != null) {
						try {
							Resource resource = editingDomain.getResourceSet().createResource(URI.createFileURI(filePath));
							resource.load(null);
							book = (AddressBook) resource.getContents().get(0);
							treeViewer.setInput(book);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			};
			loadAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UP));
		}
		{
			saveAction = new Action("Save") {				@Override
				public void run() {
					if(book.eResource() == null) {
						FileDialog fDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
						String filePath = fDialog.open();
						
						if(filePath != null) {
							try {
								Resource resource = editingDomain.getResourceSet().createResource(URI.createFileURI(filePath));
								resource.getContents().add(book);
								resource.save(null);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} else {
						try {
							book.eResource().save(null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			saveAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setInput(initiateModel());
		
		getSite().setSelectionProvider(treeViewer);
		
		fillActionBars();
		hookContextMenu();
	}

	private void fillActionBars() {
		getViewSite().getActionBars().getMenuManager();
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(loadAction);
		toolBarManager.add(saveAction);
		
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				Collection<?> newChildDescriptors = editingDomain.getNewChildDescriptors(book, null);
				for (Object object : newChildDescriptors) {
					CreateChildAction action = new CreateChildAction(editingDomain, new StructuredSelection(book), object);
					manager.add(action);
				}
			}
		});
		
		Menu contextMenu = menuMgr.createContextMenu(treeViewer.getTree());
		treeViewer.getTree().setMenu(contextMenu);
	}
	
	ExtendedPropertySheetPage propertySheetPage = null;
	private Action loadAction;
	private Action saveAction;
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if(adapter.equals(IPropertySheetPage.class)) {
			if(propertySheetPage == null) {
				propertySheetPage = new ExtendedPropertySheetPage(editingDomain);
				propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
			}
			return (T) propertySheetPage;
		}
		return super.getAdapter(adapter);
	}

	private AddressBook initiateModel() {
		book = AddressbookFactory.eINSTANCE.createAddressBook();
		book.setName("Malai's World");
		
		Group group = AddressbookFactory.eINSTANCE.createGroup();
		group.setName("Friends");
		
		Contact contact = AddressbookFactory.eINSTANCE.createContact();
		contact.setName("Michael");
		
		book.getGroups().add(group);
		book.getContacts().add(contact);
		
		group.getContacts().add(contact);
		
		return book;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
