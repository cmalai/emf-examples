/**
 */
package addressbook.impl;

import addressbook.AddressbookPackage;
import addressbook.Contact;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link addressbook.impl.ContactImpl#getName <em>Name</em>}</li>
 *   <li>{@link addressbook.impl.ContactImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link addressbook.impl.ContactImpl#getMobileno <em>Mobileno</em>}</li>
 *   <li>{@link addressbook.impl.ContactImpl#getEmailid <em>Emailid</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContactImpl extends MinimalEObjectImpl.Container implements Contact {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMobileno() <em>Mobileno</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobileno()
	 * @generated
	 * @ordered
	 */
	protected static final String MOBILENO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMobileno() <em>Mobileno</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobileno()
	 * @generated
	 * @ordered
	 */
	protected String mobileno = MOBILENO_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmailid() <em>Emailid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailid()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAILID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmailid() <em>Emailid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailid()
	 * @generated
	 * @ordered
	 */
	protected String emailid = EMAILID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AddressbookPackage.Literals.CONTACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AddressbookPackage.CONTACT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AddressbookPackage.CONTACT__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMobileno() {
		return mobileno;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMobileno(String newMobileno) {
		String oldMobileno = mobileno;
		mobileno = newMobileno;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AddressbookPackage.CONTACT__MOBILENO, oldMobileno, mobileno));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmailid() {
		return emailid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailid(String newEmailid) {
		String oldEmailid = emailid;
		emailid = newEmailid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AddressbookPackage.CONTACT__EMAILID, oldEmailid, emailid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AddressbookPackage.CONTACT__NAME:
				return getName();
			case AddressbookPackage.CONTACT__ADDRESS:
				return getAddress();
			case AddressbookPackage.CONTACT__MOBILENO:
				return getMobileno();
			case AddressbookPackage.CONTACT__EMAILID:
				return getEmailid();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AddressbookPackage.CONTACT__NAME:
				setName((String)newValue);
				return;
			case AddressbookPackage.CONTACT__ADDRESS:
				setAddress((String)newValue);
				return;
			case AddressbookPackage.CONTACT__MOBILENO:
				setMobileno((String)newValue);
				return;
			case AddressbookPackage.CONTACT__EMAILID:
				setEmailid((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AddressbookPackage.CONTACT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AddressbookPackage.CONTACT__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case AddressbookPackage.CONTACT__MOBILENO:
				setMobileno(MOBILENO_EDEFAULT);
				return;
			case AddressbookPackage.CONTACT__EMAILID:
				setEmailid(EMAILID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AddressbookPackage.CONTACT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AddressbookPackage.CONTACT__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case AddressbookPackage.CONTACT__MOBILENO:
				return MOBILENO_EDEFAULT == null ? mobileno != null : !MOBILENO_EDEFAULT.equals(mobileno);
			case AddressbookPackage.CONTACT__EMAILID:
				return EMAILID_EDEFAULT == null ? emailid != null : !EMAILID_EDEFAULT.equals(emailid);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", address: ");
		result.append(address);
		result.append(", mobileno: ");
		result.append(mobileno);
		result.append(", emailid: ");
		result.append(emailid);
		result.append(')');
		return result.toString();
	}

} //ContactImpl
