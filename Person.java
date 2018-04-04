import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.*;


public class Person {
	
	public  String name ;
	public KeyPair keys;
	public String txnid = "";
	public String mySig ="";
	public String transString = "";
	
	
	
	private static List<Person> allPersons = new ArrayList<Person>();
	public static List<Person> getPersons() {
		return allPersons;
	}


public Person (String name1, KeyPair myPair ) {
	this.name = name1;
	this.keys = myPair;
	allPersons.add(this);

}


public Person() {
	// TODO Auto-generated constructor stub
}


public void setTxnid(String id) {
	
	this.txnid = id;
}
public void setSig(String sig) {
	
	this.mySig = sig;
}
public String getSig() {
	
	return mySig;
}
public String getTxnid() {
	
	return txnid;
}

//by txid
public static Person getPerson(String n) {
	for (int i = 0; i < allPersons.size();i++) {
		if (allPersons.get(i).getTxnid().equals(n)) {
			return allPersons.get(i);
		}
	}
	return null;
	
}


public static Person getPersonName(String n) {
	for (int i = 0; i < allPersons.size();i++) {

		if (allPersons.get(i).getName().equals(n)) {
			return allPersons.get(i);
		}
	}
	return null;
	
}



public String getName() {
	return name;
}
public KeyPair getKeyPair() {
	return keys;
}


public void setTransationString(String transactionString) {
this.transString = transactionString;
	
}

}


